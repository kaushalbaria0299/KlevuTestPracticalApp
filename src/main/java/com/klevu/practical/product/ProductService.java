package com.klevu.practical.product;

import java.util.List;

/**
 * 
 * @author Kaushal Baria
 *
 */
public interface ProductService {

	/**
	 * 
	 * @param productId
	 * @return List<ProductOrderDTO>
	 */
	List<ProductOrderDTO> getProductWithSuggestedProduct(String productId);
}
