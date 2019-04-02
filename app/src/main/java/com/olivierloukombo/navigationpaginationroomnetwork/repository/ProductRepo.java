package com.olivierloukombo.navigationpaginationroomnetwork.repository;

import android.app.Application;


import com.olivierloukombo.navigationpaginationroomnetwork.data.DatabaseApp;
import com.olivierloukombo.navigationpaginationroomnetwork.data.dao.ProductDao;
import com.olivierloukombo.navigationpaginationroomnetwork.data.entity.Products;
import com.olivierloukombo.navigationpaginationroomnetwork.network.Network;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;


public class ProductRepo {
    private static final String TAG = ProductRepo.class.getSimpleName();
    private ProductDao productDao;
    private ArrayList<Products> products;
    private LiveData<PagedList<Products>> pagedListLiveData;

    public ProductRepo(Application application){
        products = Network.parse(application.getApplicationContext());
        Executor executor =  Executors.newFixedThreadPool(5);
        DatabaseApp dataBase = DatabaseApp.getInstance(application);
        productDao = dataBase.productDao();
        executor.execute(() -> productDao.insertAll(products));

        PagedList.Config myPagingConfig = new PagedList.Config.Builder()
                .setPageSize(20)
                .setInitialLoadSizeHint(5)
                .setPrefetchDistance(10)
                .setEnablePlaceholders(true)
                .build();
        pagedListLiveData = new LivePagedListBuilder<>(productDao.getAll(), myPagingConfig)
                .setFetchExecutor(executor)
                // .setBoundaryCallback(new ProductBoundaryCallback())
                .build();
    }


    public LiveData<PagedList<Products>> getAll(){
        return  pagedListLiveData;
    }

}
