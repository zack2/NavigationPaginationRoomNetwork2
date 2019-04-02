package com.olivierloukombo.navigationpaginationroomnetwork.ui;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.olivierloukombo.navigationpaginationroomnetwork.R;
import com.olivierloukombo.navigationpaginationroomnetwork.SpacingItemDecoration;
import com.olivierloukombo.navigationpaginationroomnetwork.Utils;
import com.olivierloukombo.navigationpaginationroomnetwork.adapter.ProductAdapter;
import com.olivierloukombo.navigationpaginationroomnetwork.viewModel.ProductViewModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    private ProductViewModel productViewModel;
    private static final String TAG = MainFragment.class.getSimpleName();

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
       // downloadData(context);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        productViewModel = ViewModelProviders.of(this).get(ProductViewModel.class);
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setTitle("Main");
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), 2));
        recyclerView.addItemDecoration(new SpacingItemDecoration(1, Utils.dpToPx(view.getContext(), 4), true));
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        ProductAdapter productAdapter = new ProductAdapter();
        productViewModel.getAll().observe(this, productAdapter::submitList);

        recyclerView.setAdapter(productAdapter);
    }



}
