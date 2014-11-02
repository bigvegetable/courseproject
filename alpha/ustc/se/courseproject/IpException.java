/**
 *  Copyright (C) SA14226202@USTC, 2014-2015
 *
 *  FILE NAME                     IpException.java
 *  PACKAGE NAME                  ustc.sa14226202
 *  AUTHOR                        Zuo Guoqing
 *  LANGUAGE                      Java
 *  DATE OF FIRST RELEASE         2014年11月1日
 *  DESCRIPTION                   
 * 
 */

/**
 *  Revision log
 *
 *  Created by Zuo Guoqing, 2014年11月1日
 */

package ustc.se.courseproject;

/**
 * definition of IpException
 *
 */

@SuppressWarnings("serial")
public final class IpException extends Exception {
	public IpException() {
		
	}
	
	public IpException(String message) {
		super(message);
	}
	
}
