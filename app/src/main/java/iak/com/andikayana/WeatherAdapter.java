package iak.com.andikayana;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by M13x5aY on 13/05/2017.
 */

public class WeatherAdapter extends ArrayAdapter<Weather> {

    Context context;
    int layoutResourceId;
    ArrayList<Weather> data=null;


    public WeatherAdapter(Context context,
                         int resource,
                         ArrayList<Weather> objects) {
        super(context, resource, objects);
        this.context=context;
        this.layoutResourceId=resource;
        this.data = objects;
    }

    @NonNull
    @Override
    public View getView(int position,
                        View convertView,
                        ViewGroup parent) {

        View row = convertView;
        Weatherholder holder = null;

        if (row == null){
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row= inflater.inflate(layoutResourceId,parent,false);

            holder=new Weatherholder();
            holder.img=(ImageView) row.findViewById(R.id.imgicon);
            holder.title=(TextView) row.findViewById(R.id.txtTitle);
            holder.subitem=(TextView) row.findViewById(R.id.subitem);

            row.setTag(holder);
        } else {
            holder=(Weatherholder)row.getTag();
        }

        Weather weather = data.get(position);
        holder.img.setImageResource(weather.icon);
        holder.title.setText(weather.title);
        holder.subitem.setText(weather.item);


        return row;
    }

    static class Weatherholder{
        ImageView img;
        TextView title;
        TextView subitem;
    }
}




