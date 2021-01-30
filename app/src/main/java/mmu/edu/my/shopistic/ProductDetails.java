package mmu.edu.my.shopistic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductDetails extends AppCompatActivity {

    ImageView img, back;
    TextView proName, proPrice, proDesc, proSize, proColour;

    String name, price, desc, size, colour;
    int image;

    Button buynow;
    ImageButton addCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);



        Intent i = getIntent();

        name = i.getStringExtra("name");
        price = i.getStringExtra("price");
        desc = i.getStringExtra("description");
        image = i.getIntExtra("image", R.drawable.d1);
        size = i.getStringExtra("size");
        colour = i.getStringExtra("colour");

        proName = findViewById((R.id.productName));
        proPrice = findViewById((R.id.prodPrice));
        proDesc = findViewById((R.id.prodDesc));
        img = findViewById((R.id.big_image));
        proSize = findViewById((R.id.size));
        proColour = findViewById((R.id.colour));
        back = findViewById((R.id.back2));

        proName.setText(name);
        proPrice.setText(price);
        proDesc.setText(desc);
        proSize.setText(size);
        proColour.setText(colour);

        img.setImageResource(image);

        buynow = findViewById(R.id.buynow);
        buynow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(ProductDetails.this, Payment.class);
                startActivity(intent);
            }
        });

        addCart = findViewById(R.id.addCart);
        addCart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent in = new Intent(ProductDetails.this, AddCart.class);
                startActivity(in);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(ProductDetails.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

}