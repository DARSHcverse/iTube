package com.example.itube;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.itube.databinding.ActivityHomeBinding;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    ActivityHomeBinding binding;

    ArrayList<String> Link;
//    EditText Url;
//    Button Play,My_PlayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        Url=findViewById(R.id.getURL);
//        Play=findViewById(R.id.playbutton);
//        AddPlayList=findViewById(R.id.addplaylist);
//        My_PlayList=findViewById(R.id.myplaylist);

        Link =new ArrayList<>();

        binding= ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper=new DatabaseHelper(this);

        binding.playbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this,WebviewAct.class);
                intent.putExtra("URLID",binding.getURL.getText().toString());
                startActivity(intent);

            }
        });

        binding.addplaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db=databaseHelper.getWritableDatabase();
                ContentValues contentValues=new ContentValues();
                contentValues.put("URL",binding.getURL.getText().toString());
                db.insert("YoutubeURL",null,contentValues);
                Toast.makeText(Home.this, "Added to PlayList", Toast.LENGTH_SHORT).show();
            }
        });

        binding.myplaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sentTOMyPlayList=new Intent(Home.this,MyPlayList.class);
                sentTOMyPlayList.putExtra("links", Link);
                startActivity(sentTOMyPlayList);

            }
        });

        ShowData();

    }
    private void ShowData() {
        Cursor cursor=databaseHelper.getdata();

        while(cursor.moveToNext())
        {
            Link.add(cursor.getString(1));
        }


    }
}