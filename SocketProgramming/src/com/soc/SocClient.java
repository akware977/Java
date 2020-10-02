package com.soc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class SocClient {

	public static void main(String[] args) throws Exception {
		
		String ip = "localhost";
		int port = 9999; //0-1023 to 65535
		Socket s = new Socket(ip,port);
		
		String str = "Akshay Ware";
		
		OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
		PrintWriter out = new PrintWriter(os);
		
		out.println(str);
		out.flush();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String nickName = br.readLine();
		s.close();
		
		System.out.println("C:Data From server " + nickName);
		
		
		out.close();

	}

}
