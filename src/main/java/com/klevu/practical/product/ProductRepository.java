package com.klevu.practical.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<ProductOrder, Integer> {

	@Query(value = "SELECT COUNT(1) AS COUNT,product_Id AS productId, product_Name AS productName "
			+ " FROM order_table  WHERE product_id = :productId " + " HAVING COUNT(order_Id) <> 0 "
			+ " UNION ALL " + " (SELECT COUNT(1) AS COUNT,Product_Id,Product_Name FROM klevu_ind_test_db.order_table "
			+ " WHERE customer_ip IN ( SELECT customer_ip FROM order_table WHERE product_id = :productId) "
			+ " AND product_id <> :productId " + " GROUP BY product_id " + " ORDER BY COUNT(1) DESC " + "LIMIT 4) "
			+ " ORDER BY COUNT DESC, productName; ", nativeQuery = true)
	List<ProductOrderDTO> getProductWithSuggestedProduct(@Param("productId") String productId);
}
