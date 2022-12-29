package com.example.textencryptor;

import static com.example.textencryptor.Rot13EncryptionActivity.rot13Encrypt;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Rot13DecryptionActivity extends AppCompatActivity {

    TextView decryptedTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rot13_decryption);

        setTitle(R.string.rot_13_decrypt_activity_title);

        //To get TextView element from XML
        decryptedTextView = findViewById(R.id.textView);

        //To  create Intent Object
        Intent intent = getIntent();
        //To  get data  passed from main  activity
        String textToConvert = intent.getStringExtra("textToConvert");

        //To call the ceaser  decryption  Function
        String decryptedText = rot13Decrypt(textToConvert);
        decryptedTextView.setText("Decrypted Text : " + decryptedText);
    }

    //Method for ROT 13 decryption Algorithm
    public static String rot13Decrypt(String text) {
        // ROT-13 is its own inverse, so decrypting is the same as encrypting
        return rot13Encrypt(text);
    }
}