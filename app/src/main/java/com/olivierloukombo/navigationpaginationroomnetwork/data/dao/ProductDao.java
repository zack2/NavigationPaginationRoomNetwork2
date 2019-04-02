package com.olivierloukombo.navigationpaginationroomnetwork.data.dao;

import com.olivierloukombo.navigationpaginationroomnetwork.data.entity.Products;

import java.util.List;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;


@Dao
public interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Products> productList);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertProduct(Products products);

    @Query("SELECT * FROM table_product")
    DataSource.Factory<Integer, Products> getAll();
}
