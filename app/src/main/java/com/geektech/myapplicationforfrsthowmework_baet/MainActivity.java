package com.geektech.myapplicationforfrsthowmework_baet;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

   /* private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    //"(?=.*[0-9])" +
                    //"(?=.*[a-z])" +
                    //"(?=.*[A-Z])" +
                    "(?=.\\S+$)" +
                    ".{6,}");*/

    private TextView textView;
    private EditText login;
    private EditText password;
    private Button signInBttn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = findViewById(R.id.edText_login);
        password = findViewById(R.id.edit_text_password);
        signInBttn = findViewById(R.id.bttn_sign_in);
        textView = findViewById(R.id.noify_error_txt);

        password.setFilters(new InputFilter[]{
                new InputFilter.LengthFilter(21)
        });


        signInBttn.setOnClickListener(v -> {
            if (v.getId() == R.id.bttn_sign_in) {
                String loginString = login.getText().toString().trim();
                String passwordString = password.getText().toString().trim();

                boolean boolCheckInputTxt = false;

                if (TextUtils.isEmpty(loginString)) {
                    login.setError("Enter your login here");
                    boolCheckInputTxt = true;
                }
                if (TextUtils.isEmpty(passwordString)) {
                    //password.setError("Please enter your password here");
                    boolCheckInputTxt = true;
                }

                if (boolCheckInputTxt) {
                    String stringBuilder = "Please enter your login and password!";
                    textView.setText(stringBuilder);
                }

                if (!boolCheckInputTxt) {
                    String stringBuilder2 = "Successfully!";
                    textView.setText(stringBuilder2);
                    textView.setTextColor(0xFF03DAC5);
                    Toast.makeText(this, "Signing in...",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}