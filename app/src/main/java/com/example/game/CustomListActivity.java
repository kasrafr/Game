package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CustomListActivity extends AppCompatActivity {

    List<MyContact> contacts;
    ListView listView;
    //my custom adapter
    ContactAdapter adapter; // ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);
        listView=findViewById(R.id.list);
        contacts=new ArrayList<>();
        prepareData();
        refreshdisplay();

    }
    private void prepareData() {
        contacts.add(new MyContact("kasra","09383959599",R.drawable.profile1));
        contacts.add(new MyContact("javad javadi","09183301568",R.drawable.profile2));
        contacts.add(new MyContact("mehran","0359515544",R.drawable.profile3));
        addfakecontact(7);
        contacts.add(new MyContact("mohsen","7775121212",R.drawable.profile4));
        contacts.add(new MyContact("kataun","5454545477",R.drawable.profile5));
        contacts.add(new MyContact("mostafa","575445457",R.drawable.profile6));
        addfakecontact(5);
        contacts.add(new MyContact("haramzaye","242445454",R.drawable.profile7));
        contacts.add(new MyContact("nadoros","0945454599",R.drawable.profile8));
        contacts.add(new MyContact("sadri","0855953749",R.drawable.profile9));
        contacts.add(new MyContact("kazem","568514586",R.drawable.profile10));
        addfakecontact(6);


    }

    private void addfakecontact(int n) {
        for(int i=0;i<n;i++)
        {
            contacts.add(new MyContact("Fake contact"+i,"09206802718"+i,0));
        }
    }

    private void refreshdisplay() {
        //custom adapter
        adapter=new ContactAdapter(this,contacts);
        //adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,contacts);
        listView.setAdapter(adapter);
        
    }
}