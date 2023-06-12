package com.serenity.cucumber.steps;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.serenity.model.AddProductClass;
import com.serenity.model.ProductClass;
import com.serenity.utils.ReusableSpecifications;

import io.restassured.common.mapper.TypeRef;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class ReusableSteps {
	
	@Step("Create Product with User ID:{0}, Date :{1} and Products :{2}")
	public ValidatableResponse createProduct(int userId, Date date, ArrayList<AddProductClass> al) {
		
		ProductClass prd = new ProductClass();
		prd.setUserId(userId);
		prd.setDate(date);;
		prd.setProducts(al);

		return SerenityRest.rest().given()
				.spec(ReusableSpecifications.getRequestGenericSpecs())
				.log().all().when().body(prd).post().then().log().all();
			
	}
	
	@Step
	public List<Map<String, Object>> getProducts() {
		
		return SerenityRest.rest().given()
		.log()
		.all()
		.when()
		.get()
		.then()
		.log()
		.all()
		.spec(ReusableSpecifications.getResponseGenericSpecs())
		.extract().as(new TypeRef<List<Map<String,Object>>>(){})
		;
	}

}
