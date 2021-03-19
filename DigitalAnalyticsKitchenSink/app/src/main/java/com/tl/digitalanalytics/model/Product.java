/***********************************************************************************************
 * Copyright (C) 2016 Acoustic, L.P. All rights reserved.
 *
 * NOTICE: This file contains material that is confidential and proprietary to
 * Acoustic, L.P. and/or other developers. No license is granted under any intellectual or
 * industrial property rights of Acoustic, L.P. except as may be provided in an agreement with
 * Acoustic, L.P. Any unauthorized copying or distribution of content from this file is
 * prohibited.
 ***********************************************************************************************/
package com.tl.digitalanalytics.model;

import java.io.Serializable;

/**
 * @author Sohil Shah
 *
 */
public class Product implements Serializable,Cloneable
{
	private static final long serialVersionUID = -6011410492048351008L;
	
	private String id;
	private String categoryId;
	private String name;
	private String baseUnitPrice;
	private int quantity;
	private String[] attributes;
	
	public Product()
	{
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getAttributes() {
		return attributes;
	}

	public void setAttributes(String[] attributes) {
		this.attributes = attributes;
	}

	public String getBaseUnitPrice() {
		return baseUnitPrice;
	}

	public void setBaseUnitPrice(String baseUnitPrice) {
		this.baseUnitPrice = baseUnitPrice;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public float getTotalPrice()
	{
		float totalPrice = 0.00f;
		
		if(this.quantity > 0)
		{
			float unitPrice = Float.parseFloat(this.baseUnitPrice.trim());
			totalPrice = this.quantity * unitPrice;
		}
		
		return totalPrice;
	}

	@Override
	public Object clone()
	{
		try
		{
			return super.clone();
		}
		catch(Exception e)
		{
			return null;
		}
	}

	@Override
	public boolean equals(Object o) 
	{
		if(o instanceof Product)
		{
			Product incoming = (Product)o;
			if(this.id.equals(incoming.id))
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() 
	{
		return this.id.hashCode();
	}
}
