package com.serenity.junit;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.internal.MethodSorter;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

import com.serenity.cucumber.steps.ReusableSteps;
import com.serenity.model.*;
import net.serenitybdd.junit.runners.SerenityRunner;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CRUD_Operation_FakeStore {

	static int userId=5; 
	static Date date;
	static ArrayList<AddProductClass> al;
	
	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "https://fakestoreapi.com/carts";
	}

	@Steps
	ReusableSteps steps;
	
	@Title("This is to add new product in cart.")
	@Test
	public void test001() {

		Date date = new Date();
		date.setDate(12);
		date.setMonth(10);
		date.setYear(2022);
		
		AddProductClass product1 = new AddProductClass();
		product1.setProductId(18);
		product1.setQuantity(10);

		AddProductClass product2 = new AddProductClass();
		product2.setProductId(19);
		product2.setQuantity(20);

		ArrayList<AddProductClass> al = new ArrayList();
		al.add(product1);
		al.add(product2);

		steps.createProduct(userId, date, al).statusCode(200);

	}
	
	@Title("This is to get all carts")
	@Test
	public void test002() {
		
		List<Map<String,Object>> response= steps.getProducts();
		
		System.out.println("Json = "+response);
		
	}

}
