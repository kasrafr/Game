package com.example.game;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class ImageViewActivity extends AppCompatActivity {
    ImageView bunny;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        //Set back button on action Bar
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        //imageView object set
        bunny=findViewById(R.id.bunny);
        bunny.setAlpha(1f);
        // bunny.setTranslationX(2000);
        //  bunny.animate().translationXBy(-2000).setDuration(2000);
        bunny.setTranslationX(-1500);
        bunny.setTranslationY(-1500);
        customAnimation();

    }

    private void customAnimation() {
        bunny.animate().translationX(0).translationY(0).rotationBy(3600f).setDuration(2000);
    }


    //write cod for back button on action Bar
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==android.R.id.home)
        {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    public  void animate (View v){
        //animate function
        //bunny.animate().alpha(1f).setDuration(2000);
        //bunny.animate().translationYBy(50).setDuration(1000);
        //bunny.animate().rotation(90f).setDuration(2000);
        bunny.animate().scaleX(0.5f).setDuration(2000);
    }

}
