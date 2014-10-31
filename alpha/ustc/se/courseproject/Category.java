/**
 *  Copyright (C) SA14226202@USTC, 2014-2015
 *
 *  FILE NAME                     Category.java
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
 * information about Category Class;
 *
 */
public class Category {
	short cateId;
	String cateName;
	 
	 //constructor
	 public Category(short cateId, String cateName) {
		 
		 this.cateId = cateId;
		 this.cateName = cateName;
	 }
}
