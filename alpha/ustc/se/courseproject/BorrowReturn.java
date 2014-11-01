/**
 *  Copyright (C) SA14226202@USTC, 2014-2015
 *
 *  FILE NAME                     BorrowReturn.java
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
 * information about BorrowReturn Class;
 *
 */
public class BorrowReturn {
	int brId;
	String isbn;
	String stuId;
	String stuName;
	String borrowDate;
	String expireDate;
	boolean isReturn;
	String opName;
	short userId;
	
	//constructor
	public BorrowReturn(int brId, String isbn, String stuId, String stuName, 
			String borrowDate, String expireDate, boolean isReturn, 
			String opName, short userId) {
			
			this.brId = brId;
			this.isbn = isbn;
			this.stuId = stuId;
			this.stuName = stuName;
			this.borrowDate = borrowDate;
			this.expireDate = expireDate;
			this.isReturn = isReturn;
			this.opName = opName;
			this.userId = userId;
	}		
}
