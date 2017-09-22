package fr.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataRecovery {
	
	public static Map<String, String> recover(String data){
		
		Map< String, String> map = new HashMap<String, String>();
		String[] tabSplit = data.split("=|&");
		
			for (int i=0; i<tabSplit.length; i++){
				if (i%2 == 0){
					map.put(tabSplit[i], tabSplit[i+1]);
			}
		}
		return map;
	}
	
	// ancienne méthode peu pratique
//	public static List<String> recover(String data, Object object){
//		
//		List<String> tabParam = new ArrayList<String>();
//		List<String> tabField = DataRecovery.field(object);
//		String[] tabSplit = data.split("=|&");
//		
//		for (String field : tabField){
//			for (int i=0; i<tabSplit.length; i++){
//				if (tabSplit[i].equals(field)){
//					tabParam.add(tabSplit[i+1]);
//				}
//			}
//		}
//		Map< String, String> map = new HashMap<String, String>();
//		map.put(, value)
//		return tabParam;
//	}
//
//	//méthode permettant la récupération des noms des attributs associé à une entité
//	private static List<String> field(Object object){
//		Field[] collecField = object.getClass().getDeclaredFields();
//		List<String> tabField = new ArrayList<>();
//		for (int i=0; i<collecField.length; i++){
//			tabField.add(collecField[i].getName());
//		}
//		return tabField;
//	}
	
}
