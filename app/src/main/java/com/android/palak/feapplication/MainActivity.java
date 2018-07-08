package com.android.palak.feapplication;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView listView;
    Intent intent;


    ArrayAdapter adapter;
    String option,sdcardpath;
    File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    void initViews(){

        listView = findViewById(R.id.mainlistview);
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1);
            adapter.add("Pictures");
            adapter.add("Music");
            adapter.add("Videos");
            adapter.add("Documents");
            adapter.add("APKs");
            adapter.add("ZIP");
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        //Read data from SD Card
        sdcardpath = Environment.getExternalStorageDirectory().getAbsolutePath();

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        option = (String) adapter.getItem(i);
        intent = new Intent(this,NextActivity.class);
        intent.putExtra("SDCard",sdcardpath);

        switch(option)
        {

            case "Pictures":
                intent.putExtra("Title","Pictures");
                break;
            case "Music":
                intent.putExtra("Title","Music");
                break;
            case "Videos":
                intent.putExtra("Title","Videos");
                break;
            case "Documents":
                intent.putExtra("Title","Documents");
                break;
            case "APKs":
                intent.putExtra("Title","APKs");
                break;
            case "ZIP":
                intent.putExtra("Title","ZIP");
                break;
        }

        startActivity(intent);

    }
}
