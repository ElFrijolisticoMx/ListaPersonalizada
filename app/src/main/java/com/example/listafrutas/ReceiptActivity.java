package com.example.listafrutas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

public class ReceiptActivity extends AppCompatActivity {

    private ListView selectedFruitsListView;
    private TextView totalTextView;
    private Button payButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receip);

        selectedFruitsListView = findViewById(R.id.selectedFruitsListView);
        totalTextView = findViewById(R.id.totalTextView);
        payButton = findViewById(R.id.payButton);


        List<Fruit> selectedFruits = (List<Fruit>) getIntent().getSerializableExtra("selectedFruits");

        //total//
        double total = 0;
        for (Fruit fruit : selectedFruits) {
            total += fruit.getCost();
        }

        // Crea el adaptador para el ListView
        ArrayAdapter<Fruit> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, selectedFruits);
        selectedFruitsListView.setAdapter(adapter);

        // Muestra el total en el TextView
        totalTextView.setText(String.format(Locale.getDefault(), "Total: $%.2f", total));

        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Reinicia la aplicación
                Intent intent = new Intent(ReceiptActivity.this, com.example.listafrutas.MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
    }
}