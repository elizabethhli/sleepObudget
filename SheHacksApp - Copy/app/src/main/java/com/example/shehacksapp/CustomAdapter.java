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

    public CustomAdapter(ArrayList<String> item, Context context) {
        super(context, R.layout.custom_row, item);
        this.item = item;
        this.context = context;
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

//        final String item2 = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view


        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.custom_row, null);
        image = convertView.findViewById(R.id.icon);
        TextView title = convertView.findViewById(R.id.name);
//        delete = convertView.findViewById(R.id.delete);

        title.setText(item.get(position));




//            if (edit) {
//                delete.setVisibility(View.VISIBLE);
//                delete.setOnClickListener(new View.OnClickListener() {
//                    @SuppressLint("SetTextI18n")
//                    @Override
//                    public void onClick(View v) {
//                        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.AlertDialogTheme);
//                        final View view = LayoutInflater.from(context).inflate(R.layout.layout_alert_dialog_amount, null);
//                        builder.setView(view);
//                        ((TextView)view.findViewById(R.id.message_text2)).setText("Are you sure you want\nto delete this chore?\n This action cannot be\nundone.");
//                        ((TextView)view.findViewById(R.id.title_text_alert2)).setText("Delete Chore?");
//                        final AlertDialog alertDialog = builder.create();
//                        final DatabaseHelper db = new DatabaseHelper(context);
//                        view.findViewById(R.id.neg_button_room).setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                alertDialog.dismiss();
//                            }
//                        });
//                        if (alertDialog.getWindow() != null){
//                            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
//                        }
//                        alertDialog.show();
//
//                    }
//                });
//            }
//            image.setImageResource(item2.getImage());
//            title.setText(item2.getName());

        return convertView;
    }
    public void edit(boolean s){ edit = s; }

    public static int getSize(){
        return position1;
    }
}
