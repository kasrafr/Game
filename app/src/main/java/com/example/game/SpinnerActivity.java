package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnerActivity extends AppCompatActivity {
    Spinner SimpleSpinner;
    String[] SimpleItems;
    int[] countryFlag={R.drawable.flag_cn,R.drawable.flag_cz,R.drawable.flag_de,R.drawable.flag_dk,R.drawable.flag_es,
            R.drawable.flag_fr,R.drawable.flag_ir,R.drawable.flag_it,R.drawable.flag_jp,R.drawable.flag_kr,R.drawable.flag_pl,
            R.drawable.flag_pt,R.drawable.flag_tr};
    String[] countryNames;
    Spinner customSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        //initial spinner
        initialsimplespinner();
        initcustomspinner();
    }
    private void initialsimplespinner() {
        SimpleSpinner =findViewById(R.id.simple_spinner);
        SimpleItems=getResources().getStringArray(R.array.Tour_items);
        //adapter
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,SimpleItems);
        //connect adapter
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SimpleSpinner.setAdapter(adapter);
        SimpleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(SpinnerActivity.this,
                        adapterView.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    private void initcustomspinner() {
        customSpinner=findViewById(R.id.custom_spinner);
       // countryFlag=getResources().getIntArray(R.array.country_flag);
        countryFlag=countryFlag;
        countryNames=getResources().getStringArray(R.array.country_name);
        CountrySpinnerAdapter adapter=new CountrySpinnerAdapter(this,countryFlag,countryNames);
        customSpinner.setAdapter(adapter);
        customSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(SpinnerActivity.this, adapterView.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

}