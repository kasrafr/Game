package com.example.game;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

public class ColoredToast {
    private static final int RED=0xffff3333;
    private static final int GREEN=0xff00FF5F ;
    private static final int BLUE=0xff0500FF ;
    private static final int ORANGE=0xffff9E00 ;

    private static final int IC_ALERT=R.drawable.ac_alert;
    private static final int IC_WARNING=R.drawable.ac_warning;
    private static final int IC_INFO=R.drawable.ac_info;
    private static final int IC_SUCCESS=R.drawable.ac_sucess;
    public static class Duration{
        public static final int SHORT=0;
        public static final int LONG=1;
    }
    private Context context;
    private Toast toast;
    private View view;

    ColoredToast(Context context){
        this.context=context;
        this.toast=new Toast(context);
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ConstraintLayout test = null;
        this.view= inflater.inflate(R.layout.colored_toast_layout,null);
        toast.setView(view);
    }
    public View getView()
    {return view;}
    public void setText(String text){
        if (view==null) return;
        ((TextView)view.findViewById(R.id.toast_msg)).setText(text);
    }
    private static View getToastView(Toast toast)
    {
        return (toast==null)? null:toast.getView();

    }
    public void setIcon(int iconResId)
    {
        if (view==null) return;
        ((ImageView)view.findViewById(R.id.toast_icn)).setImageResource(iconResId);
    }
    public  Toast getToast()
    {
        return toast;
    }
    private static Toast colorToast(Toast toast,int colorId)
    {
        View layout=getToastView(toast);
        if(layout!=null)
        {
            layout.setBackgroundColor(colorId);
        }
        return toast;
    }
    public static Toast alert(Context context,String text,int duration)
    {
        ColoredToast coloredToast=new ColoredToast(context);
        coloredToast.setText(text);
        coloredToast.setIcon(IC_ALERT);
        coloredToast.getView().setBackgroundColor(RED);
        coloredToast.getToast().setDuration(duration);
        coloredToast.getToast().setGravity(Gravity.CENTER | Gravity.BOTTOM,0,0);
        return coloredToast.getToast();
    }
    public static Toast info(Context context,String text,int duration)
    {
        ColoredToast coloredToast=new ColoredToast(context);
        coloredToast.setText(text);
        coloredToast.setIcon(IC_INFO);
        coloredToast.getView().setBackgroundColor(BLUE);
        coloredToast.getToast().setDuration(duration);
        coloredToast.getToast().setGravity(Gravity.CENTER | Gravity.BOTTOM,0,0);
        return coloredToast.getToast();
    }
    public static Toast warning(Context context, String text, int duration)
    {
        ColoredToast coloredToast=new ColoredToast(context);
        coloredToast.setText(text);
        coloredToast.setIcon(IC_WARNING);
        coloredToast.getView().setBackgroundColor(ORANGE);
        coloredToast.getToast().setDuration(duration);
        coloredToast.getToast().setGravity(Gravity.CENTER | Gravity.BOTTOM,0,0);
        return coloredToast.getToast();
    }
    public static Toast success(Context context,String text,int duration)
    {
        ColoredToast coloredToast=new ColoredToast(context);
        coloredToast.setText(text);
        coloredToast.setIcon(IC_SUCCESS);
        coloredToast.getView().setBackgroundColor(GREEN);
        coloredToast.getToast().setDuration(duration);
        coloredToast.getToast().setGravity(Gravity.CENTER | Gravity.BOTTOM,0,0);
        return coloredToast.getToast();
    }
    public static Toast testImageToast(Context context,int ImgResource,int Duration){
        Toast toast=new Toast(context);
        LinearLayout layout=new LinearLayout(context);
        ImageView iv=new ImageView(context);
        layout.addView(iv);
        toast.setGravity(Gravity.CENTER,0,0);
        iv.setScaleType(ImageView.ScaleType.FIT_XY);
        layout.setLayoutParams(new LinearLayout.LayoutParams(100,100));
        iv.requestLayout();
        iv.setLayoutParams(layout.getLayoutParams());
        toast.setView(layout);
        iv.setImageResource(ImgResource);
        toast.setDuration(Duration);
        return toast;
    }
    public static Toast success(Toast toast)
    {
        return colorToast(toast,GREEN);
    }
    public static Toast info(Toast toast)
    {
        return colorToast(toast,BLUE);
    }
    public static Toast warning(Toast toast)
    {
        return colorToast(toast,ORANGE);
    }
}
