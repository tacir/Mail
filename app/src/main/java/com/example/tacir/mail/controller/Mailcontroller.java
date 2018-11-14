package com.example.tacir.mail.controller;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tacir.mail.MailActivity;
import com.example.tacir.mail.R;
import com.example.tacir.mail.model.Mail;
import com.example.tacir.mail.util.Constants;

import java.util.List;

public class Mailcontroller extends RecyclerView.Adapter {
    private List<Mail> mails;
    private Context context;

    public Mailcontroller(List<Mail> mails, Context context) {
        this.mails = mails;
        this.context = context;
    }

    public int getItemCount() {
        if (mails == null)
            return 0;
        return mails.size();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int resourceId) {


        LayoutInflater layoutInflater = LayoutInflater.from(context);


        View view = layoutInflater.inflate(resourceId, viewGroup, false);


        return new MailView(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        final Mail currentMail = mails.get(position);
        MailView mailView = (MailView) viewHolder;


        mailView.text1.setText(currentMail.getName());
        mailView.text2.setText(currentMail.getSubject());
        mailView.text3.setText(currentMail.getMessage());
        mailView.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MailActivity.class);
                intent.putExtra(Constants.SUBJECT_MAIL, currentMail.getSubject());
                intent.putExtra(Constants.MESSAGE_MAIL, currentMail.getMessage());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        Mail mail = mails.get(position);
        if (mail.fromMe())
            return R.layout.message_left;
        else
            return R.layout.message_right;
    }

    class MailView extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView text1;
        TextView text2;
        TextView text3;

        public MailView(@NonNull View inflaterinYaratdigiKokView) {
            super(inflaterinYaratdigiKokView);
            text1 = inflaterinYaratdigiKokView.findViewById(R.id.text1);
            text2 = inflaterinYaratdigiKokView.findViewById(R.id.text2);
            text3 = inflaterinYaratdigiKokView.findViewById(R.id.text3);
            imageView = inflaterinYaratdigiKokView.findViewById(R.id.imageview_icon);
        }
    }
}