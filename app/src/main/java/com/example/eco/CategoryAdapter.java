package com.example.eco;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CategoryAdapter extends ArrayAdapter<Category> {

    public CategoryAdapter(@NonNull Activity context, ArrayList<Category> category) {
        super(context, 0, category);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Category categoryItems = getItem(position);

        ImageView ecoImageView = (ImageView) listItemView.findViewById(R.id.category_image);
        ecoImageView.setImageResource(categoryItems.getImage());

        TextView ecoTextView = (TextView) listItemView.findViewById(R.id.category_name);
        ecoTextView.setText(categoryItems.getCategory());

        return listItemView;
    }
}
