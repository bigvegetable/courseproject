/**
 *  Copyright (C) SA14226202@USTC, 2014-2015
 *
 *  FILE NAME                     Statistics.java
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
 * information about Statistics Class;
 *
 */
public class Statistics {
	String isbn;
	byte total = 0;
	byte available = 0;
	String registerDate;
	int frequency = 0;
	
	//constructor
	public Statistics(String isbn, byte total, byte available, 
			String registerDate, int frequency) {
		
		this.isbn = isbn;
		this.total = total;
		this.available = available;
		this.registerDate = registerDate;
		this.frequency = frequency;
	}

}
