import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class DiskSpaceDetector {

	/**
	 * @author simon.jia 2011-07-05
	 * @param args[0] such as : C:\\ D:\\ E:\\
	 * @param args[1] such as : 10 20 30
	 * @param args[2] such as :simon.jia@cni.local;xx@xx.xx;yy@yy.yy
	 * 
	 */
	public static void main(String[] args) {
		String diskname = args[0];
		 float volumes =getVolumes(diskname);
		 float warningvolumes = Float.parseFloat(args[1]);
		 String [] emailAdds = args[2].split(";");
		 String ip = getIpInfo();				
		
		 writeLog(ip, diskname,volumes);
		
		 if(volumes<=warningvolumes){
		 sendMail(emailAdds,ip,volumes,warningvolumes,diskname);
		 }

		
	}

	public static String getIpInfo() {
		try {
			InetAddress ia = InetAddress.getLocalHost();
			return ia.getHostAddress();
		} catch (UnknownHostException e) {
			return "Get IP info error";
		}
	}

	public static String getIp() {

		java.io.BufferedReader in;
		java.lang.Process p;
		try {
			p = java.lang.Runtime.getRuntime().exec("IPCONFIG");
			in = new java.io.BufferedReader(new java.io.InputStreamReader(p
					.getInputStream()));
			String s = in.readLine();
			String ip = "";
			while (s != null) {
				if (s.startsWith("        IP Address")) {
					ip = s.substring(44, s.length());
				}
				s = in.readLine();
			}
			return ip;

		} catch (IOException e) {
			return "Get IP info error !";
		}
	}

	public static float getVolumes(String diskname) {
		File file = new File(diskname);
		float freeSpacevolumnes = (float)((Long)file.getFreeSpace()).doubleValue()/1024/1024/1024;				
		return freeSpacevolumnes;
	}

	public static void writeLog(String ip, String diskname,float volumes) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			File f = new File("DiskVolumesRecord.txt");
			if (!f.exists()) {
				RandomAccessFile rf = new RandomAccessFile(
						"DiskVolumesRecord.txt", "rw");
				rf.writeUTF("Datetime			IP Address		Volume		FreeSpace (GB)\r\n");
				rf
						.writeUTF("---------------------------------------------------------------------------------------------------\r\n");
				rf.writeUTF(sdf.format(new Date()) + "	" + ip + "		"
						+ diskname + "		"+ String.format("%.2f",volumes) + "\r\n");
				rf.close();
			} else {
				RandomAccessFile rf = new RandomAccessFile(
						"DiskVolumesRecord.txt", "rw");
				rf.seek(rf.length());
				String res = sdf.format(new Date()) + "	" + ip + "		"
					+ diskname + "		"+ String.format("%.2f",volumes) + "\r\n";
				rf.write(res.getBytes());
				rf.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int sendMail(String emailAdd[], String ip, float volumes,
			float warningvolumes,String diskname) {

		try {

			HtmlEmail email = new HtmlEmail();

//			email.setHostName("smtp.cni.local");
			email.setHostName("webmailcn.cn-innovations.com");
			
			email.setAuthentication("simon.jia", "Cnimes98");
			email.setCharset("UTF-8");

			email.setFrom("simon.jia@cni.local");
			for (int i = 0; i < emailAdd.length; i++) {
				email.addTo(emailAdd[i]);
			}

			email.setSubject("Warning: "+ip+" "+diskname+" FreeSpace < " + warningvolumes
					+ " GB");

			email
					.setHtmlMsg("<html><body ><table border=\'0\' bgcolor=\'#0099CC\' cellspacing=\'0\' cellpadding=\'0\' width=\'720\' >"
							+ "<tr><td width=\'100\' valign=\'top\'>&nbsp;</td>"
							+ "<td width=\'520\'  valign=\'middle\' style=\'font-size:12px; color:white;\'><br><br><div style=\'font-size:12px; font:bold; color:black;\'> 这是一封服务器磁盘空间的预警邮件！ </div><br>"
							+ "如下为服务器磁盘剩余空间:<br>"
							+ "----------------------------<br>"
							+ "Server IP Addr: "
							+ ip
							+ "<br>"
							+ "FreeSapce ("+diskname+"): "
							+ "<font color=\'red\'>"+String.format("%.2f",volumes)+"</font>"
							+ " GB <br>"
							+ "----------------------------<br>"
							+ "为确保服务器的正常运转，请尽快处理! <br><br>"
							+ "如有疑问可 <a href=\'mailto:simon.jia@cni.local\' style=\'color:white;\'>反馈</a><br>"
							+ "<td width=\'100\' valign=\'top\'>&nbsp;</td></tr>"
							+ "<tr><td width=\'100\' valign=\'top\'>&nbsp;</td>" + "</tr></table></body></html>");
			email.send();

		} catch (EmailException e) {
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;

	}

}
