package com.tool;

import com.tool.SendMessageStub.SendMessage;
import com.tool.SendMessageStub.SendMessageResponseE;

public class SendMsg {
	/**
	 * 下发短信
	 * @param mobile
	 * @param message
	 */
	public static void sendMessage(String mobile,String message){
		String url="http://10.243.67.35:18090/ResourcesScheduler/ws/SendMessage";
		try {  
			SendMessageStub stub = new  SendMessageStub(url);
			SendMessageStub.SendMessageE method= new SendMessageStub.SendMessageE();
			SendMessage param = new SendMessage();
			param.setArg0(mobile);
			param.setArg1(message);
			method.setSendMessage(param);
			SendMessageResponseE response = stub.sendMessage(method);
			String result=response.getSendMessageResponse().get_return();
			System.out.println(result);
	    } catch (Exception e) {  
	        e.printStackTrace();  
	    }  
	}  
	/**
	 * 短信下发测试
	 * @param args   	18856061699  朱蕾
	 */
	public static void main(String[] args) {
		//SendMsg.sendMessage("18856061699", "---测试信息服务器信息---");
		SendMsg.sendMessage("15922447372","主机："+"182.255.23.1"+"cpu阀值告警,cpu使用比例使用超过："+0.2+"预警值");
	}
}
