package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SimpleListActivity extends AppCompatActivity {

    List<String> items;
    ListView listview;
    ArrayAdapter<String> adapter;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list);
        //list view
        items=new ArrayList<>();
        ///
        listview=findViewById(R.id.listview);
        prepareData();
        refreshdisplay();
    }
    private void prepareData()
    {
        items.add("Tehran");
        items.add("Mashhad");
        items.add("Esfehan");
        items.add("Shiraz");
        items.add("Kerman");
        items.add("Ferdos");
        items.add("Ahvaz");
        items.add("zahedan");
        items.add("Ardabil");
        items.add("Kermanshah");
        items.add("Shiraz");
        items.add("marand");
        items.add("shomal");
        items.add("qeshm");
        items.add("eilam");
        items.add("borojerd");
        items.add("eiza");

    }
    private void refreshdisplay() {
   adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
   listview.setAdapter(adapter);
   listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
       @Override
       public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
           Toast.makeText(SimpleListActivity.this, "clicl on: "+items.get(i), Toast.LENGTH_SHORT).show();
       }
   });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Add item").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                items.add("New Item");
                adapter.notifyDataSetChanged();
                return false;
            }
        });
        menu.add("RemoveItem").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if(items.isEmpty())
                    return  false;
               items.remove(items.size()-1);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}