package fr.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class DataRecovery {
	
	public static List<Object> recover(String data, Object object){
		
		List<Object> tabParam = new ArrayList<Object>();
		List<String> tabField = DataRecovery.field(object);
		String[] tabSplit = data.split("=|&");
		
		for (String field : tabField){
			for (int i=0; i<tabSplit.length; i++){
				if (tabSplit[i].equals(field)){
//					tabParam.add(tabSplit[i]);
					tabParam.add(tabSplit[i+1]);
				}
			}
		}
		return tabParam;
	}

	private static List<String> field(Object object){
		Field[] collecField = object.getClass().getDeclaredFields();
		List<String> tabField = new ArrayList<>();
		for (int i=0; i<collecField.length; i++){
			tabField.add(collecField[i].getName());
		}
		return tabField;
	}
}
