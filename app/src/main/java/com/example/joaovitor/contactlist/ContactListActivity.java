package com.example.joaovitor.contactlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.joaovitor.contactlist.model.Contact;
import com.example.joaovitor.contactlist.model.Gender;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by joaovitor on 01/09/17.
 */

public class ContactListActivity extends AppCompatActivity {

    private static final int ADD_NEW_CONTACT = 1;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<Contact> contacts;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        ButterKnife.bind(this);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        contacts = new ArrayList<>();

        adapter = new ContactAdapter(contacts, this);
        recyclerView.setAdapter(adapter);
    }

    @OnClick(R.id.fab)
    void addNewContact(){
        Intent addNewContact = new Intent(ContactListActivity.this, ContactFormActivity.class);
        startActivityForResult(addNewContact, ADD_NEW_CONTACT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == ADD_NEW_CONTACT && resultCode == RESULT_OK){
            int adapterSize = adapter.getItemCount();
            contacts.add((Contact) data.getExtras().get(getString(R.string.NEW_CONTACT)));
            Toast.makeText(this, "Contato salvo com sucesso", Toast.LENGTH_SHORT).show();
            adapter.notifyItemInserted(adapterSize);
        }
    }


}
