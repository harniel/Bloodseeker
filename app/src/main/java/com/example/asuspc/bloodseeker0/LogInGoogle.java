package com.example.asuspc.bloodseeker0;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LogInGoogle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_google);

        Button deny = (Button) findViewById(R.id.denyGoogle);
        deny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LogInGoogle.this, MainActivity.class));
            }
        });

        Button accept = (Button) findViewById(R.id.buttonAllow);
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LogInGoogle.this, Home2.class));
            }
        });
    }
}
