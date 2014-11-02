/**
 *  Copyright (C) SA14226202@USTC, 2014-2015
 *
 *  FILE NAME                     AccountException.java
 *  PACKAGE NAME                  ustc.se.courseproject
 *  AUTHOR                        Zuo Guoqing
 *  LANGUAGE                      Java
 *  DATE OF FIRST RELEASE         2014/11/01
 *  DESCRIPTION                   
 * 
 */

/**
 *  Revision log
 *
 *  Created by Zuo Guoqing, 2014/11/01
 */

package ustc.se.courseproject;

/**
 * information about AccountException
 *
 */

@SuppressWarnings("serial")
public final class AccountException extends Exception {
	
	public AccountException() {
		
	}
	
	public AccountException(String message) {
		super(message);
	}
}
