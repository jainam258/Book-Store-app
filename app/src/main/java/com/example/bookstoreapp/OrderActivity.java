
package com.example.bookstoreapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class OrderActivity extends AppCompatActivity {
    Button backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        backButton = findViewById(R.id.backButton);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        backButton = findViewById(R.id.backButton);

        TextView tvOrderSummary = findViewById(R.id.tvOrderSummary);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        // Retrieve the total price passed from CartActivity
        double totalPrice = getIntent().getDoubleExtra("totalPrice", 0.0);

        tvOrderSummary.setText("Your order total is: ₹" + totalPrice);


    }

}

