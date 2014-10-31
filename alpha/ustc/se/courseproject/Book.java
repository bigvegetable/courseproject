/**
 *  Copyright (C) SA14226202@USTC, 2014-2015
 *
 *  FILE NAME                     Book.java
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
 * information about Book Class;
 *
 */
public class Book {
	String isbn;
	String author;
	String title;
	double price;
	String press;
	String publicDate;
	short cateId;
	
	//constructor
	public Book(String isbn, String author, String title, double price, 
			String press, String publicDate, short cateId) {
		
		this.isbn = isbn;
		this.author = author;
		this.title = title;
		this.price = price;
		this.press = press;
		this.publicDate = publicDate;
		this.cateId = cateId;
	}

}
