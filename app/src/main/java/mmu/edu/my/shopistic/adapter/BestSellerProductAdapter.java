package mmu.edu.my.shopistic.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import mmu.edu.my.shopistic.R;
import mmu.edu.my.shopistic.model.BestSellerProduct;

    public class BestSellerProductAdapter extends RecyclerView.Adapter<BestSellerProductAdapter.BestSellerProductViewHolder> {

        Context context;
        List<BestSellerProduct> bestSellerProductList;

        public BestSellerProductAdapter(Context context, List<BestSellerProduct> bestSellerProductList) {
            this.context = context;
            this.bestSellerProductList = bestSellerProductList;
        }

        @NonNull
        @Override
        public BestSellerProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(context).inflate(R.layout.bestseller_row_items, parent, false);
            return new BestSellerProductViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull BestSellerProductViewHolder holder, int position) {
            holder.bestsellerImageView.setImageResource(bestSellerProductList.get(position).getImageurl());

        }

        @Override
        public int getItemCount() {
            return bestSellerProductList.size();
        }

        public static class BestSellerProductViewHolder extends RecyclerView.ViewHolder {

            ImageView bestsellerImageView;

            public BestSellerProductViewHolder(@NonNull View itemView) {
                super(itemView);

                bestsellerImageView = itemView.findViewById(R.id.bestsellerImage);
            }
        }
    }
