package com.example.joaovitor.contactlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by joaovitor on 01/09/17.
 */

public class ContactListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.fab)
    void addNewContact(){
        Intent addNewContact = new Intent(ContactListActivity.this, ContactFormActivity.class);
        startActivity(addNewContact);
    }

}
