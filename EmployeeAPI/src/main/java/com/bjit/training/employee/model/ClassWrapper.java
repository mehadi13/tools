package com.bjit.training.employee.model;

import java.util.HashMap;
import java.util.Map;

public class ClassWrapper {

	public static Map<String, Object> getWrapper(String wrapperString, Object object) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(wrapperString, object);
		return map;
	}

}
