package com.example.textencryptor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Rot13EncryptionActivity extends AppCompatActivity {

    TextView encryptedTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rot13_encryption);

        setTitle(R.string.rot_13_encrypt_activity_title);

        //To get TextView element from XML
        encryptedTextView = findViewById(R.id.textView);

        //To  create Intent Object
        Intent intent =  getIntent();
        //To  get data  passed from main  activity
        String textToConvert = intent.getStringExtra("textToConvert");

        //To call the ceaser  decryption  Function
        String encryptedText = rot13Encrypt(textToConvert);
        encryptedTextView.setText("Encrypted Text : " + encryptedText);
    }


    public static String rot13Encrypt(String text) {
        StringBuilder encoded = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                int offset = (c >= 'a' && c <= 'z') ? 'a' : 'A';
                c = (char) (((c + 13) - offset) % 26 + offset);
            }
            encoded.append(c);
        }
        return encoded.toString();
    }

    public static String rot13Decrypt(String text) {
        // ROT-13 is its own inverse, so decoding is the same as encoding
        return rot13Encrypt(text);
    }
}