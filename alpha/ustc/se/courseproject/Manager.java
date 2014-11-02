/**
 *  Copyright (C) SA14226202@USTC, 2014-2015
 *
 *  FILE NAME                     Manager.java
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

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * information about Manager Class;
 *
 */
public class Manager {
	short userId = 0;
	String userName = null;
	String password = null;;
	String gender = null;;
	String phoneNumber = null;;
	String email = null;;
	String logInTime = null;;
	String logOutTime = null;;
	String ethernetIpAddr = null;;
	String wlanIpAddr = null;;
	
	/**
	 * empty constructor
	 */
	public Manager() {
		//empty
	}

	/**
	 * constructor that contains part information
	 * @param userName
	 * @param password
	 */
	public Manager(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	
	/**
	 * constructor that contains part information
	 * @param userName
	 * @param password
	 * @param phoneNumber
	 * @param email
	 * @param gender
	 */
	public Manager(String userName, String password, String phoneNumber,
			String email, String gender) {
		this.userName = userName;
		this.password = password;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
	/**
	 * constructor that contains whole information
	 * @param userId
	 * @param userName
	 * @param password
	 * @param phoneNumber
	 * @param logInTime
	 * @param email
	 * @param logOutTime
	 * @param gender
	 * @param ethernetIpAddr
	 * @param wlanIpAddr
	 */
	public Manager(short userId, String userName, String password, String phoneNumber, 
			String logInTime, String email, String logOutTime, String gender,
			String ethernetIpAddr, String wlanIpAddr) {		
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.logInTime = logInTime;
		this.logOutTime = logOutTime;	
		this.ethernetIpAddr = ethernetIpAddr;
		this.wlanIpAddr = wlanIpAddr;
	}
	
	public Manager getUserInformation(Connection connection, String userName,
			String password) throws SQLException {
		Manager user = new Manager();
		Statement statement = null;
		ResultSet resultSet = null;
		String sqlCommand = String.format("select * from manager where "
				+ "name = %s and password = %s",userName, password);
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlCommand);
			
			if (resultSet.next()) {
				user.userId = resultSet.getShort("uid");
				user.userName = userName;
				user.password = password;
				user.gender = resultSet.getString("gender");
				user.email = resultSet.getString("email");
				user.logInTime = resultSet.getString("log_in_time");
				user.logOutTime = resultSet.getString("log_out_time");
				user.ethernetIpAddr = resultSet.getString("ehternet_ip_addr");
				user.wlanIpAddr = resultSet.getString("wlan_ip_addr");
			}
			
		} catch (SQLException e) {
			throw new SQLException("获取信息失败！");
		} finally {
			resultSet.close();
			statement.close();
		}
				
		return user;
	}
}
