package com.example.itube;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.itube.databinding.ActivitySignUpBinding;

public class SignUP extends AppCompatActivity {

    ActivitySignUpBinding binding;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        binding=ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper=new DatabaseHelper(this);

        binding.createaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db=databaseHelper.getWritableDatabase();
                ContentValues contentValues=new ContentValues();


                if((binding.Password.getText().toString()).equals(binding.confirmpassword.getText().toString()))
                {
                    contentValues.put("Name",binding.fullname.getText().toString());
                    contentValues.put("UserName",binding.userName.getText().toString());
                    contentValues.put("Password",binding.Password.getText().toString());
                    contentValues.put("Confirm_Password",binding.confirmpassword.getText().toString());
                    db.insert("userdetail",null,contentValues);

                    Intent intent=new Intent(SignUP.this,MainActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(SignUP.this, "Passwords doesnt match!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}