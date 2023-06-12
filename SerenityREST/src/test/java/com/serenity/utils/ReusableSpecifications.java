package com.serenity.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ReusableSpecifications {

	static RequestSpecification reqspec;
	static RequestSpecBuilder reqbuild;

	static ResponseSpecification respspec;
	static ResponseSpecBuilder resbuild;

	public static RequestSpecification getRequestGenericSpecs() {

		reqbuild = new RequestSpecBuilder();
		reqbuild.setContentType(ContentType.JSON);

		reqspec = reqbuild.build();
		return reqspec;
	}

	public static ResponseSpecification getResponseGenericSpecs() {
		resbuild = new ResponseSpecBuilder();
		resbuild.expectHeader("Content-Type", "application/json; charset=utf-8");
		resbuild.expectHeader("Transfer-Encoding", "chunked");

		respspec = resbuild.build();

		return respspec;
	}

}
