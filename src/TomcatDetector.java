/**  
 * 监视Tomcat是否宕机，如果宕机就会自动重启  
 */
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TomcatDetector {
	/**
	 * @author simon.jia 2011-09-20
	 * @param args
	 *            [0] such as : Apache Tomcat ZOLMES7009
	 * @param args
	 *            [1] such as : http://zolmes.cni.local
	 * @param args
	 *            [2] such as : 10
	 * 
	 */
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String serviceNames = args[0].trim();
		String detectorUrl = args[1].trim();
		long detectIntervalSecond = Long.parseLong(args[2].trim());
		int count = 0;
		
		while (true) {
			try {
				Date date = new Date();
				System.out.println(" <" + sdf.format(date) + "> Check status of " + detectorUrl + " ...");
				long rtn = TomcatDetector.keepTomcatAlive(serviceNames, detectorUrl);
				
				if (rtn != 0 && count < 10)
					count++;
				else
					count = 0;
				
				System.out.println(rtn);
				System.out.println(count);
				
				if (count == 10) {
					writeLog(" Detecting service  Running Error! \n\t\t\t Run Exception >10 times");
					System.out.println(" <" + sdf.format(new Date())
							+ "> Detecting service  Running Error! \n\t\t\t Run Exception >10 times");
					
					stopTomcat(serviceNames);
					startTomcat(serviceNames);
					
				}
				
				Thread.sleep(1000 * detectIntervalSecond);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	private static long keepTomcatAlive(String serviceNames, String detectorUrl) throws NullPointerException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String s;
		int responseCode;
		String serviceName = serviceNames;
		boolean isTomcatAlive = false;
		boolean isResponsed = true;
		java.io.BufferedReader in;
		try {
			URL url = new URL(detectorUrl);
			URLConnection con = url.openConnection();
			
			con.setConnectTimeout(5000);
			con.setReadTimeout(5000);
			
			HttpURLConnection httpcon = null;
			httpcon = (HttpURLConnection) con;
			responseCode = httpcon.getResponseCode();
			
			if (responseCode != 200 && responseCode != 302) {
				isResponsed = false;
				writeLog(" Detecting service  Running Error! \n\t\t\t HTTPResponseCode= " + responseCode);
				System.out.println(" <" + sdf.format(new Date())
						+ "> Detecting service  Running Error! \n\t\t\t HTTPResponseCode= " + responseCode);
				
				stopTomcat(serviceName);
				startTomcat(serviceName);
				return 0;
				
			} else {
				System.out.println(" <" + sdf.format(new Date()) + "> OK ");
				return 0;
			}
			
		} catch (Exception ex) {
			writeLog(" Detecting service  Running Error! \n\t\t\t" + ex.toString());
			System.out.println(" <" + sdf.format(new Date()) + "> Detecting service  Running Error! \n\t\t\t"
					+ ex.toString());
			Date date = new Date();
			long runErrorTime = date.getTime();
			return runErrorTime;
		}
		
	}
	
	public static void writeLog(String str) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			File f = new File("TomcatDetector.txt");
			if (!f.exists()) {
				RandomAccessFile rf = new RandomAccessFile("TomcatDetector.txt", "rw");
				rf.writeUTF("Datetime		Status			\r\n");
				rf.writeUTF("---------------------------------------------------------------------------------------------------\r\n");
				rf.writeUTF(sdf.format(new Date()) + "	" + str + "\r\n");
				rf.close();
			} else {
				RandomAccessFile rf = new RandomAccessFile("TomcatDetector.txt", "rw");
				rf.seek(rf.length());
				String res = sdf.format(new Date()) + "	" + str + "\r\n";
				rf.write(res.getBytes());
				rf.close();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void stopTomcat(String serviceName) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			java.lang.Process p = java.lang.Runtime.getRuntime().exec("net stop \"" + serviceName + "\" /y");
			java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(p.getInputStream()));
			String s;
			String t = "stopped successfully";
			boolean restart = false;
			while ((s = in.readLine()) != null) {
				if (s.indexOf(t) != -1) {
					restart = true;
					break;
				}
			}
			writeLog(" Tomcat is stop " + (restart ? "OK" : "ERROR"));
			System.out.println(" <" + sdf.format(new Date()) + "> Tomcat is stop " + (restart ? "OK" : "ERROR"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void startTomcat(String serviceName) {
		try {
			@SuppressWarnings("unused")
			java.lang.Process p = java.lang.Runtime.getRuntime().exec("net stop \"" + serviceName + "\" /y");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			java.lang.Process p = java.lang.Runtime.getRuntime().exec("net start \"" + serviceName + "\" /y");
			java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(p.getInputStream()));
			String s;
			String t = "started successfully";
			boolean restart = false;
			while ((s = in.readLine()) != null) {
				if (s.indexOf(t) != -1) {
					restart = true;
					break;
				}
			}
			writeLog(" Tomcat is restart " + (restart ? "OK" : "ERROR"));
			System.out.println(" <" + sdf.format(new Date()) + "> Tomcat is restart " + (restart ? "OK" : "ERROR"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
