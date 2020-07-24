package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ToastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
    }

    public void simpleToast(View v) {
        Toast.makeText(this, "simple Toast", Toast.LENGTH_LONG).show();
    }

    public void testColorForToast(View v) {
       Toast toast= Toast.makeText(this, "simple Toast", Toast.LENGTH_LONG);
       toast.getView().setBackgroundColor(0xfff44436);
       toast.show();
    }

    public void testColorForToast2(View v) {
        String tag= (String) v.getTag();
        switch (tag)
        {
            case "info":
                ColoredToast.info(this,"This is An info Toast",ColoredToast.Duration.LONG).show();
                break;
            case "success":
                ColoredToast.success(this,"This is An success Toast",Toast.LENGTH_SHORT).show();
                break;
            case "alert":
                ColoredToast.alert(this,"This is An Alert Toast",Toast.LENGTH_SHORT).show();
                break;
            case "Warning":
                ColoredToast.warning(this,"This is An Warning Toast",Toast.LENGTH_SHORT).show();
                break;
            default:break;
        }
    }

    public void ImageToast(View v) {
        ColoredToast.testImageToast(this,R.drawable.profile1,ColoredToast.Duration.LONG).show();
    }
}