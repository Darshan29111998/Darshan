package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Product;

public interface ProductRepo extends CrudRepository<Product,Integer>{
  public Product findProductNameByProductId(int id);
}
