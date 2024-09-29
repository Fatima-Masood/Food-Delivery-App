package com.example.myapplication;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.List;

public class HomeScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        // Search functionality example
        EditText searchBar = findViewById(R.id.search_bar);
        searchBar.setOnEditorActionListener((v, actionId, event) -> {
            String searchText = searchBar.getText().toString();
            if (!searchText.isEmpty()) {
                Toast.makeText(HomeScreen.this, "Searching for " + searchText, Toast.LENGTH_SHORT).show();
            }
            return false;
        });

        // Initialize RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2)); // 2 columns


        // List of food items with image resource, name, and price
        List<FoodItem> foodItems = Arrays.asList(
                new FoodItem(R.drawable.chicken_manchurian, "Chicken Manchurian", "Rs 715"),
                new FoodItem(R.drawable.classic_beef_lasagna, "Classic Beef Lasagna", "Rs 1020"),
                new FoodItem(R.drawable.red_spaghetti, "Red Spaghetti", "Rs 622"),
                new FoodItem(R.drawable.spicy_mushroom_dumplings, "Mushroom Dumplings", "Rs 550"),
                new FoodItem(R.drawable.chicken_manchurian, "Chicken Manchurian", "Rs 715"),
                new FoodItem(R.drawable.classic_beef_lasagna, "Classic Beef Lasagna", "Rs 1020"),
                new FoodItem(R.drawable.red_spaghetti, "Red Spaghetti", "Rs 622"),
                new FoodItem(R.drawable.spicy_mushroom_dumplings, "Mushroom Dumplings", "Rs 550")

        );

        // Set Adapter
        FoodAdapter adapter = new FoodAdapter(this, foodItems);
        recyclerView.setAdapter(adapter);
    }

    // Helper method to convert dp to pixels (optional if using RecyclerView)
    public int dpToPx(int dp) {
        return (int) (dp * getResources().getDisplayMetrics().density);
    }

    // Custom class to hold food item data
    class FoodItem {
        private final int imageResource;
        private final String name;
        private final String price;

        public FoodItem(int imageResource, String name, String price) {
            this.imageResource = imageResource;
            this.name = name;
            this.price = price;
        }

        public int getImageResource() {
            return imageResource;
        }

        public String getName() {
            return name;
        }

        public String getPrice() {
            return price;
        }
    }
}


