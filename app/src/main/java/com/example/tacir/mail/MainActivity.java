package com.example.tacir.mail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.example.tacir.mail.controller.Mailcontroller;
import com.example.tacir.mail.model.Mail;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArrayList<Mail> mailList = new ArrayList<>();
        final Mail mail1 = new Mail("Elvin Abdullayev", "Heftesonu gezintisi", "Salam, heftesonu gedek puba.", false);
        Mail mail2 = new Mail("Sirac Suleymanov", "Ders cedveli", "Zehmet olmasa cedveli mene at.", false);
        Mail mail3 = new Mail("Kamal Seferelioyev", "Elave ders", "salam. Sabah elave ders olacaq.", true);
        Mail mail4 = new Mail("Murad Qehremanov", "Sohbet var", "Salam qardasim. 28 Mayda sohbetim dusub dur gel.", true);
        final Mail mail5 = new Mail("Seymur Abdullayev", "Futbol var bazar gunu", "Tacir, bazar gunu ZU-036 ile futbol olcaq", false);

        mailList.add(mail1);
        mailList.add(mail2);


        final Mailcontroller mailcontroller = new Mailcontroller(mailList, this);
        RecyclerView recyclerView = findViewById(R.id.recycler);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mailcontroller);


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                mailList.add(new Mail("Text", "Subject", "Message", random.nextBoolean()));
                mailcontroller.notifyDataSetChanged();
            }
        });

        makeRequstToGoogle();

    }

    private void makeRequstToGoogle(){
        URL url;
        HttpURLConnection urlConnection = null;
        try {
            url = new URL("http://www.google.com");

            urlConnection = (HttpURLConnection) url.openConnection();

            InputStream in = urlConnection.getInputStream();

            InputStreamReader isw = new InputStreamReader(in);

            int data = isw.read();
            while (data != -1) {
                char current = (char) data;
                data = isw.read();
                System.out.print(current);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
    }
}
