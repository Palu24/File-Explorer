package com.android.palak.feapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

;import java.io.File;

public class NextActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView listView;
    Intent rcv;
    File file,files[];

    String title,sdcardpath,nameoffile;
    ArrayAdapter adapter;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        listView = findViewById(R.id.nextlistview);
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1);

        rcv = getIntent();
        title = rcv.getStringExtra("Title");
        getSupportActionBar().setTitle(title);
        sdcardpath = rcv.getStringExtra("SDCard");
        file = new File(sdcardpath);

        files = file.listFiles();
        initViews(files);
    }

    void initViews(File[] files){



        try
        {


            switch (title)
            {
                case "Pictures":

                    for (File filename : files)
                    {

                        if(filename.isDirectory()){
                           File[] file = filename.listFiles();
                         initViews(file);

                        }
                        else {
                            if (filename.getPath().endsWith(".jpg") || filename.getPath().endsWith(".png") || filename.getPath().endsWith(".jpeg") || filename.getPath().endsWith(".gif")) {
                                adapter.add(filename.getName());
                                count++;
                            }
                        }
                    }


                    break;

                case "Music":

                     for (File filename : files)
                    {

                        if(filename.isDirectory()){
                           File[] file = filename.listFiles();
                         initViews(file);

                        }
                        else {
                            if (filename.getPath().endsWith(".mp3") || filename.getPath().endsWith(".oga") || filename.getPath().endsWith(".aac")) {
                                adapter.add(filename.getName());
                                count++;
                            }
                        }
                    }


                    break;

                case "Videos":

                     for (File filename : files)
                    {

                        if(filename.isDirectory()){
                           File[] file = filename.listFiles();
                         initViews(file);

                        }
                        else {
                            if (filename.getPath().endsWith(".mpeg") || filename.getPath().endsWith(".mp4") || filename.getPath().endsWith(".ogg") || filename.getPath().endsWith(".webm")) {
                                adapter.add(filename.getName());
                                count++;
                            }
                        }
                    }


                    break;

                case "Documents":

                    for (File filename : files)
                    {

                        if(filename.isDirectory()){
                            File[] file = filename.listFiles();
                            initViews(file);

                        }
                        else {
                            if (filename.getPath().endsWith(".pdf") || filename.getPath().endsWith(".doc")|| filename.getPath().endsWith(".txt") || filename.getPath().endsWith(".html") || filename.getPath().endsWith(".docx")) {
                                adapter.add(filename.getName());
                                count++;
                            }
                        }
                    }

                    break;

                case "APKs":

                    for (File filename : files)
                    {

                        if(filename.isDirectory()){
                            File[] file = filename.listFiles();
                            initViews(file);

                        }
                        else {
                            if (filename.getPath().endsWith(".apk")) {
                                adapter.add(filename.getName());
                                count++;
                            }
                        }
                    }

                    break;

                case "ZIP":

                    for (File filename : files)
                    {

                        if(filename.isDirectory()){
                            File[] file = filename.listFiles();
                            initViews(file);

                        }
                        else {
                            if (filename.getPath().endsWith(".zip") || filename.getPath().endsWith(".tar")) {
                                adapter.add(filename.getName());
                                count++;
                            }
                        }
                    }
                    break;

            }

            listView.setAdapter(adapter);
            listView.setOnItemClickListener(this);

        }
        catch (Exception e)
        {
            Toast.makeText(this,"Please enable Storage Settings to this Application",Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
    {
        nameoffile = (String) adapter.getItem(i);
        Toast.makeText(this,nameoffile,Toast.LENGTH_SHORT).show();
    }
}
