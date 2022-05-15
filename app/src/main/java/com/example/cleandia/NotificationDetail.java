package com.example.cleandia;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NotificationDetail extends AppCompatActivity {

    Button registerBtn;
    TextView ngoName, eventName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_detail);
        registerBtn = findViewById(R.id.eventRegister);
        ngoName = findViewById(R.id.ngo_name);
        eventName = findViewById(R.id.event);

        if(getIntent().getIntExtra("type",0) == 1) {

            final String ngo_name = getIntent().getStringExtra("ngo name");
            final String event_name = getIntent().getStringExtra("event name");

            ngoName.setText(ngo_name);
            eventName.setText(event_name);
            registerBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(NotificationDetail.this, "You are Registered Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(NotificationDetail.this, Notification.class);
                    NotificationDetail.this.startActivity(intent);
                }
            });
        }
    }
}