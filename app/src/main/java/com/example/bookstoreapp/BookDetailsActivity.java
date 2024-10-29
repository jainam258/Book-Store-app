package com.example.bookstoreapp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class BookDetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        String title = getIntent().getStringExtra("title");
        String author = getIntent().getStringExtra("author");
        double price = getIntent().getDoubleExtra("price", 0.0);
        int image = getIntent().getIntExtra("image", 0);

        TextView tvTitle = findViewById(R.id.tvTitle);
        TextView tvAuthor = findViewById(R.id.tvAuthor);
        TextView tvPrice = findViewById(R.id.tvPrice);
        ImageView ivBook = findViewById(R.id.ivBook);

        tvTitle.setText(title);
        tvAuthor.setText("Author: " + author);
        tvPrice.setText("Price: ₹" + price);
        ivBook.setImageResource(image);
    }
}
