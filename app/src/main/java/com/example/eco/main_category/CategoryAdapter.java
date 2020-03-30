package com.example.eco.main_category;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.eco.R;
import com.example.eco.main_category.Category;

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

        // Get the {@link AndroidFlavor} object located at this position in the list
        Category categoryItems = getItem(position);

        // Find the ImageView in the list_item.xml layout with the ID version_name
        ImageView ecoImageView = (ImageView) listItemView.findViewById(R.id.category_image);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name ImageView
        ecoImageView.setImageResource(categoryItems.getImage());

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView ecoTextView = (TextView) listItemView.findViewById(R.id.category_name);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        ecoTextView.setText(categoryItems.getCategory());

        // Return the whole list item layout (containing 1 TextViews and an ImageView)
        // so that it can be shown in the ListView

        return listItemView;
    }
}
