package com.example.itube;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    EditText UserName,Password;

    Button Login,Signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserName=findViewById(R.id.username);
        Password=findViewById(R.id.password);
        Login=findViewById(R.id.login);
        Signup=findViewById(R.id.signup);

        databaseHelper=new DatabaseHelper(this);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user=UserName.getText().toString();
                String pass=Password.getText().toString();

                if (user.equals("") || pass.equals(""))
                {
                    Toast.makeText(MainActivity.this, "Please enter username and password", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean checkUserNamePassword=databaseHelper.checkuserpass(user,pass);
                    if(checkUserNamePassword==true)
                    {
                        Toast.makeText(MainActivity.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
                        Intent NextIntent=new Intent(MainActivity.this,Home.class);
                        startActivity(NextIntent);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SignUP.class);
                startActivity(intent);
            }
        });

    }

}