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

/**
 * information about Manager Class;
 *
 */
public class Manager {
	short userId;
	String userName;
	String passwd;
	String logInTime;
	String logOutTime;
	String ipAddr;
	
	//constructor
	public Manager(short userId, String userName, String passwd, String logInTime, 
			String logOutTime, String ipAddr) {
		
		this.userId = userId;
		this.userName = userName;
		this.passwd = passwd;
		this.logInTime = logInTime;
		this.logOutTime = logOutTime;	
		this.ipAddr = ipAddr;
	}

}
