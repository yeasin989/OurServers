package com.test.testproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.facebook.ads.Ads;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Your Api Add here
        Ads.getAll(this, "asfhaskjfhkasdfhkajsfhkasjhf", new Ads.ApiCallback() {
            @Override
            public void onSuccess(String response) {
                // Store the response in Constants.SERVERS
                String servers = response;
                Toast.makeText(MainActivity.this,"Servers Response",Toast.LENGTH_LONG).show();
            }
            @Override
            public void onError(String error) {
                Toast.makeText(MainActivity.this, "Expire Servers", Toast.LENGTH_SHORT).show();
            }
        });



    }
}