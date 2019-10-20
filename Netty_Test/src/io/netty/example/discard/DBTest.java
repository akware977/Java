package io.netty.example.discard;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class DBTest {

	public static void main(String[] args) throws Exception 
    {
         //Locate text properties file
         FileInputStream fis = new FileInputStream("db.properties");
         //create an empty object of java.util.Properties class
         Properties prop = new Properties();
         //load the content of myfile.properties into java.util.Properties class
         prop.load(fis);
         
         //read value from java.util.Properties
         String dname = prop.getProperty("my.driver");
         String url = prop.getProperty("my.dburl");
         String user = prop.getProperty("my.dbuser");
         String pwd = prop.getProperty("my.dbpwd");
         String qry = prop.getProperty("my.sql");
         
         System.out.println("dname " +dname + "\nurl: " +url+ "\nuser: " +user+ "\npwd :" +pwd+ "\nqry: " +qry);
         
         //create jdbc connection object
         Class.forName(dname);
         Connection con = DriverManager.getConnection(url, user, pwd);
         //create statement object
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(qry);
         System.out.println("JOb_Id   JOb_Title");
         System.out.println("--------------------------");
         while (rs.next())
         {
              System.out.println(rs.getString(1)+"      "+ rs.getString(2));
         }
         System.out.println("-------------\n");
         rs.close();
         con.close();
         st.close();
    }
}
