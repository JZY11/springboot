package cn.itcast.springboot.javaconfig;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Date应用实例展示
 * @author Administrator
 *
 */
public class DateBirthday {

	public static void main(String[] args) throws ParseException, InterruptedException {
		// TODO Auto-generated method stub
		//球两个人的生日差了多少天
		String birthday1="1996-09-18";
		String birthday2="1993-08-27";
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date1 = format1.parse(birthday1); // 将字符串转换为时间
		Date date2 = format1.parse(birthday2);
		long s1 = date1.getTime();	// 获取时间（单位为毫秒  是long类型）
		long s2 = date2.getTime();
		long s3 = s1 - s2;						// s系列都是long类型的  单位是毫秒
		int day = Math.abs((int)(s3/1000/60/60/24));
		System.out.println("两人相差" + day + "天");
		
		
		//每间隔两秒显示一次时间
		while (true) {
			new Thread();
			Thread.sleep(2000);
			Date date = new Date();
			SimpleDateFormat format3=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time=format3.format(date);
			System.out.println(time);
		}
	}

}
