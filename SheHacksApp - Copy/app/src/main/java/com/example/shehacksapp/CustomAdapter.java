package com.example.shehacksapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<String> implements View.OnClickListener {

    ArrayList<String> item;
    ArrayList<String> price;
//    double[] price;
    Context context;
    public static ImageView delete;
    ImageView image;
    String email;
    TextView blurb;
    public static int position1;
    String past;


    // View lookup cache
    private static class ViewHolder {
        TextView name;
        ImageView icon;
    }

    public CustomAdapter(ArrayList<String> item, ArrayList<String> price,Context context) {
        super(context, R.layout.custom_row, item);
        this.item = item;
        this.context = context;
        this.price = price;
//        blurb = t;
    }

    @Override
    public void onClick(View v) {
        Toast toast=Toast.makeText(context,"Hello Javatpoint", Toast.LENGTH_SHORT);
        toast.show();
    }

    private int lastPosition = -1;
    private static boolean edit;



    private ImageView getImage(ImageView i){
        return i;
    }

    @SuppressLint({"InflateParams", "ViewHolder"})
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.custom_row, null);
        image = convertView.findViewById(R.id.icon);
        TextView title = convertView.findViewById(R.id.name);
        String text = item.get(position) + " - $" + price.get(position);
        title.setText(text);

        return convertView;
    }
    public void edit(boolean s){ edit = s; }

    public static int getSize(){
        return position1;
    }
}
