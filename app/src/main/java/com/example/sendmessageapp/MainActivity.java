package com.example.sendmessageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText subject;
    private EditText message;
    private Button send;
    String subject_to_send;
    String message_to_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        subject = findViewById(R.id.editTextSubject);
        message = findViewById(R.id.editTextMessage);
        send = findViewById(R.id.button);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subject_to_send = subject.getText().toString();
                message_to_send = message.getText().toString();

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, message_to_send);
                intent.putExtra(Intent.EXTRA_SUBJECT,subject_to_send);
                startActivity(intent);

            }
        });
    }
}