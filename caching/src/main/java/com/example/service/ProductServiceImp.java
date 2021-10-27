package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.model.Product;
import com.example.repository.ProductRepo;

@Service
public class ProductServiceImp implements ProductService {
	@Autowired
	private ProductRepo productrepo;

	@Override
	public Product saveProduct(Product product) {

		return productrepo.save(product);
	}

	@Override
	@Cacheable(cacheNames = "products",key = "#id")
	public Optional<Product> getProductById(int id) {
        System.out.println("enter getProductByid");
		return productrepo.findById(id);
	}

	@Override
	@CacheEvict(cacheNames="products",key="#id")
	public void deleteProductById(int id) {
		System.out.println("enter delete");
		productrepo.deleteById(id);
	}
     
	@Cacheable(cacheNames = "products")
	@Override
	public List<Product> getAllProduct() {
	    System.out.println("enter in getting products");
		return (List<Product>) productrepo.findAll();
	}

	@Override
	@Cacheable(cacheNames = "products" , key="#id")
	public Product getProductNameById(int id) {
		System.out.println("enter productnamebyid");
		Product product = this.productrepo.findProductNameByProductId(id);
		System.out.println(product.toString());
		return product;
	}
	

}
