package com.serenity.junit;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import com.serenity.model.EmployeeClass;
import com.serenity.testbase.TestBase;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import net.serenitybdd.junit.runners.SerenityRunner;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CRUD_operations extends TestBase {

		static String name="Tushar";
		
		@Title("This is for create employee")
		@Test
		public void test001() throws InterruptedException {
			
			EmployeeClass emp= new EmployeeClass();	
			emp.setEmployeeName(name);
			emp.setEmployeeSalary(12000);
			emp.setEmployeeAge(25);
			emp.setProfileImage("");
			
		SerenityRest.rest()
		.given()
		.contentType(ContentType.JSON)
		.log()
		.all()
		.when()
		.body(emp)
		.post("/create")
		.then()
		.log()
		.all()
		.statusCode(200);
		
		Thread.sleep(1000);
	}
		
		@Title("This is to get employee data")
		@Test
		public void test002() {
			
			
			
			SerenityRest.given()
			.when()
			.get("/employees")
			.then()
			.log()
			.all()
			.statusCode(200);
			
		
		//System.out.println("response is = "+res);
		}
		

}
