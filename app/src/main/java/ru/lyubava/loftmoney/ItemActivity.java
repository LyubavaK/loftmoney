package ru.lyubava.loftmoney;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class ItemActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private ItemsAdapter adapter = new ItemsAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        configureRecyclerView();
        generateItem();
    }

    private void generateItem() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Молоко", "70 Р"));
        items.add(new Item("Зубная щётка", "70 Р"));
        items.add(new Item("Сковородка с антипригарным покрытием", "1670 Р"));

        adapter.setItems(items);
    }

    private void configureRecyclerView() {
        recyclerView = findViewById(R.id.recycler);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}