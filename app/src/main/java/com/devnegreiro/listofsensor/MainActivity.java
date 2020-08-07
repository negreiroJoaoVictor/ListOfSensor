package com.devnegreiro.listofsensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //Variables
    ListView ListView_listSensor;
    private SensorManager mSensorManager;
    ArrayList<String> list_sensor_string = new ArrayList<String>(); //Creating a String arrayList to save sensor info.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView_listSensor = findViewById(R.id.ListView_listSensor); //Associating ListView


        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);    //Instance of the object of SensorManager Class
        List<Sensor> mList_sensor = mSensorManager.getSensorList(Sensor.TYPE_ALL); //calling the GetSensorList method

        for (Sensor sensor : mList_sensor //foreach that iterate the list to get the information
        ) {
            String info = "\n Nome: " +  sensor.getName() + "; Vendor: " + sensor.getVendor() + "; Version: " + sensor.getVersion();
            list_sensor_string.add(info);
        }

        //Using a basic ArrayAdapter to set the Sensor's list at ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list_sensor_string);
        ListView_listSensor.setAdapter(adapter);


    }



}