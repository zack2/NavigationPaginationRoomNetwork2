package com.olivierloukombo.navigationpaginationroomnetwork.repository;

import com.olivierloukombo.navigationpaginationroomnetwork.data.entity.Products;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;


public class ProductDataSourceFactory extends DataSource.Factory<Integer, Products> {

    @NonNull
    @Override
    public DataSource<Integer, Products> create() {
        return null;
    }
}
