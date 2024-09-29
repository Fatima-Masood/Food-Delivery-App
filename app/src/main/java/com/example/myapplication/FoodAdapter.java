package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {
    private final List<HomeScreen.FoodItem> foodItems;
    private final Context context;

    public FoodAdapter(Context context, List<HomeScreen.FoodItem> foodItems) {
        this.context = context;
        this.foodItems = foodItems;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_food, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        HomeScreen.FoodItem item = foodItems.get(position);
        holder.imageView.setImageResource(item.getImageResource());
        holder.nameTextView.setText(item.getName());
        holder.priceTextView.setText(item.getPrice());
    }

    @Override
    public int getItemCount() {
        return foodItems.size();
    }

    static class FoodViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView nameTextView;
        TextView priceTextView;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.food_image);
            nameTextView = itemView.findViewById(R.id.food_name);
            priceTextView = itemView.findViewById(R.id.food_price);
        }
    }
}
