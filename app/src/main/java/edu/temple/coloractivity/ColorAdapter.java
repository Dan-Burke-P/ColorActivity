package edu.temple.coloractivity;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ColorAdapter extends BaseAdapter {

    public ColorAdapter(ColorObject[] _colorObjects, Context _context){
        this.colorObjects = _colorObjects;
        this.context = _context;
        inflater = LayoutInflater.from(context);
    }

    ColorObject[] colorObjects;
    Context context;
    LayoutInflater inflater;

    @Override
    public int getCount() {
        return colorObjects.length;
    }

    @Override
    public Object getItem(int position) {
        return colorObjects[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.color_layout, null);
        TextView label = convertView.findViewById(R.id.colorLabel);
        ColorObject co = colorObjects[position];

        label.setText(co.name);
        if(co.isSelected){
            convertView.setBackgroundColor(Color.WHITE);
        }else{
            convertView.setBackgroundColor(co.color);
        }
        return convertView;
    }
}
