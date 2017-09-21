package fr.utils;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonConvertor {
	
	public static <T> String convert(Object object){ //  List<T> list
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String json;
		return json = gson.toJson(object);
	}

}
