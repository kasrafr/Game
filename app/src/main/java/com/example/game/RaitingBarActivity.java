package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class RaitingBarActivity extends AppCompatActivity {
    RatingBar ratingbar;
    Button btn_submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raiting_bar);
        ratingbar=findViewById(R.id.ratingBar);
        btn_submit=findViewById(R.id.btn_submit_rate);
        // change RatingBar
        ratingbar.setNumStars(6);
        ratingbar.setRating(1.5f);
        // click
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(RaitingBarActivity.this, "Rating: "+ratingbar.getRating(), Toast.LENGTH_SHORT).show();
                ratingbar.setRating(3);
            }
        });
        ratingbar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float value, boolean fromuser) {
                if (fromuser) {
                    Toast.makeText(RaitingBarActivity.this, "Rating: " + value, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}