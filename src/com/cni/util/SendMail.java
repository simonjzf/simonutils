package com.cni.util;

import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class SendMail {

	
public static void main(String[] args) throws ParseException {
		
		List<String> listTo = new ArrayList<String>();
		listTo.add("sandjzf@hotmail.com");
		System.out.println(SendMail.SendMail(listTo, "88888", "ininin"));
}
		
	public static int SendMail(List<String> listTo,String subject,String reportUrl) {
		try {
			HtmlEmail email = new HtmlEmail();

			email.setHostName("192.168.100.118");		
			email.setCharset("UTF-8");	
			email.setFrom("zol_mes@cni.local","ZOL_MES System Mail");
			for (int i = 0; i < listTo.size(); i++) {
				email.addTo(listTo.get(i));
			}
			email.addBcc("simon.jia@cni.local");
			
			email.setSubject(subject);

			URL url = new URL("http://zolmes.cni.local/images/logo_report.gif");
			String log = email.embed(url, "zol-Logo");

			email.setHtmlMsg("<html><body ><table border=\'0\' bgcolor=\'#0099CC\' cellspacing=\'0\' cellpadding=\'0\' width=\'720\' >"
					+ "<tr><td height=\'68\' colspan=\'3\'><img src=\'cid:"
					+ log
					+ "\'></td></tr>"
					+ "<tr><td width=\'100\' valign=\'top\'>&nbsp;</td>"
					+ "<td width=\'520\'  valign=\'middle\' style=\'font-size:12px; color:white;\'><br><br><br>欢迎您使用 ZOLTRIX MES 报表订阅功能！ <br><br>"
					+ "如下是您订阅的报表文件，请点击下载<br>"
					+ "----------------------------<br>"
					+ "<a href=\'http://zolmes.cni.local/document/Excel/report/"+ reportUrl  + "\'>"
//					+ "<a href=\'http://192.168.12.5:7009/document/Excel/report/"+ reportUrl  + "\'>"
					+ reportUrl+"</a>"
					+ "<br>"
					+ "----------------------------<br>"	
					+ "Powered by CNI ITD  "
					+ "<td width=\'100\' valign=\'top\'>&nbsp;</td></tr>"
					+ "<tr><td height=\'68\' colspan=\'3\'></td></tr></table></body></html>");
			email.send();

		} catch (EmailException e) {
			e.printStackTrace();
			System.out.println(e.toString());
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
			return 0;
		}
		return 1;
	}
	
	public static int sendMailResetPw(String emailAdd,String username,String password){
		
		try {

		HtmlEmail email = new HtmlEmail();

		email.setHostName("192.168.110.55");
		//email.setHostName("smtp.sina.com");
		//email.setAuthentication("OTMSADMIN", "otmsadmin2153");
		email.setCharset("UTF-8");		
		
		//email.setFrom("OtmsAdmin@sina.com");
		email.setFrom("mes@cni.local", "MES System Mail");
//		email.addTo(emailAdd);
		email.addBcc("simon.jia@cni.local");
		email.setSubject("MES auto report");

		URL url1 = new URL("http://zolmes.cni.local/images/logo.jpg");
		URL url2 = new URL("http://zolmes.cni.local/images/logo.png");
		
		String l1 = email.embed(url1, "Lenovo-Logo");
		String l2 = email.embed(url2, "OTMS-Logo");
		

			
			email.setHtmlMsg("<html><body ><table border=\'0\' bgcolor=\'#0099CC\' cellspacing=\'0\' cellpadding=\'0\' width=\'720\' >"
	+"<tr><td height=\'68\' colspan=\'3\'><img src=\'cid:"+l1+"\'></td></tr>"
	+"<tr><td width=\'100\' valign=\'top\'>&nbsp;</td>"
	+"<td width=\'520\'  valign=\'middle\' style=\'font-size:12px; color:white;\'><br><br><br><br>欢迎您加入 OTMS 网站！ <br><br>"
	+"您的 OTMS 账号已经成功创建！ 请妥善保留此邮件. 您的帐号资料如下:<br>"
	+"----------------------------<br>"
	+"帐号: "+username+"<br>"
	+"密码: "+password+"<br>"
	+"----------------------------<br>"
	+"如果您忘记了密码，可以在用户登录页面通过“重置密码”的链接，重置您的密码。 <br>"
	+"如果您想修改密码，可以在登录成功页面通过“更改密码”的链接，修改您的密码。 <br><br>"
	+"您有任何问题，可以联系: <a href=\'mailto:OtmsAdmin@sina.com\'>OtmsAdmin@sina.com</a><br>"
	+"欢迎您进入 OTMS 首页面: <a href=\'http://www.otms.com/mfgotv2/\'>http://www.otms.com/</a><br><br> </td>"
	+"<td width=\'100\' valign=\'top\'>&nbsp;</td></tr>"
	+"<tr><td height=\'68\' colspan=\'3\'><br><img src=\'cid:"+l2+"\'></td>"
	+"</tr></table></body></html>");
			email.send();
			
		}catch (EmailException  e) {
			e.printStackTrace();
			System.out.println(e.toString());
			return 0;
		}catch (Exception e) {
			System.out.println("--------------------------------");
		}
		return 1;

	}
	
	
	public static int sendMailChangePw(String emailAdd,String username,String password){
		
		try {

		HtmlEmail email = new HtmlEmail();

		email.setHostName("smtp.sina.com");
		email.setAuthentication("OTMSADMIN", "otmsadmin2153");
		email.setCharset("UTF-8");		
		
			email.setFrom("OTMSADMIN@sina.com","IRMS");
			email.addTo(emailAdd);
//			email.addBcc("OtmsAdmin@sina.com");
			email.setSubject("Confidential: OTMS Password Changed Successful ");

//			URL url1 = new URL("http://www.otms.com/mfgotv2/img/lenovo-logo.gif");
//			URL url2 = new URL("http://www.otms.com/mfgotv2/img/main_logo.gif");
			
//			String l1 = email.embed(url1, "Lenovo-Logo");
//			String l2 = email.embed(url2, "OTMS-Logo");
	

			
			email.setHtmlMsg("<html><body ><table border=\'0\' bgcolor=\'#0099CC\' cellspacing=\'0\' cellpadding=\'0\' width=\'720\' >"
	+"<tr><td height=\'68\' colspan=\'3\'>" 
//	+ "<img src=\'cid:"+l1+"\'>" +
	+"</td></tr>"
	+"<tr><td width=\'100\' valign=\'top\'>&nbsp;</td>"
	+"<td width=\'520\'  valign=\'middle\' style=\'font-size:12px; color:white;\'><br><br>O(∩_∩)O~<br><br>欢迎您光临 OTMS 网站！ <br><br>"
	+"您的 OTMS 账号信息已经更新成功！ 请妥善保留此邮件. 您的帐号资料如下:<br>"
	+"----------------------------<br>"
	+"帐号: "+username+"<br>"
	+"密码: "+password+"<br>"
	+"----------------------------<br>"
	+"如果您忘记了密码，可以在用户登录页面通过“重置密码”的链接，重置您的密码。 <br>"
	+"如果您想修改密码，可以在登录成功页面通过“更改密码”的链接，修改您的密码。 <br><br>"
	+"您有任何问题，可以联系: <a href=\'mailto:OtmsAdmin@sina.com\'>OtmsAdmin@sina.com</a><br>"
	+"欢迎您进入 OTMS 首页面: <a href=\'http://www.otms.com/mfgotv2/\'>http://www.otms.com/</a><br><br> </td>"
	+"<td width=\'100\' valign=\'top\'>&nbsp;</td></tr>"
	+"<tr><td height=\'68\' colspan=\'3\'><br>" 
//	+"<img src=\'cid:"+l2+"\'>" 
	+		"</td>"
	+"</tr></table></body></html>");
			email.send();
			
		}catch (EmailException  e) {
			System.out.println(e.toString());
			return 0;
		}catch (Exception e) {
			System.out.println("--------------------------------");
		}
		return 1;

	}
	

	

}
