package com.example.timestable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {
    SeekBar seekBar;
    int currentProgress,max,min;
    ArrayList<Integer> mylist;
    ArrayAdapter<Integer> myadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = (SeekBar)findViewById(R.id.seekBar);
        currentProgress = 1;
        seekBar.setProgress(currentProgress);
        seekBar.setMax(20);
        final ListView listView = (ListView)findViewById(R.id.listView);
        mylist = new ArrayList<Integer>(asList(1,2,3,4,5,6,7,8,9,10));
        myadapter = new ArrayAdapter<Integer>(this,android.R.layout.simple_list_item_1,mylist);
        listView.setAdapter(myadapter);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                if(progress < min) {
                    seekBar.setProgress(1);
                }
                else {
                    mylist = multiplyEachElementByAValue(progress,mylist);
                }
                myadapter = new ArrayAdapter<Integer>(MainActivity.this,android.R.layout.simple_list_item_1,mylist);
                listView.setAdapter(myadapter);
                mylist = new ArrayList<Integer>(asList(1,2,3,4,5,6,7,8,9,10));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    ArrayList<Integer> multiplyEachElementByAValue(int value,ArrayList<Integer> mylist) {

        for(int i = 0;i < 10;i++) {
            mylist.set(i,mylist.get(i)*value);
        }
        return mylist;
    }
}
