package com.example.game;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.List;

class ContactAdapter extends ArrayAdapter {
    private List<MyContact> contacts;
    public ContactAdapter(@NonNull Context context, @NonNull List<MyContact> contacts) {

        super(context, R.layout.mycontact_list_item, contacts);
        this.contacts=contacts;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //convertView-> dar in parametr view haye recyclbin shode dar zaman scrol negah dashte shode ast
        MyContact contact = contacts.get(position);
        ViewHolder holder;
        if (convertView==null)
        {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.mycontact_list_item,parent,false);
            holder=new ViewHolder();
            holder.img_profile=convertView.findViewById(R.id.mycontact_pimg);
            holder.tv_phone=convertView.findViewById(R.id.mycontact_phone);
            holder.tv_name=convertView.findViewById(R.id.mycontact_name);
            holder.ic_sms=convertView.findViewById(R.id.mycontact_ic_sms);
            holder.ic_call=convertView.findViewById(R.id.mycontact_ic_call);
            convertView.setTag(holder);
        } else
        {
            holder= (ViewHolder) convertView.getTag();
        }
            holder.fill(contact);
        //az chizi ke jensesh java nist view java tahvil mide
/*
        View view = inflater.inflate(R.layout.mycontact_list_item, parent, false);
*/
        /*ImageView img_profile = view.findViewById(R.id.mycontact_pimg);
        TextView tv_name = view.findViewById(R.id.mycontact_name);
        TextView tv_phone = view.findViewById(R.id.mycontact_phone);
        if (contact.getId() != 0) {
            img_profile.setImageResource(contact.getId());
        }
        tv_name.setText(contact.getName());
        tv_phone.setText(contact.getPhoneNumber());*/
        //return view;
        return convertView;
    }
    private class ViewHolder implements View.OnClickListener {
        public ImageView img_profile;
        public TextView tv_name;
        public TextView tv_phone;
        public ImageView ic_sms;
        public ImageView ic_call;
        public void fill(MyContact contact)
        {
            img_profile.setImageResource(contact.getId());
            tv_name.setText(contact.getName());
            tv_phone.setText(contact.getPhoneNumber());
            ic_sms.setTag(contact.getPhoneNumber());
            ic_call.setTag(contact.getPhoneNumber());
            ic_sms.setOnClickListener(this);
            ic_call.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            String phone= (String) view.getTag();
            Intent intent=new Intent(Intent.ACTION_VIEW);
            if(view.equals(ic_call))
            {
                intent.setData(Uri.parse("tel:"+phone));
                getContext().startActivity(intent);
            }
            else if(view.equals(ic_sms))
            {
                intent.setData(Uri.parse("sms:"+phone));
                getContext().startActivity(intent);
            }
        }
    }
}
