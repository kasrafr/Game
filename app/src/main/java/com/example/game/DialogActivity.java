package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
    }

    public void showprogressdialog(View view) {
        final ProgressDialog pdialog=new ProgressDialog(this);
        pdialog.setCancelable(false);
        pdialog.setTitle("Progress Dialog Example");
        pdialog.setMessage("Please Wait...");
        pdialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        //indefinite
        // pdialog.setIndeterminate(true);
        pdialog.show();
        // start from 10
        pdialog.setProgress(10);
        //process simulation
       new Timer().scheduleAtFixedRate(new TimerTask() {
           @Override
           public void run() {
               if (pdialog.getProgress()<pdialog.getMax()){
               pdialog.incrementProgressBy(1);}
               else{
                   pdialog.dismiss();
               }
           }
       },0,200);

       new Timer().scheduleAtFixedRate(new TimerTask() {
           @Override
           public void run() {
               if(pdialog==null) return;
               if (pdialog.getSecondaryProgress()<pdialog.getMax())
               {
                   pdialog.incrementSecondaryProgressBy(1);
               }
           }
       },0,140);

    }

    public void showalert(View view) {
        final AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Alert Dialog").setMessage("Do You Want Delete this File ?").setCancelable(false)
                .setIcon(android.R.drawable.ic_dialog_info).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(DialogActivity.this, "File Deleted", Toast.LENGTH_SHORT).show();
            }
        })
        .setNegativeButton("No",null)
        .setNeutralButton("cancel",null);
        builder.show();

    }
    public void showalert2(View view) {
        final AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(false).setSingleChoiceItems(new String[]{"a","b","c"},-1,new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(DialogActivity.this, "i: "+i, Toast.LENGTH_SHORT).show();
            }
        }).setTitle("question")
                .setPositiveButton("Ok",null);
        builder.show();
    }
    public void showalert3(View view) {
        final AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("").setCancelable(true).setMultiChoiceItems(new String[]{"Item 0", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5"},
                new boolean[]{false, true, false, true, true, false}, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        Toast.makeText(DialogActivity.this, "item i"+i+": "+b, Toast.LENGTH_SHORT).show();
                    }
                });
        builder.show();
    }
    public void showdialog(View view) {
        Dialog dialog=new Dialog(this);
        dialog.setTitle("DIALOG");
        dialog.setContentView(R.layout.play_ground);
        dialog.show();
    }
    public  void dropIn(View view) {
        ImageView img= (ImageView) view;
        img.setImageResource(R.drawable.yellow);
    }
}