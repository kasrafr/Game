package com.example.game;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final int Req_code=12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Create Form class And Send All of Object on Main activity
        final FormInfo form=new FormInfo(this,R.id.layout_form_info);
        //change text color with set getter
        form.getInput_name().setTextColor(Color.rgb(255,0,0));
        //btn click whit set getter
        form.getBtnsubmit().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name=form.getInput_name().getText().toString().trim();
                String Phone=form.getInput_phone().getText().toString().trim();
                String Email=form.getInput_email().getText().toString().trim();
                if (form.isvalidinput(null,null,null))
                {
                    Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                    intent.putExtra("Name", Name);
                    if (form.getCbshare_phone().isChecked()) {
                        intent.putExtra("Phone", Phone);
                    }
                    intent.putExtra("Email", Email);
                    startActivityForResult(intent,Req_code);
                }
            }
        });

        //OnActivity Result for back request from other activity
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==Req_code && resultCode==RESULT_OK)
        {
            Toast.makeText(this, data.getStringExtra("message"), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //whith xml
        //getMenuInflater().inflate(R.menu.menu_main,menu);
        //add manual menu item
        SubMenu intentsubmenu=menu.addSubMenu("Intent Option");
        //add item for pen Browser
        intentsubmenu.add("OpenBrowser").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.google.com/"));
                startActivity(intent);
                return false;
            }
        });
        //add Confirm item to send Dara From Second activity to first Activity
        MenuItem item_ok=intentsubmenu.add("Confirm");
        //Always be open menu
        //itemok.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        item_ok.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent=new Intent();
                intent.putExtra("message","It's Ok");
                setResult(RESULT_OK,intent);
                finish();
                return false;
            }
        });
        //add item for send sms
        intentsubmenu.add("Open SmS").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("sms:09383959599"));
                intent.putExtra("sms_body","Hello From android app");
                startActivity(intent);

                return false;
            }
        });
        //open dialer
        MenuItem item_dialer=intentsubmenu.add("Open Dialer");
        item_dialer.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("tel:09383959599"));
                startActivity(intent);
                return false;
            }
        });

        SubMenu mediaSubmenu=menu.addSubMenu("Media");
        mediaSubmenu.add("ImageView").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                startActivity(new Intent(MainActivity.this,ImageViewActivity.class));
                return false;
            }
        });
        mediaSubmenu.add("Connect 3").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                startActivity(new Intent(MainActivity.this,connectThreeActivity.class));
                return false;
            }
        });
        mediaSubmenu.add("Video View").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                startActivity(new Intent(MainActivity.this,VideoViewActivity.class));
                return false;
            }
        });
        mediaSubmenu.add("AudioPlay").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                startActivity(new Intent(MainActivity.this,AudioActivity.class));
                return false;
            }
        });
        //dialog
        menu.add("Dialog").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                startActivity(new Intent(MainActivity.this,DialogActivity.class));
                return false;
            }
        });
       SubMenu listsubmenu= menu.addSubMenu("List View");
        listsubmenu.add("Simple List").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                startActivity(new Intent(MainActivity.this,SimpleListActivity.class));
                return false;
            }
        });
        listsubmenu.add("custom List").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                startActivity(new Intent(MainActivity.this,CustomListActivity.class));
                return false;
            }
        });
        menu.add("Toast").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                startActivity(new Intent(MainActivity.this,ToastActivity.class));
                return false;
            }
        });
        menu.add("RadioButton").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                startActivity(new Intent(MainActivity.this,RadioButtonActivity.class));
                return false;
            }
        });
        menu.add("RatingBar").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                startActivity(new Intent(MainActivity.this,RaitingBarActivity.class));
                return false;
            }
        });
        menu.add("Spinner").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                startActivity(new Intent(MainActivity.this,SpinnerActivity.class));
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
