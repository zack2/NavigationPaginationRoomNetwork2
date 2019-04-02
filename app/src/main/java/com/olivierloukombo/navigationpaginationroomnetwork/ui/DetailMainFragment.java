package com.olivierloukombo.navigationpaginationroomnetwork.ui;


import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.olivierloukombo.navigationpaginationroomnetwork.R;
import com.olivierloukombo.navigationpaginationroomnetwork.data.entity.Products;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailMainFragment extends Fragment {
    private View parentView;
    private View lytExpandDescription;
    private NestedScrollView nestedScrollView;

    public DetailMainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_main, container, false);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ImageView imageView = view.findViewById(R.id.image);
        TextView title = view.findViewById(R.id.product_name);
        TextView tvDescription = view.findViewById(R.id.description);
        parentView = view.findViewById(R.id.parent_view);

        lytExpandDescription = view.findViewById(R.id.lyt_expand_description);
        RatingBar ratingBar = view.findViewById(R.id.ratingBar);
        TextView price = view.findViewById(R.id.price);
        Bundle bundle = getArguments();
        if (bundle != null) {
            Products product = bundle.getParcelable("product_key");
            assert product != null;

            title.setText(product.getName());
            tvDescription.setText(product.getDescription());
            Glide.with(view.getContext())
                    .load(product.getImage())
                    .into(imageView)
            ;

            ratingBar.setIsIndicator(true);
            ratingBar.setNumStars(5);
            ratingBar.setMax(5);
            if (product.getRating() == 0) ratingBar.setRating(0);
            else ratingBar.setRating(product.getRating()/2);

            if (product.getPriceSign() == null) price.setText(" $ " + product.getPrice());
            else if (product.getPrice() == null) price.setText("$ 0");
            else price.setText(product.getPriceSign() + "" + product.getPrice());


        }
    }


}
