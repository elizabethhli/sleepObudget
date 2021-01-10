package com.example.shehacksapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;


public class CustomAlertDialog extends DialogFragment {

    /*
     * Method that will display a message when the help button is clicked
     * String s is the message that will be displayed
     */
    public static void openDialog(Activity a, final Context c, ConstraintLayout l, String m, String t){
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(c, R.style.AlertDialogTheme);
        View view = LayoutInflater.from(c).inflate(
                R.layout.layout_alert_dialog, l);
        builder.setView(view);
        ((TextView) view.findViewById(R.id.message_text)).setText(m);
        ((TextView) view.findViewById(R.id.title_text_alert)).setText(t);


        final android.app.AlertDialog alertDialog = builder.create();

        view.findViewById(R.id.pos_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

        if (alertDialog.getWindow() != null){
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
    }//end method open dialog

    public static void openDialog2(Activity a, final Context c, ConstraintLayout l, String m){
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(c, R.style.AlertDialogTheme);
        View view = LayoutInflater.from(c).inflate(
                R.layout.layout_alert_dialog2, l);
        builder.setView(view);
        ((TextView) view.findViewById(R.id.message_text2)).setText(m);

        final android.app.AlertDialog alertDialog = builder.create();

        view.findViewById(R.id.pos_button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

        if (alertDialog.getWindow() != null){
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
    }//end method open dialog

    public static void openDialogBold(Activity a, final Context c, ConstraintLayout l, String m){
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(c, R.style.AlertDialogTheme);
        View view = LayoutInflater.from(c).inflate(
                R.layout.layout_alert_dialog, l);
        builder.setView(view);
        ((TextView) view.findViewById(R.id.message_text)).setText(m);
        ((TextView) view.findViewById(R.id.message_text)).setTypeface(null, Typeface.BOLD);
        final android.app.AlertDialog alertDialog = builder.create();

        view.findViewById(R.id.pos_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

        if (alertDialog.getWindow() != null){
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
    }//end method open dialog

    public static void openDialogNoTitle(Activity a, final Context c, ConstraintLayout l, String m){
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(c, R.style.AlertDialogTheme);
        View view = LayoutInflater.from(c).inflate(
                R.layout.layout_alert_dialog3, l);
        builder.setView(view);
        ((TextView) view.findViewById(R.id.message_text)).setText(m);


        final android.app.AlertDialog alertDialog = builder.create();

        view.findViewById(R.id.pos_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

        if (alertDialog.getWindow() != null){
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
    }//end method open dialog

    public static void openDialogNoTitleNoButton(Activity a, final Context c, ConstraintLayout l, String m){
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(c, R.style.AlertDialogTheme);
        View view = LayoutInflater.from(c).inflate(
                R.layout.layout_alert_dialog3, l);
        builder.setView(view);
        ((TextView) view.findViewById(R.id.message_text)).setText(m);


        final android.app.AlertDialog alertDialog = builder.create();

        view.findViewById(R.id.pos_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

        if (alertDialog.getWindow() != null){
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
    }//end method open dial
}//end class

