package com.drivexindia.view;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;

import com.drivexindia.R;

public class LoginActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textView=findViewById(R.id.welcomeText);
        String text = "Welcome To \n DropEx";
        SpannableString ss = new SpannableString(text);
        StyleSpan boldSpan = new StyleSpan(Typeface.BOLD);
        ss.setSpan(boldSpan, 13, 19, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(ss);
    }
    public void loginClick(View view){
      startActivity(new Intent(this,MainActivity.class));
      finish();
    }
}
