package com.example.internertconnectivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;


public class MainActivity extends AppCompatActivity  {
    private TextView message ;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.check_button);
        b1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,MyService.class);
                i.putExtra(MyService.MESSAGE,"Button CLicked");
                startService(i);
            }
        });
    }

}
