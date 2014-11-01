/**
 *  Copyright (C) SA14226202@USTC, 2014-2015
 *
 *  FILE NAME                     OperateLog.java
 *  PACKAGE NAME                  ustc.se.courseproject;
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
 * information about OperateLog Class;
 *
 */
public class OperateLog {
	int opId;
	String userId;
	String opName;
	String description;
	String opTime;
	String opType;

	
	public OperateLog(int opId, String userId, String opName, String description, String opTime,
			String opType) {
		this.opId = opId;
		this.userId = userId;
		this.description = description;
		this.opTime = opTime;
		this.opType = opType;
		this.opName = opName;
	}

}
