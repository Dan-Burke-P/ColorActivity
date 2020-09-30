package edu.temple.coloractivity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    ColorObject[] colors = {
            new ColorObject("red", Color.RED),
            new ColorObject("blue", Color.BLUE),
            new ColorObject("green", Color.GREEN),
            new ColorObject("black", Color.BLACK),
            new ColorObject("cyan", Color.CYAN),
            new ColorObject("gray", Color.GRAY),
            new ColorObject("yellow", Color.YELLOW),
            new ColorObject("light gray", Color.LTGRAY),
            new ColorObject("magenta", Color.MAGENTA),
            new ColorObject("dark gray", Color.DKGRAY)
    };
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ColorAdapter colorAdapter = new ColorAdapter(colors, getApplicationContext());
        spinner = (Spinner)findViewById(R.id.spinner);
        spinner.setAdapter(colorAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                view.setBackgroundColor(Color.WHITE);
                for (int j = 0; j < parent.getAdapter().getCount(); j++){
                    ColorObject tco = ((ColorObject)parent.getAdapter().getItem(j));
                    tco.isSelected = false;
                }
                ColorObject co = (ColorObject)parent.getAdapter().getItem(position);
                co.isSelected = true;
                findViewById(R.id.mainLayout).setBackgroundColor(co.color);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}