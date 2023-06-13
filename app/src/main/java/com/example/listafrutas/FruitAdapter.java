package com.example.listafrutas;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FruitAdapter extends ArrayAdapter<Fruit> {

    public FruitAdapter(Context context, List<Fruit> fruits) {
        super(context, 0, fruits);
    }

    @SuppressLint("StringFormatInvalid")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_fruit, parent, false);
        }

        Fruit currentFruit = getItem(position);

        ImageView imageViewFruit = listItemView.findViewById(R.id.imageViewFruit);
        imageViewFruit.setImageResource(currentFruit.getImageResId());
        imageViewFruit.setContentDescription(getContext().getString(R.string.fruit_image_description));

        TextView textViewName = listItemView.findViewById(R.id.textViewName);
        textViewName.setText(currentFruit.getName());

        TextView textViewCost = listItemView.findViewById(R.id.textViewCost);
        textViewCost.setText(getContext().getString(R.string.fruit_cost, currentFruit.getCost()));

        return listItemView;
    }
}
