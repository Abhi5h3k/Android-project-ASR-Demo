package com.example.abhi.asrdemo;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.media.Image;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final int REQ_CODE = 100;
     private TextView output;
     private Button Button;
     private String language="en-IN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output= (TextView) findViewById(R.id.TextOutpuField);
    }

    public void setLanguage(View v){
        int id=v.getId();
        switch(id){
            case R.id.Bengali:{
                language="bn";

                startVoiceInput();
                break;
            }
            case R.id.English:{
                language="en";
                 startVoiceInput();
                break;
            }
            case R.id.Gujarati:{
                language="gu";
                 startVoiceInput();
                break;
            }case R.id.Kannada:{
                language="kn";
                 startVoiceInput();
                break;
            }case R.id.Malayalam:{
                language="ml";
                 startVoiceInput();
                break;
            }case R.id.Marathi:{
                language="mr";
                 startVoiceInput();
                break;
            }case R.id.Tamil:{
                language="ta";
                 startVoiceInput();
                break;
            }case R.id.Telugu:{
                language="te";
                 startVoiceInput();
                break;
            }case R.id.Urdu:{
                language="ur";
                 startVoiceInput();
                break;
            }case R.id.Hindi:{
                language="hi";
                 startVoiceInput();
                break;
            }

        }
    }


    private void startVoiceInput() {

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, language);

        try {
            startActivityForResult(intent, REQ_CODE);
        } catch (ActivityNotFoundException a) {

        }
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    output.setText(result.get(0));
                }
                break;
            }

        }
    }


}
