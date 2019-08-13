package ssmMaven;

/*import org.junit.Test;
import org.junit.runner.RunWith;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.service.IntegralService;


/**
 * Spring的测试类
 * @author PSW
 *
 */
/*@RunWith(SpringJUnit4ClassRunner.class)*/
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class MyBatisTest {
	
	@Autowired
	private IntegralService iTimingScheduleSer1;
	
	
	/*@Test*/
	public void queryTimingSchedule(){
		/* TimingSchedule timingSchedule=new TimingSchedule();
		 List<TimingSchedule> list =iTimingScheduleSer1.queryTimingSchedule(timingSchedule);*/
        /* for (int i = 0; i < list.size(); i++) {
         	int hour1=list.get(i).gettHour();
         	System.out.println("hour1:"+hour1);
 		}*/
	}
	  
	public static void main(String[] args) {
		/*String str="10G 8090NGPortal 10G8090NGPortal";
		//String str="10G8090NGPortal";
		String str2=str.replaceAll(" +",""); 
		String str3="";
		str3=TypeSwitch.getNumber(str2);
		boolean bol= str.startsWith(TypeSwitch.getNumber(str2)+"G"+" ");
		System.out.println("字符2："+str3);
		if(bol){
			String [] arr = str.split("\\s+");
			if(arr.length>0){
				for(String ss : arr){
				    System.out.println("分割后字符："+ss);
				}
			}
		}*/
		/*String str = "aaa bbb ccc ddd eee";
	    System.out.println(str.substring(str.lastIndexOf(" ") + 1));
	    String a="2.0G574M1.4G30%/home";
	    String str3="";
		str3=TypeSwitch.getNumber(a);
		System.out.println("分割后字符："+str3);*/
		int r=1;
		if(r%2==1){
			System.out.println("奇数");
		}else{
			System.out.println("偶数");
		}
		
		
	}
	
	
	

}
