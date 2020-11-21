package com.klevu.practical.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Kaushal Baria
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<ProductOrderDTO> getProductWithSuggestedProduct(String productId) {
		return productRepository.getProductWithSuggestedProduct(productId);
	}
}
