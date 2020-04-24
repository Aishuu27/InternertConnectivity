package com.example.internertconnectivity;

import android.app.IntentService;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.util.Pools;

public class MyService extends IntentService {

    public static final String MESSAGE ="message" ;


    public MyService() {
        super("MYService");
    }


    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        synchronized (this){
            try{
                wait(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        String txt=intent.getStringExtra(MESSAGE);
        showText(txt);
        if(connected()){
            Log.v("My Service"," connected");
        }
        else{
            Log.v("My Service","Not connected");

        }
    }
    private void showText(final String text){
        Log.v("My Service",text);
    }
    private boolean connected(){
        boolean have_WIFI=false;
        boolean have_MobileData=false;
        ConnectivityManager conn=(ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] networkInfo=conn.getAllNetworkInfo();
        for(NetworkInfo info:networkInfo){
            if(info.getTypeName().equalsIgnoreCase("WIFI")){
                if(info.isConnected())
                    have_WIFI=true;
            }
            if(info.getTypeName().equalsIgnoreCase("MOBILE")){
                if(info.isConnected())
                    have_MobileData=true;

            }
        }
        return have_MobileData|| have_WIFI ;
    }
}
