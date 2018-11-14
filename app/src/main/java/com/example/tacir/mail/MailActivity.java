package com.example.tacir.mail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.tacir.mail.util.Constants;

public class MailActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail);

        Intent intent = getIntent();

        String subject = intent.getStringExtra(Constants.SUBJECT_MAIL);
        String message = intent.getStringExtra(Constants.MESSAGE_MAIL);

        TextView textView = findViewById(R.id.textview_mail);
        TextView textView1 = findViewById(R.id.textview_message);

        textView.setText(subject);
        textView1.setText(message);
    }
}
