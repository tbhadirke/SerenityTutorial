package com.serenity.junit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;

@RunWith(SerenityRunner.class)
public class FirstSerenityTest {
	
	@BeforeClass
	public static void init() {
		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";
	}
	
	@Test
	public void getData() {
		
		SerenityRest.given()
		.when()
		.get("/employees")
		.then()
		.log()
		.all()
		.statusCode(200);
		
	}

}
