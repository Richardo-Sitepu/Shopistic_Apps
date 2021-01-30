package mmu.edu.my.shopistic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddCart extends AppCompatActivity {

    Button buynow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cart);

        buynow = findViewById(R.id.buynow);
        buynow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(AddCart.this, Payment.class);
                startActivity(intent);
            }
        });
    }
}