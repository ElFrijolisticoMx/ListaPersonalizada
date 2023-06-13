package com.example.listafrutas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listafrutas.Fruit;
import com.example.listafrutas.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView fruitsListView;
    private FruitAdapter fruitAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);
        List<Fruit> fruits = new ArrayList<>(); // Aquí agregas las frutas a la lista
        ListAdapter adapter = (ListAdapter) new FruitAdapter(this, fruits);
        listView.setAdapter(adapter);


        fruitsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit selectedFruit = fruitAdapter.getItem(position);
                Toast.makeText(MainActivity.this, "Se ha agregado " + selectedFruit.getName() + " al carrito", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private List<Fruit> generateFruits() {
        List<Fruit> fruits = new ArrayList<>();

        //frutas
        fruits.add(new Fruit("Manzana", 1.99, R.drawable.apple_image));
        fruits.add(new Fruit("Banana", 0.99, R.drawable.banana_image));
        fruits.add(new Fruit("Naranja", 0.79, R.drawable.orange_image));
        fruits.add(new Fruit("Sandía", 2.49, R.drawable.watermelon_image));
        fruits.add(new Fruit("Pera", 1.49, R.drawable.pear_image));
        fruits.add(new Fruit("Fresa", 1.29, R.drawable.strawberry_image));
        fruits.add(new Fruit("Uva", 1.69, R.drawable.grape_image));
        fruits.add(new Fruit("Piña", 2.99, R.drawable.pineapple_image));
        fruits.add(new Fruit("Mango", 2.79, R.drawable.mango_image));
        fruits.add(new Fruit("Melón", 1.99, R.drawable.melon_image));

        return fruits;
    }

}