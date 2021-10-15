package ru.lyubava.loftmoney;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class AddItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        int costId = getIntent().getIntExtra("COST_ID", 0);
        Log.e("TAG", "Cost id = " + costId);
    }
}