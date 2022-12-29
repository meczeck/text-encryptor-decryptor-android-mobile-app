package com.example.textencryptor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText textToConvert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textToConvert = findViewById(R.id.editTextTextToConvert);

        //To get Button Views form UI
        Button ceaserEncryptButton = findViewById(R.id.ceaserEncryptButton);
        Button ceaserDecryptButton = findViewById(R.id.ceaserDecryptButton);
        Button rot13EncryptButton = findViewById(R.id.rot13EncryptButton);
        Button rot13DecryptButton = findViewById(R.id.rot13DecryptButton);

        ceaserEncryptButton.setOnClickListener(this);
        ceaserDecryptButton.setOnClickListener(this);
        rot13EncryptButton.setOnClickListener(this);
        rot13DecryptButton.setOnClickListener(this);
    }

    Intent intent;

    @Override
    public void onClick(View view) {
        //To get text from TextField
        String text = textToConvert.getText().toString();
        if (!text.isEmpty()) {
            // Handle the click event for each button
            switch (view.getId()) {
                case R.id.ceaserEncryptButton:
                    intent = new Intent(this, CeaserEncryptionActivity.class);
                    intent.putExtra("textToConvert", text);
                    startActivity(intent);
                    break;
                case R.id.ceaserDecryptButton:
                    intent = new Intent(this, CeaserDecryptionActivity.class);
                    intent.putExtra("textToConvert", text);
                    startActivity(intent);
                    break;
                case R.id.rot13EncryptButton:
                    intent = new Intent(this, Rot13EncryptionActivity.class);
                    intent.putExtra("textToConvert", text);
                    startActivity(intent);
                    break;
                case R.id.rot13DecryptButton:
                    intent = new Intent(this, Rot13DecryptionActivity.class);
                    intent.putExtra("textToConvert", text);
                    startActivity(intent);
                    break;
            }
        } else {
            Toast.makeText(getApplicationContext(), "Text field is Required", Toast.LENGTH_SHORT).show();
        }
    }
}