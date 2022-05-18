package com.example.mybbs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mybbs.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {

    private ActivityRegisterBinding binding;
    //private final String id_num = null;
    //private final String password = null;
    private EditText id_num = null;
    private EditText user_name = null;
    private EditText password = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        id_num = binding.editTextTextEmailAddress;
        user_name = binding.editTextTextUserName;
        password = binding.editTextTextPassword;

        Intent intent = getIntent();
        String message = intent.getStringExtra("id_num");
        id_num.setText(message);
    }

    public void onClickRegister(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        String message = id_num.getText().toString();
        intent.putExtra("id_num",message );
        startActivity(intent);
    }

}