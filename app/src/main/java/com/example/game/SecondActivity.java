package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.TextView;

import java.util.jar.Attributes;

public class SecondActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tv=findViewById(R.id.tv);

        Bundle extras=getIntent().getExtras();
        String Email="E";
        String Name="E";
        String Phone="E";
        if(extras !=null)
        {
            if(extras.containsKey("Name"))
            {
                Name=extras.getString("Name");
            }
            if(extras.containsKey("Email"))
            {
                Email=extras.getString("Email");
            }
            if(extras.containsKey("Phone"))
            {
                Phone=extras.getString("Phone");
            }
        }

        tv.setText("Name: "+ Name +"\n"); tv.append("Phone: "+ Phone +"\n"); tv.append("Email: "+ Email +"\n");
    }


}
