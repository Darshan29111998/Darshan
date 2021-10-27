package com.example.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.model.Product;
import com.example.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productservice;

	@PostMapping("/save")
	public ResponseEntity<?> addProduct(@RequestBody Product product) {
		this.productservice.saveProduct(product);
		return new ResponseEntity<>(null, null, HttpStatus.ACCEPTED);
	}

	@GetMapping("/display")
	public ResponseEntity<List<Product>> getAllProduct() {
		List<Product> list = this.productservice.getAllProduct();
		for (Product e : list) {
			System.out.println(e);
		}
		ResponseEntity<List<Product>> responseEntity = new ResponseEntity<>(list, HttpStatus.OK);
		System.out.println(responseEntity.toString());
		System.out.println("Http code : " + responseEntity.getStatusCodeValue());
		System.out.println("Body : " + responseEntity.getBody().toString());
		return responseEntity;
	}

	@DeleteMapping("/delete/{productId}")
	public ResponseEntity<?> deleteProduct(@PathVariable("productId") int id) {
		this.productservice.deleteProductById(id);
		return new ResponseEntity<>(null, null, HttpStatus.OK);

	}

	@PostMapping("/update")
	public ResponseEntity<?> updateProduct(@RequestBody Product product) {
		this.productservice.saveProduct(product);
		return new ResponseEntity<>(null, null, HttpStatus.OK);
	}

	@GetMapping("/getproductnamebyid/{id}")
	public Product getusernamebyid(@PathVariable("id") int id) {

		Product product = this.productservice.getProductNameById(id);
		System.out.println(product.toString());
		return product;

	}

}