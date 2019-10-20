package com.soc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocServer {

	public static void main(String[] args) throws IOException 
	{
		System.out.println("S :Servr is started...");
		ServerSocket ss = new ServerSocket(9999);
		System.out.println("S :Server is waiting for client request..");
		Socket s = ss.accept();
		
		System.out.println("S :Client Connected..");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String str = br.readLine();
		
		System.out.println("S :Client Data :" +str);
		
		String nickName = str.substring(0, 3);
		
		OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
		PrintWriter out = new PrintWriter(os);
		
		out.println(nickName);
		out.flush();
		System.out.println("S :Data Sent from Server to Client");
		out.close();
	}

}
