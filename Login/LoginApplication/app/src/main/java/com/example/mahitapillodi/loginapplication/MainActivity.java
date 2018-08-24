package com.example.mahitapillodi.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.*;

import java.lang.*;

public class MainActivity extends AppCompatActivity {
    EditText username,password;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=(EditText)findViewById(R.id.editTextun);
        password=(EditText)findViewById(R.id.editTextpwd);
        btn=(Button)findViewById(R.id.buttonlogin);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }
    private void login()
    {
        if(TextUtils.isEmpty(username.getText().toString().trim())||TextUtils.isEmpty(password.getText().toString().trim())){
            username.setError("Fields can't be empty");
            password.setError("Fields can't be empty");
        }
        else if(!emailValidator(username.getText().toString())) {
            username.setError("Please enter valid email address");
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Login Successful", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(MainActivity.this,Main2Activity.class);
            startActivity(intent);
        }
    }
    public boolean emailValidator(String email)
    {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN="^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern=Pattern.compile(EMAIL_PATTERN);
        matcher=pattern.matcher(email);
        return matcher.matches();
    }
}
