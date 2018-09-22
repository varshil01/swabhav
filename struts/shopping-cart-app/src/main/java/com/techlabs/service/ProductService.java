package com.techlabs.service;

import java.util.ArrayList;
import java.util.List;

import com.techlabs.model.Product;

public class ProductService {
	private static List<Product> listofproducts = new ArrayList<Product>();
	private static ProductService object;

	private ProductService() {

	}

	public static ProductService getInstanceOf() {
		if (object == null) {
			object = new ProductService();
			init();
		}
		return object;
	}

	public static void init() {
		listofproducts.add(new Product("P101", "laptop", 50000, 5000));
		listofproducts.add(new Product("P102", "iphone6s", 50000, 100));
		listofproducts.add(new Product("P103", "iphone7", 2666, 26));
		listofproducts.add(new Product("P104", "iphone7s", 61616, 151));
		listofproducts.add(new Product("P105", "iphone8", 48455, 4555));
		listofproducts.add(new Product("P106", "iphone9", 6262, 655));
		listofproducts.add(new Product("P107", "DELL Laptop", 51584, 515));
		listofproducts.add(new Product("P108", "ipad", 84851, 254));
		listofproducts.add(new Product("P109", "Hp laptop", 611655, 4554));
		listofproducts.add(new Product("P110", "lenovo laptop", 5484, 14815));

	}

	public List<Product> getAllProducts() {
		return listofproducts;
	}

	public Product getProductById(String id) {
		for (Product product : listofproducts) {
			if (product.getId().equals(id)) {
				return product;
			}
		}
		return null;
	}

}