package com.example.joaovitor.contactlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.joaovitor.contactlist.model.Contact;
import com.example.joaovitor.contactlist.model.Gender;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by joaovitor on 01/09/17.
 */

public class ContactFormActivity extends AppCompatActivity {

    @Bind(R.id.name_field)
    EditText contactName;

    @Bind(R.id.phone_field)
    EditText contactPhone;

    @Bind(R.id.genders_spinner)
    Spinner contactGender;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_form);
        ButterKnife.bind(this);
        Spinner spinner = (Spinner) findViewById(R.id.genders_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.genders_spinner, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }


    @OnClick(R.id.save_button)
    void saveContact() {
        Contact contact = new Contact();
        contact.setName(contactName.getText().toString());
        contact.setPhone(contactPhone.getText().toString());
        contact.setGender(contactGender.getSelectedItemPosition() == 0 ? Gender.Male : Gender.Female);

        if (contact.isValid()) {
            Intent sendNewContactIntent = getIntent();
            sendNewContactIntent.putExtra(getString(R.string.NEW_CONTACT), contact);
            setResult(RESULT_OK, sendNewContactIntent);
            finish();
        } else {
            if (!contact.isNameValid()) {
                contactName.setError(getString(R.string.invalid_field));
            } else {
                contactName.setError(null);
            }
            if(!contact.isPhoneValid()){
                contactPhone.setError(getString(R.string.invalid_field));
            }else {
                contactPhone.setError(null);
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }
        return super.onOptionsItemSelected(item);
    }
}
