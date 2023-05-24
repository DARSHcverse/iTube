package com.example.itube;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MyPlayList extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_play_list);

        textView=findViewById(R.id.textselection);

        Intent getintent=getIntent();
        ArrayList<String> URI_LINKS=getintent.getStringArrayListExtra("links");

        StringBuilder stringBuilder=new StringBuilder();

        for(String item:URI_LINKS)
        {
            stringBuilder.append(item).append("\n\n");
        }
        textView.setText(stringBuilder.toString());


    }
}