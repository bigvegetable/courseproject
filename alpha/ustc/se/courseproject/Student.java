/**
 *  Copyright (C) SA14226202@USTC, 2014-2015
 *
 *  FILE NAME                     Student.java
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
 * information about Student Class;
 *
 */
public class Student {
	String stuId;
	String stuName;
	String gender;
	String phoneNumber;
	String email;
	String academy;
	String stuClass;
	
	//constructor
	public Student(String stuId, String stuName, String gender, String phoneNumber,
			String email, String academy, String stuClass) {
		
		this.stuId = stuId;
		this.stuName = stuName;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.academy = academy;
		this.stuClass = stuClass;
	}
}
