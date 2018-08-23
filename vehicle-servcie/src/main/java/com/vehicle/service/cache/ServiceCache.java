package com.vehicle.service.cache;

import java.util.HashMap;
import java.util.Map;

public class ServiceCache implements Cache<Object, Object> 
{
	private Map<Object, Object> map;
 
	private static ServiceCache sc = new ServiceCache();
	
	public static ServiceCache getInstance() {
	
		return sc;
	}
	
	
	private ServiceCache() 
	{
		map = new HashMap<Object, Object>();
	}
 
	
	public void put(Object key, Object value) 
	{
		map.put(key, value);
	}
 
	public Object get(Object key) 
	{
		return map.get(key);
	}
}
