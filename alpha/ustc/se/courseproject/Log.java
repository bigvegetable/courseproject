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

/**
 * definition about Log Class;
 */

public class Log {
	
	/**
	 * This method is used to try to connect to the local database. 
	 * @return If fail to connect to the database, return null;
	 * else return the Connection variable. 
	 */
	public static Connection connectDatabase() 
			throws ClassNotFoundException, SQLException {
		String driver = "com.mysql.jdbc.Driver";
		
		//if Exception occurs, let upper method to deal with it.
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new ClassNotFoundException("链接失败！");
		}

		String url = "jdbc:mysql://localhost:3306/library";
		String user = "admin";
		String password = "admin";
		
		Connection connection = null;
		//if SQLException occurs, let upper method to deal with it.
		connection = DriverManager.getConnection(url, user, password);
		
		return connection;
	}
	
	/**
	 * This method is used to close current connection 
	 * @param connection 
	 * @return　true if close successfully
	 * @throws SQLException
	 */
	public static boolean closeConnection(Connection connection) 
			throws SQLException {
		if (connection == null) {
			throw new SQLException("链接尚未打开！");
		}
		try {
			connection.close();
		} catch (Exception e) {
			throw new SQLException("关闭链接失败！");
		}
		
		return true;
	}
	
	/**
	 * This method is used for registering a new user account
	 * @param connection
	 * @param userName
	 * @param password
	 * @param gender
	 * @param phoneNumber
	 * @param email
	 * @return true if register successfully
	 * @throws SQLException
	 * @throws IpException
	 * @throws AccountException
	 */
	public static boolean register(Connection connection, String userName, 
			String password, String gender, String phoneNumber, String email) 
					throws SQLException, IpException, AccountException {
		if (userName == null) {
			throw new AccountException("用户名不能为空！");
		}
		if (password == null) {
			throw new AccountException("密码不能为空！");
		}
		if (gender == null) {
			throw new AccountException("性别不能为空！");
		}
		if (!gender.equals("男") || !gender.equals("女")) {
			throw new AccountException("性别错误！");
		}
		if (phoneNumber == null) {
			throw new AccountException("手机号码不能为空！");
		}
		if (email == null) {
			throw new AccountException("邮箱不能为空！");
		}
		
		//check if this account is exist
		if (checkUserName(connection, userName)) {
			throw new AccountException("该用户已存在！");
		}
				
		//get current ip address
		String ethernetIpAddr = getIpAddrByName("eth0");
		String wlanIpAddr = getIpAddrByName("wlan0");
		 
	    String sqlCommand = String.format("insert into manager(name,password,"
	    		+ "gender,phone_number,email,log_in_time,ethernet_ip_addr,"
	    		+ "wlan_ip_addr) values(%s,%s,%s,%s,%s,now(),%s,%s)", 
	 		   userName, password, gender, phoneNumber, email,
	 		   ethernetIpAddr, wlanIpAddr);
		 
		Statement statement = connection.createStatement();
		statement.executeUpdate(sqlCommand);
				
		return true;
	}
	
	/**
	 * This method is used to log in the library manage system.
	 * @param connection: connection with the database
	 * @param userName: user name input
	 * @param password: user password input
	 * @return return true if log in successful, otherwise return false.
	 * @throws SQLException, SocketException, AccountException
	 */
	 public static boolean logIn(Connection connection, String userName,
			 String password) throws SQLException, IpException, AccountException {
		 if (userName == null) {
			 throw new AccountException("用户名不能为空！");
		 }
		 if (password == null) {
		 	 throw new AccountException("密码不能为空！");
		 }
			
		 //log in fail! wrong information
		 if (!checkInformation(connection, userName, password)) {
			throw new AccountException("用户名或密码错误！");
		 }
		 //log in successful!
		 updateInformation(connection, userName, password);		 
				 
		 return true;
	 }
	 
	 /**
	  * This method is used to get last log in and log out time from 
	  * this system about current user.
	  * @param connection
	  * @param userName
	  * @param password
	  * @return String[2],String[0] is log_in_time, String[1] is log_out_time
	  * @throws SQLException
	  */
	 public static String[] getLastLogTime(Connection connection, 
			 String userName, String password) throws SQLException{
		 Statement statement = null;
		 String sqlCommand = String.format("select log_in_time,log_out_time"
		 		+ " from manager where name = %s"
		 		+ "and password = %s ", userName, password);
		 ResultSet resultSet = null;	 
		 String[] result = new String[2];
		 
		 statement = connection.createStatement();
		 resultSet = statement.executeQuery(sqlCommand);		 
		 if (resultSet.next()) {
			result[0] = resultSet.getString("log_in_time");
			result[1] = resultSet.getString("log_out_time");
		 }
		 resultSet.close();
		 statement.close();
		 
		 return result;
	 }
	 
	 /**
	  * This method is used to check if user log information is right.
	  * @param connection: connection with the database
	  * @param userName: user name input
	  * @param password: user password input
	  * @return right information return true, else return false.
	  * @throws SQLException
	  */
	 private static boolean checkInformation(Connection connection,
			 String userName, String password) 
					 throws SQLException {
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
	  * This method is used to check weather the input user name is exist.
	  * @param connection
	  * @param userName
	  * @return true if exit, otherwise false
	  * @throws SQLException
	  */
	 private static boolean checkUserName(Connection connection,
			 String userName) throws SQLException {
		 Statement statement = null;
		 String sqlCommand = String.format("select * from manager where "
		 		+ "name = %s", userName);
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
	  * @param connection: connection with the database
	  * @return return amount of update lines.  
	  * @throws SQLException, SocketException
	  */
	 private static int updateInformation(Connection connection, 
			 String userName, String password) throws SQLException, IpException {
		 
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
	  * @throws SocketException
	  */
	 private static String getIpAddrByName(String networkInterfaceName) 
			 throws IpException {
		 
		 NetworkInterface networkInterface;
		try {
			networkInterface = NetworkInterface.getByName(networkInterfaceName);
		} catch (SocketException e) {
			throw new IpException("获取IP地址失败！");
		}
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
