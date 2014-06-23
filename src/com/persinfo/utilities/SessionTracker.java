/**
 * 
 */
package com.persinfo.utilities;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author deva
 *
 */
public class SessionTracker {
	private static final Map<String, Object> sessions = new HashMap(); 
	
	public static Map<String, Object> getInstance(){
		return sessions;
	}

}
