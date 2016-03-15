package com.payitezy.resources.hal;

import com.payitezy.model.UsersModel;

public abstract class ResourceIdFactory {

	   public static String getId(UsersModel users) {
	      return users.getId();
	   }
	   
	 
	}
