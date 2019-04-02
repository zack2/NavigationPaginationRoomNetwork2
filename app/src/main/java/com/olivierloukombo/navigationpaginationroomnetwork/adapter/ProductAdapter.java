package com.olivierloukombo.navigationpaginationroomnetwork.adapter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.olivierloukombo.navigationpaginationroomnetwork.R;
import com.olivierloukombo.navigationpaginationroomnetwork.data.entity.Products;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public class ProductAdapter extends PagedListAdapter<Products, ProductAdapter.ViewHolder> {
    private static final String TAG = ProductAdapter.class.getSimpleName();
    private List<Products> items = new ArrayList<>();
    private View v;
    public ProductAdapter() {
        super(DIFF_CALLBACK);
    }

    public List<Products> getItems() {
        return items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductAdapter.ViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Products p = getItem(position);
        assert p != null;
        holder.title.setText(p.getName());
        if(p.getPriceSign() == null)
            holder.price.setText(" $ " + p.getPrice() );
        else if (p.getPrice() == null)
        holder.price.setText("$ 0");
        else  holder.price.setText( p.getPriceSign()+ "" +p.getPrice() );


        Glide.with(v.getContext())
                    .load(p.getImage())
                    .into(holder.image)
        ;
        Log.e(TAG, "onBindViewHolder: "+ p.getName()+ " price " + p.getPrice() );

        Bundle bundle = new Bundle();
        bundle.putParcelable("product_key", p);

        holder.lytParent.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.detailMainFragment, bundle));
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title;
        TextView price;
        ImageButton more;
        View lytParent;

        ViewHolder(View v) {
            super(v);

            image = v.findViewById(R.id.image);
            title = v.findViewById(R.id.title);
            price = v.findViewById(R.id.price);
            more = v.findViewById(R.id.more);
            lytParent = v.findViewById(R.id.lyt_parent);
        }
    }


    private static DiffUtil.ItemCallback<Products> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Products>() {
                // Concert details may have changed if reloaded from the database,
                // but ID is fixed.
                @Override
                public boolean areItemsTheSame(Products oldConcert, Products newConcert) {
                    return oldConcert.getId() == newConcert.getId();
                }

                @Override
                public boolean areContentsTheSame(Products oldConcert,
                                                  @NonNull Products newConcert) {
                    return oldConcert.equals(newConcert);
                }
            };
}
