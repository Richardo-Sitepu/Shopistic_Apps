package mmu.edu.my.shopistic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mmu.edu.my.shopistic.adapter.BestSellerProductAdapter;
import mmu.edu.my.shopistic.adapter.CategoryAdapter;
import mmu.edu.my.shopistic.adapter.RecentlyViewedAdapter;
import mmu.edu.my.shopistic.model.BestSellerProduct;
import mmu.edu.my.shopistic.model.Category;
import mmu.edu.my.shopistic.model.RecentlyViewed;

public class MainActivity extends AppCompatActivity {

    RecyclerView bestsellerRecyclerView, categoryRecyclerView, recentlyViewedRecycler;
    BestSellerProductAdapter bestSellerProductAdapter;
    List<BestSellerProduct> bestSellerProductList;
    CategoryAdapter categoryAdapter;
    List<Category> categoryList;

    RecentlyViewedAdapter recentlyViewedAdapter;
    List<RecentlyViewed> recentlyViewedList;

    TextView allCategory;
    ImageView camera, cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bestsellerRecyclerView = findViewById(R.id.bestsellerRecycler);
        categoryRecyclerView = findViewById(R.id.categoryRecycler);
        allCategory = findViewById(R.id.allCategoryImage);
        recentlyViewedRecycler = findViewById(R.id.recently_item);
        camera = findViewById(R.id.camView);
        cart = findViewById(R.id.cartView);

        allCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AllCategory.class);
                startActivity(i);
            }
        });

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, CameraActivity.class);
                startActivity(i);
            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AddCart.class);
                startActivity(i);
            }
        });

        //adding data to model
        bestSellerProductList = new ArrayList<>();
        bestSellerProductList.add(new BestSellerProduct(1, R.drawable.best1));
        bestSellerProductList.add(new BestSellerProduct(2, R.drawable.best2));
        bestSellerProductList.add(new BestSellerProduct(3, R.drawable.best3));
        bestSellerProductList.add(new BestSellerProduct(4, R.drawable.best4));
        bestSellerProductList.add(new BestSellerProduct(5, R.drawable.best5));
        bestSellerProductList.add(new BestSellerProduct(5, R.drawable.best6));
        bestSellerProductList.add(new BestSellerProduct(5, R.drawable.best7));
        bestSellerProductList.add(new BestSellerProduct(5, R.drawable.best8));

        //adding data to model
        categoryList = new ArrayList<>();
        categoryList.add(new Category(1, R.drawable.ic_home_cloth));
        categoryList.add(new Category(2, R.drawable.ic_home_shoes));
        categoryList.add(new Category(3, R.drawable.ic_home_heels));
        categoryList.add(new Category(4, R.drawable.ic_home_watch));
        categoryList.add(new Category(5, R.drawable.ic_home_health));

        //adding data to model
        recentlyViewedList = new ArrayList<>();
        recentlyViewedList.add(new RecentlyViewed("Dettol Hand Sanitizer","Instant Hand Sanitizer kills 99.9% of germs without water.","RM 24.37","500ml","", R.drawable.card1, R.drawable.h1));
        recentlyViewedList.add(new RecentlyViewed("Casio Baby-G Watch","Casio Baby-G Bluetooth Step Tracker BSA-B100MF-1A Original.","RM 430.09"," ","Black and Pink", R.drawable.card2, R.drawable.w1));
        recentlyViewedList.add(new RecentlyViewed("Vans Old Skool","Lightweight, stylish and comfortable. Between old school trends and modern style!","RM 344.07","-","Black and White", R.drawable.card3, R.drawable.s1));
        recentlyViewedList.add(new RecentlyViewed("Midi Collared Dress"," Pretty & Comfortable!","RM 43.01","All Size","Milo Brown", R.drawable.card4, R.drawable.c1));
        recentlyViewedList.add(new RecentlyViewed("Face Shield","Protects mask and face from direct splatter. May prolong mask life.","RM 2.87"," ","Transparant", R.drawable.card5, R.drawable.h2));

        setBestSellerRecycler(bestSellerProductList);
        setCategoryRecycler(categoryList);
        setRecentlyViewedRecycler(recentlyViewedList);

    }


    private void setBestSellerRecycler(List<BestSellerProduct> dataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        bestsellerRecyclerView.setLayoutManager(layoutManager);
        bestSellerProductAdapter = new BestSellerProductAdapter(this, dataList);
        bestsellerRecyclerView.setAdapter(bestSellerProductAdapter);
    }

    private void setCategoryRecycler(List<Category> categoryDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        categoryRecyclerView.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(this, categoryDataList);
        categoryRecyclerView.setAdapter(categoryAdapter);
    }

    private void setRecentlyViewedRecycler(List<RecentlyViewed> recentlyViewedDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recentlyViewedRecycler.setLayoutManager(layoutManager);
        recentlyViewedAdapter = new RecentlyViewedAdapter(this,recentlyViewedDataList);
        recentlyViewedRecycler.setAdapter(recentlyViewedAdapter);
    }
}