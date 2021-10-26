package ru.lyubava.loftmoney;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemViewHolder> {

    private List<Item> items = new ArrayList<>();
    private int currentPosition;

    public void setItems(List<Item> items, int position) {
        this.items.clear();
        this.items = items;
        currentPosition = position;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item, viewGroup, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int position) {
        Item item = items.get(position);
        itemViewHolder.bind(item, currentPosition);
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView price;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
        }

        public void bind(Item item, int currentPosition){
            name.setText(item.getName());
            price.setText(item.getPrice());
            if (currentPosition == 0) {
                price.setTextColor(Color.parseColor("#4A90E2"));
            } else {
                price.setTextColor(Color.parseColor("#7ED321"));
            }
        }
    }
}
