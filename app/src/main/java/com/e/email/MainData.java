package com.e.email;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainData extends AppCompatActivity {
    EditText Myname;
    Button button;
    Spinner spin;

    DatabaseReference databaseSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_data);

        Myname = (EditText)findViewById(R.id.editTextname);
        button = (Button)findViewById(R.id.buttonDB);
        spin = (Spinner)findViewById(R.id.spinnertype);

        databaseSignup = FirebaseDatabase.getInstance().getReference("Users");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usertype();
            }
        });

    }

    private void usertype(){
        String nametp = Myname.getText().toString().trim();
        String tp = spin.getSelectedItem().toString().trim();

        if(!TextUtils.isEmpty(nametp)){

            String id = databaseSignup.push().getKey();
            FData fData = new FData(id, nametp, tp);
            databaseSignup.child(id).setValue(fData);
            Toast.makeText(this, "Data added", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "Enter name", Toast.LENGTH_LONG).show();
        }
    }

    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        finish();
        Toast.makeText(getApplicationContext(), "Logout Successful", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, MainActivity.class));
    }
}
