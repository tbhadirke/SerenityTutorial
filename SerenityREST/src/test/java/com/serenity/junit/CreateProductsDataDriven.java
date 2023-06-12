package com.serenity.junit;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.serenity.cucumber.steps.ReusableSteps;
import com.serenity.model.AddProductClass;
import com.serenity.testbase.TestBase;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

@UseTestDataFrom("testdata/productsdata.csv")
@RunWith(SerenityParameterizedRunner.class)
public class CreateProductsDataDriven extends TestBase {
	
	private int userId;
	private Date date;
	
	public ReusableSteps getStep() {
		return step;
	}

	public void setStep(ReusableSteps step) {
		this.step = step;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Steps
	ReusableSteps step;
	
	@Title("This is to create products using data driven")
	@Test
	public void createProdcuts() {
		AddProductClass product1 = new AddProductClass();
		product1.setProductId(18);
		product1.setQuantity(10);

		AddProductClass product2 = new AddProductClass();
		product2.setProductId(19);
		product2.setQuantity(20);

		ArrayList<AddProductClass> al = new ArrayList();
		al.add(product1);
		al.add(product2);
		step.createProduct(userId, date,al).statusCode(200);
	}
	

}
