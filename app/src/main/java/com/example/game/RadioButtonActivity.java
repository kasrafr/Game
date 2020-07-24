package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RadioButtonActivity extends AppCompatActivity implements View.OnClickListener {
RadioGroup radio_group;
Button btn_display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);
        radio_group=findViewById(R.id.radio_group);
/*        radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton rb=findViewById(radio_group.getCheckedRadioButtonId());
                rb.setBackgroundResource(R.drawable.radiobutton_b);
            }
        });*/
        btn_display=findViewById(R.id.bt_display);
        btn_display.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==btn_display.getId())
        {
            int radio_buttonID=radio_group.getCheckedRadioButtonId();
            RadioButton radio_button=findViewById(radio_buttonID);
            Toast.makeText(this, radio_button.getTag().toString(), Toast.LENGTH_SHORT).show();
        }
    }
}