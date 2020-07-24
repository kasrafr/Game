package com.example.game;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class CountrySpinnerAdapter extends BaseAdapter
{
    private Context context;
    private int[] flags;
    private String[] names;
    private LayoutInflater inflater;
    public CountrySpinnerAdapter(Context context, int[] countryFlagId, String[] countryNames){
        this.context=context;
        this.flags=countryFlagId;
        this.names=countryNames;
        inflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return flags.length;
    }

    @Override
    public Object getItem(int i) {
        return names[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;
        if (convertView==null)
        {
            convertView=inflater.inflate(R.layout.custom_spinner_itme,viewGroup,false);
            holder=new ViewHolder();
            holder.country_flag=convertView.findViewById(R.id.country_flag);
            holder.country_name=convertView.findViewById(R.id.country_name);
            //convert viewholder to convertview
            convertView.setTag(holder);
        }
        else
        {
            holder= (ViewHolder) convertView.getTag();
        }
        holder.fill(position);
        return convertView;
    }
    public  class ViewHolder {
       public ImageView country_flag;
        public TextView country_name;
        public void fill(int position){
            country_flag.setImageResource(flags[position]);
            country_name.setText(names[position]);
        }
    }
}
