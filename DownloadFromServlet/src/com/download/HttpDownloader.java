package com.download;

import java.io.IOException;

/*Works on HTTP only , can't use for httpss*/
public class HttpDownloader {
	 
    public static void main(String[] args) {
        String fileURL = "http://www.java2s.com/Code/JarDownload/tomcat/tomcat.jar.zip";
        String saveDir = "D:/demoDownload/";
        try {
            HttpDownloadUtility.downloadFile(fileURL, saveDir);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}


/*
 * 301 - File not avaliable
 * 
 * */
