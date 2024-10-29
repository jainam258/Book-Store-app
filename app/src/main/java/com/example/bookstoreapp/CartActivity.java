package com.example.bookstoreapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import com.example.bookstoreapp.Book;

public class CartActivity extends AppCompatActivity {
    private ArrayList<Book> cartItems;
    private TextView tvCartDetails;
    private double totalPrice = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        tvCartDetails = findViewById(R.id.tvCartDetails);
        Button btnOrder = findViewById(R.id.btnOrder);

        // Receive cart items passed via Intent from BookListActivity
        cartItems = (ArrayList<Book>) getIntent().getSerializableExtra("cart");

        displayCartDetails();

        btnOrder.setOnClickListener(v -> {
            Intent intent = new Intent(CartActivity.this, OrderActivity.class);
            intent.putExtra("totalPrice", totalPrice);
            startActivity(intent);
        });
    }

    private void displayCartDetails() {
        StringBuilder details = new StringBuilder("Books in Cart:\n");
        for (Book book : cartItems) {
            details.append(book.getTitle())
                    .append(" - ₹")
                    .append(book.getPrice())
                    .append("\n");
            totalPrice += book.getPrice();
        }
        details.append("\nTotal: ₹").append(totalPrice);
        tvCartDetails.setText(details.toString());
    }
}

