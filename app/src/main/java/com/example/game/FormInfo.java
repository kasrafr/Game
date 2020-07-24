package com.example.game;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.view.View;
import android.widget.Toast;


public class FormInfo implements  CompoundButton.OnCheckedChangeListener {
    //View.OnClickListener,
    private Activity activity;
    private LinearLayout Layoutforminfo;
    private EditText input_name;
    private EditText input_phone;
    private EditText input_email;
    private CheckBox cbshare_phone;
    private Button btnsubmit;
    private Context context;

    //constructing
    public FormInfo(Activity activity,int layout_id)
    {
        this.activity=activity;
        Layoutforminfo=activity.findViewById(layout_id);
        context=activity.getApplicationContext();
        if (Layoutforminfo==null) return;
        init();
    }
    private void init() {
        input_name=Layoutforminfo.findViewById(R.id.input_name);
        input_email=Layoutforminfo.findViewById(R.id.input_email);
        input_phone =Layoutforminfo.findViewById(R.id.input_phone);
        cbshare_phone=Layoutforminfo.findViewById(R.id.cb_share_phone);
        btnsubmit=Layoutforminfo.findViewById(R.id.btn_submit);
        //btnsubmit.setOnClickListener(this);
        cbshare_phone.setOnCheckedChangeListener(this);
    }

    public EditText getInput_name() {
        return input_name;
    }

    public EditText getInput_phone() {
        return input_phone;
    }

    public EditText getInput_email() {
        return input_email;
    }

    public CheckBox getCbshare_phone() {
        return cbshare_phone;
    }

    public Button getBtnsubmit() {
        return btnsubmit;
    }


    //@Override
/*    public void onClick(View v) {
     if(v.getId()==btnsubmit.getId())
     {
         String Email=input_email.getText().toString().trim();
         String Phone=input_phone.getText().toString().trim();
         String Name=input_name.getText().toString().trim();
         if (isvalidinput(Name,Phone,Email)) {
             Intent intent = new Intent(activity, SecondActivity.class);
             intent.putExtra("Name", Name);
             if (cbshare_phone.isChecked())
             {
                 intent.putExtra("Phone", Phone);
             }
             intent.putExtra("Email",Email);
             activity.startActivity(intent);
             Toast.makeText(activity, "Valid input.", Toast.LENGTH_LONG).show();

         }
     }
    }
    */

    public boolean isvalidinput(String name, String phone, String email) {
        if (name==null)
        {
            name=input_name.getText().toString().trim();
        }
        if(phone==null)
        {
            phone=input_phone.getText().toString().trim();
        }
        if(email==null)
        {
            email=input_email.getText().toString().trim();
        }
        if(name.length()<3) {
            Toast.makeText(activity, "Name Should Be at least 3 character", Toast.LENGTH_LONG).show();
            input_name.requestFocus();
            return false;
        }
        if (!phone.isEmpty()&& phone.length()!=11 || !phone.startsWith("09"))
        {
            Toast.makeText(activity, "Wrong Phone number", Toast.LENGTH_LONG).show();
            input_phone.requestFocus();
            return  false;
        }
        if(email.lastIndexOf('@')<=0 || !email.contains(".") || email.lastIndexOf('.') < email.lastIndexOf('@') || email.split("@").length>2)
        {
            Toast.makeText(activity, "Wrong Email Address", Toast.LENGTH_LONG).show();
            input_email.requestFocus();
            return  false;

        }
        return  true;
    }
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if(buttonView.getId()==cbshare_phone.getId())
        {
            input_phone.setEnabled(isChecked);
        }
    }

}
