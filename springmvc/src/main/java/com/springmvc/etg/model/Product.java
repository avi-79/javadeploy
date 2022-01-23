package com.springmvc.etg.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Product {
	@NotNull
	@Size(min = 3, max = 50)
	private String productid;
	private String productname;
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	
}
