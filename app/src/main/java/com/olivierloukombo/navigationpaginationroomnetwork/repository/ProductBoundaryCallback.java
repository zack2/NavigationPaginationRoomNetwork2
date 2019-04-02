package com.olivierloukombo.navigationpaginationroomnetwork.repository;

import androidx.annotation.NonNull;
import androidx.paging.PagedList;

public class ProductBoundaryCallback extends PagedList.BoundaryCallback {

    public ProductBoundaryCallback() {
        super();
    }

    @Override
    public void onZeroItemsLoaded() {
        super.onZeroItemsLoaded();
    }

    @Override
    public void onItemAtFrontLoaded(@NonNull Object itemAtFront) {
        super.onItemAtFrontLoaded(itemAtFront);
    }

    @Override
    public void onItemAtEndLoaded(@NonNull Object itemAtEnd) {
        super.onItemAtEndLoaded(itemAtEnd);
    }
}
