package com.kai.util;

import java.util.List;

public class StringUtils {
    
    public static boolean isEmpty(List<?> list) {
	if(list == null || list.isEmpty()) 
	    return true;
	return false;
    }

}
