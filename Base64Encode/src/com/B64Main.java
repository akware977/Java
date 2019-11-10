package com;

import java.util.Base64;
/*
 * @auther - Akshay Ware
 * Class use for simple base 64 encoding and decoding 
 * 
 * */
public class B64Main {

	public static void main(String[] args) 
    { 
  
        // create a sample String to encode 
        String sample = "India Team will win the Cup"; 
        String encode = B64Encode(sample);
        String decode = B64Decode(encode);
        
    } 
	
	private static String B64Encode(String sample) {
		
		// print actual String 
        System.out.println("Sample String:\n"+ sample); 
  
        // Encode into Base64 format 
        String BasicBase64format = Base64.getEncoder().encodeToString(sample.getBytes()); 
  
        // print encoded String 
        System.out.println("Encoded String:\n"+ BasicBase64format); 
        
        return BasicBase64format;
		
	}

	private static String B64Decode(String encoded) {
		
		// print encoded String 
		System.out.println("Encoded String:\n"+ encoded); 

		// decode into String from encoded format 
		byte[] actualByte = Base64.getDecoder().decode(encoded); 

		String actualString = new String(actualByte); 

		// print actual String 
		System.out.println("actual String:\n"+ actualString); 
		return actualString;
	}
}
