package com.devnegreiro.listofsensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView ListView_listSensor;
    private SensorManager mSensorManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView_listSensor = findViewById(R.id.ListView_listSensor);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> mList_sensor = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        ArrayList<String> lista = new ArrayList<String>();

        for (Sensor sensor : mList_sensor
        ) {
            String info = "\n Nome: " +  sensor.getName() + "; Vendor: " + sensor.getVendor() + "; Version: " + sensor.getVersion();
            lista.add(info);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,lista);
        ListView_listSensor.setAdapter(adapter);


    }



}