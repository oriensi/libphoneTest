package com.example.pasiel.libphone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.i18n.phonenumbers.PhoneNumberMatch;
import com.google.i18n.phonenumbers.PhoneNumberUtil;


public class MainActivity extends AppCompatActivity {
    private Button btn;
    private EditText edit;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn);
        edit = (EditText) findViewById(R.id.edit);
        text = (TextView) findViewById(R.id.text);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = edit.getText().toString();
                PhoneNumberUtil util = PhoneNumberUtil.getInstance();
                Iterable<PhoneNumberMatch> matches = util.findNumbers(s.toString(),
                        "CN", PhoneNumberUtil.Leniency.POSSIBLE, Long.MAX_VALUE);
                StringBuilder sb = new StringBuilder("autolink type phone. match:");
                for (PhoneNumberMatch match : matches) {
                    sb.append("\ntel:" + match.rawString());
                }
                text.setText(sb.toString());
            }
        });
    }
}
