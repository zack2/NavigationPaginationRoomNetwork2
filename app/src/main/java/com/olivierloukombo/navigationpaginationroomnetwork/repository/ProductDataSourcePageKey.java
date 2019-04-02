package com.olivierloukombo.navigationpaginationroomnetwork.repository;

import com.olivierloukombo.navigationpaginationroomnetwork.data.dao.ProductDao;
import com.olivierloukombo.navigationpaginationroomnetwork.data.entity.Products;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

public class ProductDataSourcePageKey extends PageKeyedDataSource<Integer, Products> {
    ProductDao productDao;
    public ProductDataSourcePageKey(ProductDao mDao){
        productDao = mDao;

    }
    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, Products> callback) {
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Products> callback) {

    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Products> callback) {

    }
}
