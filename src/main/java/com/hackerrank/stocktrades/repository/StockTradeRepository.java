package com.hackerrank.stocktrades.repository;

import com.hackerrank.stocktrades.model.StockTrade;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockTradeRepository extends JpaRepository<StockTrade, Integer> {
	public List<StockTrade> findByUserId(int userId);
	public List<StockTrade> findByType(String type);
	public List<StockTrade> findByUserIdAndType(int userId,String type);
}
