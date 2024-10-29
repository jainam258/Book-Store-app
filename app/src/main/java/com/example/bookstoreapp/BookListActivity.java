package com.example.bookstoreapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class BookListActivity extends AppCompatActivity {

    private String username;  // Store the username
    private ArrayList<Book> cart = new ArrayList<>();  // Store selected books for the cart

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        // Get the username from the intent
        username = getIntent().getStringExtra("username");

        // Display greeting message
        TextView tvGreeting = findViewById(R.id.tvGreeting);
        tvGreeting.setText("Welcome, " + username + "!");

        // Initialize RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Prepare book data
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Book 1", "Ram", 9.99, R.drawable.book1));
        books.add(new Book("Book 2", "Devang", 12.99, R.drawable.book2));
        books.add(new Book("Book 3", "Jay", 56.99, R.drawable.book3));
        books.add(new Book("Book 4", "Raj", 78.99, R.drawable.book4));

        // Set up RecyclerView adapter with a click listener to show a confirmation dialog
        BookAdapter adapter = new BookAdapter(books, book -> {
            showConfirmationDialog(book);  // Show dialog when a book is clicked
        });
        recyclerView.setAdapter(adapter);

        // Set up Cart button
        Button btnCart = findViewById(R.id.btnCart);
        btnCart.setOnClickListener(v -> {
            Intent intent = new Intent(BookListActivity.this, CartActivity.class);
            intent.putExtra("cart", cart);  // Pass the cart to the next activity
            startActivity(intent);
        });
    }

    // Method to show confirmation dialog when a book is clicked
    private void showConfirmationDialog(Book book) {
        new AlertDialog.Builder(this)
                .setTitle("Add Book to Cart")
                .setMessage("Are you sure you want to add \"" + book.getTitle() + "\" to the cart?")
                .setPositiveButton("Yes", (dialog, which) -> {
                    cart.add(book);  // Add the book to the cart
                    dialog.dismiss();  // Close the dialog
                })
                .setNegativeButton("No", (dialog, which) -> dialog.dismiss())  // Close without adding
                .show();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(BookListActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
