/**
 *  Copyright (C) SA14226202@USTC, 2014-2015
 *
 *  FILE NAME                     LogIn.java
 *  PACKAGE NAME                  ustc.se.courseproject
 *  AUTHOR                        Zuo Guoqing
 *  LANGUAGE                      Java
 *  DATE OF FIRST RELEASE         2014/10/31
 *  DESCRIPTION                   
 * 
 */

/**
 *  Revision log
 *
 *  Created by Zuo Guoqing, 2014/10/31
 */

package ustc.se.courseproject;

/**
 * information about LogIn Class;
 *
 */

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;

public class LogIn {
	
	/**
	 * This method is used to try to connect to the local database.
	 *  
	 * @return If fail to connect to the database, return null;
	 * else return the Connection variable.
	 * 
	 */
	public static Connection connectDatabase() throws Exception, SQLException {
		String driver = "com.mysql.jdbc.Driver";
		
		//if Exception occurs, let upper method to deal with it.
		Class.forName(driver);
		
		Connection connection = null;
		String url = "jdbc:mysql://localhost:3306/library";
		String user = "admin";
		String password = "admin";

		//if SQLException occurs, let upper method to deal with it.
		connection = DriverManager.getConnection(url, user, password);
		
		return connection;
	}
	
	/**
	 * This method is used to register a new manager.
	 * 
	 */
	public static boolean register() {
		
		return true;
	}
	
	/**
	 * This method is used to log in the library manage system.
	 * 
	 * @param connection: connection with the database
	 * @param userName: user name input
	 * @param password: user password input
	 * @return return true if log in successful, otherwise return false.
	 * 
	 */
	 public static boolean logIn(Connection connection, String userName,
			 String password) throws SQLException, SocketException {
		 
		 checkInformation(connection, userName, password);
		 
		 //log in successful!
		 updateInformation(connection, userName, password);

		 
				 
		 return true;
	 }
	 
	 /**
	  * This method is used to check if user log information is right.
	  * 
	  * @param connection: connection with the database
	  * @param userName: user name input
	  * @param password: user password input
	  * @return right information return true, else return false.
	  * 
	  */
	 private static boolean checkInformation(Connection connection,
			 String userName, String password) throws SQLException {
		 
		 Statement statement = null;
		 String sqlCommand = String.format("select * from manager where name = %s"
		 		+ "and password = %s ", userName, password);
		 ResultSet resultSet = null;
		 boolean result = false;	 
		 
		 statement = connection.createStatement();
		 resultSet = statement.executeQuery(sqlCommand);		 
		 result = resultSet.next();
		 
		 resultSet.close();
		 statement.close();
		 
		 return result;
	 }
	 
	 /**
	  * This method is used to update some information about the log in user.
	  * 
	  * @param connection: connection with the database
	  * @return return amount of update lines.  
	  * 
	  */
	 private static int updateInformation(Connection connection, 
			 String userName, String password) throws SQLException, SocketException {
		 //get current ip address
		 String ethernetIpAddr = getIpAddrByName("eth0");
		 String wlanIpAddr = getIpAddrByName("wlan0");
		 
		 String sqlCommand = String.format("update manager set log_in_time = now(),"
		 		+ "ethernet_ip_addr = %s, wlan_ip_addr = %s"
		 		+ "where name = %s and password = %s", 
		 		ethernetIpAddr, wlanIpAddr, userName, password);
		 
		 Statement statement = connection.createStatement();
		 int count = statement.executeUpdate(sqlCommand);
		 
		 return count;
	 }
	 
	 /**
	  * This method is used to get ip address by network interface's name.
	  * @param networkInterfaceName network interface's name
	  * @return return first ip address of given network interface or null. 
	  */
	 private static String getIpAddrByName(String networkInterfaceName) 
			 throws SocketException {
		 
		 NetworkInterface networkInterface = 
				NetworkInterface.getByName(networkInterfaceName);
		 if (networkInterface == null) {
			 return null;
		 }
		
		 InetAddress ipAddress = null;
		 Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
		
		 while (addresses.hasMoreElements()) {
			 ipAddress = addresses.nextElement();				
			 if (ipAddress != null && ipAddress instanceof Inet4Address) {
				 return ipAddress.getHostAddress();
			 }
		 }
		
		 return null;
	}
	 
}//end class
