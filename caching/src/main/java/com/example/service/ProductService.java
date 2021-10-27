package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.Product;

public interface ProductService {

	public Product saveProduct(Product product);

	public Optional<Product> getProductById(int id);

	public void deleteProductById(int id);

	public List<Product> getAllProduct();

	public Product getProductNameById(int id);

}
