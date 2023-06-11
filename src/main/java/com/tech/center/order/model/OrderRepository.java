package com.tech.center.order.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
	//Search
	@Query(value = "SELECT * FROM orders o WHERE o.order_name like %:keyword% or CAST (o.budget AS TEXT) like %:keyword% or "
			+ "o.details like %:keyword% or o.category like %:keyword%", nativeQuery = true)
	List<Order> findByKeyword (@Param("keyword") String keyword);

}
