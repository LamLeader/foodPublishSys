package com.tool;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.IOUtils;

import com.uitls.TypeSwitch;

import ch.ethz.ssh2.ChannelCondition;
import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.StreamGobbler;


public class RemoteShellExecutor {
	
	private Connection conn;
	/** 远程机器IP */
	private String ip;
	/** 用户名 */
	private String osUsername;
	/** 密码 */
	private String password;
	private String charset = Charset.defaultCharset().toString();

	private static final int TIME_OUT = 1000 * 5 * 60;

	/**
	 * 构造函数
	 * 
	 * @param ip
	 * @param usr
	 * @param pasword
	 */
	public RemoteShellExecutor(String ip, String usr, String pasword) {
		this.ip = ip;
		this.osUsername = usr;
		this.password = pasword;
	}

	/**
	 * 登录
	 * 
	 * @return
	 * @throws IOException
	 */
	private boolean login() throws IOException {
		conn = new Connection(ip);
		conn.connect();
		return conn.authenticateWithPassword(osUsername, password);
	}
	/**
	 * 磁盘
	 * @param result
	 */
    public List<List<String>> diskSubCount(String[] result,String ip,String diskPath){
    	List<List<String>> lists=new ArrayList<List<String>>();
    	try {
    		Set<String> set=new HashSet<String>();
    		for (int i = 0; i < result.length; i++) {
			    // /dev  Mem:  %Cpu(s): 
				if (result[i].toString().startsWith(diskPath)) {
					String[] str1 = result[i].trim().split(" ");
					List<String> newstr = new ArrayList<String>();
					for (int j = 0; j < str1.length; j++) {
						if (!str1[j].toString().trim().equals("")) {
							newstr.add(str1[j]);
						}
					}
					if (set.add(newstr.get(0))) {
						lists.add(newstr);
					}
				}
    		}
    		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	return  lists;
    }
    /**
	 * 磁盘(应用占用)
	 * @param result
	 */
    public List<List<String>> diskTomcatSubCount(String[] result){
    	List<List<String>> lists=new ArrayList<List<String>>();
    	String str2=null;
		List<String> newstr=new ArrayList<String>();
    	try {
    		for (int i = 0; i < result.length; i++) {
    		    str2 =result[i].toString().trim().replaceAll(" +",""); 
    		    String[] segments = str2.split("\t"); //按tab分割
    			boolean bol= str2.startsWith(TypeSwitch.getNumber(str2)+"G");
    			if (bol) {
    				//System.out.println("-----------str23-------:"+str2);
    				for (int r = 0; r < segments.length; r++) {
    					//偶数存应用占用的磁盘值 奇数存 存占用磁盘应用名称
						//System.out.println("第"+r+"个，存占用磁盘数值 ："+segments[r]);
						newstr.add(segments[r]);
    				}
    			   }
    			}
    		   lists.add(newstr);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	/*for (int i = 0; i < lists.size(); i++) {
			System.out.println("lisys:"+lists.get(i));
		}*/
    	return  lists;
    }
    /**
	 * 内存
	 * @param result
	 */
    public List<List<String>> memSubCount(String[] result){
    	List<List<String>> lists=new ArrayList<List<String>>();
    	try {
    		Set<String> set=new HashSet<String>();
    		for (int i = 0; i < result.length; i++) {
    			// /dev  Mem:  %Cpu(s):
    			if (result[i].toString().startsWith("-/+ buffers/cache:")) {
    				String[] str1 = result[i].trim().split(" ");
    				List<String> newstr = new ArrayList<String>();
    				for (int j = 0; j < str1.length; j++) {
    					if (!str1[j].toString().trim().equals("")) {
    						newstr.add(str1[j]);
    					}
    				}
    				if (set.add(newstr.get(0))) {
    					lists.add(newstr);
    				}
    			}
    		}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	return  lists;
    }
    /**
	 * cpu
	 * @param result
	 */
    public  List<List<String>>  cpuSubCount(String[] result){
    	List<List<String>> lists=new ArrayList<List<String>>();
    	try {
    		Set<String> set=new HashSet<String>();
    		for (int i = 0; i < result.length; i++) {
    			// /dev  Mem:  %Cpu(s):
    			if (result[i].toString().startsWith("Cpu")) {
    				String[] str1 = result[i].trim().split(",");
    				List<String> newstr = new ArrayList<String>();
    				for (int j = 0; j < str1.length; j++) {
    					if (!str1[j].toString().trim().equals("")) {
    						newstr.add(str1[j]);
    					}
    				}
    				if (set.add(newstr.get(0))) {
    					lists.add(newstr);
    				}
    			}
    		}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	return lists;
    }
	/**
	 * 执行脚本
	 * @param cmds
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> exec(String cmds,String ip,String diskPath) throws Exception {
		Map<String, Object> map =new HashMap<String, Object>();
		InputStream stdOut = null;
		InputStream stdErr = null;
		String outStr = "";
		String outErr = "";
		int ret = -1;
		try {
			if (login()) {
				// Open a new {@link Session} on this connection
				ch.ethz.ssh2.Session session = conn.openSession();
				// Execute a command on the remote machine.
				((ch.ethz.ssh2.Session) session).execCommand(cmds);
				stdOut = new StreamGobbler(((ch.ethz.ssh2.Session) session).getStdout());
				outStr = processStream(stdOut, charset);
				stdErr = new StreamGobbler(((ch.ethz.ssh2.Session) session).getStderr());
				outErr = processStream(stdErr, charset);
				((ch.ethz.ssh2.Session) session).waitForCondition(ChannelCondition.EXIT_STATUS, TIME_OUT);
				String[] result = outStr.split("\n");
				 List<List<String>> diskSubCountList=  diskSubCount(result,ip,diskPath);//调用方法处理分割数据 磁盘
				 List<List<String>> memSubCountList=memSubCount(result);//调用方法处理分割数据 内存
				 List<List<String>> cpuSubCountList=cpuSubCount(result);//调用方法处理分割数据 cpu
				 List<List<String>> diskTomcatSubCount=diskTomcatSubCount(result);//调用方法处理分割数据 磁盘中的应用占用情况
				 
				 
				 map.put("cpuSubCountList", cpuSubCountList);
				 map.put("diskSubCountList", diskSubCountList);
				 map.put("memSubCountList", memSubCountList);
				 map.put("diskTomcatSubCount", diskTomcatSubCount);
			
				ret = ((ch.ethz.ssh2.Session) session).getExitStatus();// 0表示成功
			} else {
				throw new Exception("登录远程机器失败" + ip); // 自定义异常类 实现略
			}
		} finally {
			if (conn != null) {
				conn.close();
			}
			IOUtils.closeQuietly(stdOut);
			IOUtils.closeQuietly(stdErr);
		}
		return map;
	}

	/**
	 * @param in
	 * @param charset
	 * @return
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 */
	private String processStream(InputStream in, String charset) throws Exception {
		byte[] buf = new byte[1024];
		StringBuilder sb = new StringBuilder();
		while (in.read(buf) != -1) {
			sb.append(new String(buf, charset));
		}
		return sb.toString();
	}

	public static void main(String args[]) throws Exception {
		
		
		
	}

}