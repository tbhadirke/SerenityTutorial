package com.serenity.model;


import java.util.Date;
import java.util.List;

public class ProductClass {

	int id;

	int userId;

	Date date;

	List<AddProductClass> products;

	int _v;

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserId() {
		return userId;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setProducts(List<AddProductClass> products) {
		this.products = products;
	}

	public List<AddProductClass> getProducts() {
		return products;
	}

	public void set_v(int _v) {
		this._v = _v;
	}

	public int get_v() {
		return _v;
	}
}
