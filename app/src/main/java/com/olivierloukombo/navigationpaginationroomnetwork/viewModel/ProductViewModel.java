package com.olivierloukombo.navigationpaginationroomnetwork.viewModel;

import android.app.Application;

import com.olivierloukombo.navigationpaginationroomnetwork.data.entity.Products;
import com.olivierloukombo.navigationpaginationroomnetwork.repository.ProductRepo;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

public class ProductViewModel extends AndroidViewModel {
    private ProductRepo productRepo;

    public ProductViewModel(@NonNull Application application) {
        super(application);
        productRepo = new ProductRepo(application);
    }


    public LiveData<PagedList<Products>> getAll() {
        return productRepo.getAll();
    }

}
