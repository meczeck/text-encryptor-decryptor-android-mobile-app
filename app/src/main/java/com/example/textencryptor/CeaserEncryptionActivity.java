package com.example.textencryptor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class CeaserEncryptionActivity extends AppCompatActivity {

    TextView encryptedTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ceaser_encryption);

        setTitle(R.string.ceaser_encrypt_activity);

        encryptedTextView = findViewById(R.id.textView);

        Intent intent =  getIntent();
        String textToConvert = intent.getStringExtra("textToConvert");

        String encryptedText = ceaserEncrypt(textToConvert, 3);
        //String decryptedText = decrypt(textToConvert, 3);
        encryptedTextView.setText("Encrypted Text : " + encryptedText);



    }

    //Function to Encrypt text by  Ceaser Algorithm
    public static String ceaserEncrypt(String plainText, int shift) {
        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < plainText.length(); i++) {
            char c = plainText.charAt(i);
            if (Character.isLetter(c)) {
                if (Character.isLowerCase(c)) {
                    char encryptedChar = (char) (((c - 'a' + shift) % 26) + 'a');
                    encryptedText.append(encryptedChar);
                } else {
                    char encryptedChar = (char) (((c - 'A' + shift) % 26) + 'A');
                    encryptedText.append(encryptedChar);
                }
            } else {
                encryptedText.append(c);
            }
        }

        return encryptedText.toString();
    }



}