package com.klevu.practical.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Kaushal Baria
 *
 */
@RestController()
@RequestMapping("product")
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping()
	@RequestMapping(value = "/get/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getProductWithSuggestedProduct(@PathVariable String productId) {
		return productService.getProductWithSuggestedProduct(productId);
	}

}
