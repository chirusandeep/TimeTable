package com.example.chirusandeep.timetable;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button serviceButton = findViewById(R.id.service_button);
        Button startServiceButton = findViewById(R.id.notification_service);

        serviceButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("BUTTON_CLICK", "Starting activity");
                Intent intent = new Intent(MainActivity.this, HelloWorldActivity.class);
                intent.putExtra("userName", "Sundeep");
                startActivity(intent);
            }
        });

        startServiceButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.i("BUTTON_CLICK", "Starting service");
//                Intent intent = new Intent(MainActivity.this, NotifyService.class);
//                startService(intent);
                if (Util.isOreo()) {
                    NotificationHelper nh = new NotificationHelper(MainActivity.this);
                    nh.notify(1, nh.getNotification1("Hello", "This should work!"));
                }
            }
        });
    }

    public Integer randomNumber() {
        return 1;
    }
}
