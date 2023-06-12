package com.serenity.junit;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;

public class JsonReposneToMap {

	public static void main(String[] args) {
		
		//RestAssured.baseURI="";
		
		ArrayList<Map<String,Object>> response= RestAssured.given().get("https://demo9159795.mockable.io/getCart")
		.as(ArrayList.class);
		
		System.out.println("Reposnse="+response);
		
		HashMap<String,Object> out= new HashMap<>();
		
		out.putAll(response.get(1));
		
		System.out.println(out);;
		
		System.out.println(out.containsKey("products"));
		Object prd = out.get("products");
		ArrayList<Map<String,Object>> products= new ArrayList<>();
		//products.addAll(out.get(prd));
		
	}

}
