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

        //To set Activity AppBar Title
        setTitle(R.string.ceaser_encrypt_activity);

        //To get TextView element from UI
        encryptedTextView = findViewById(R.id.textView);
        
        //To create an Intent object
        Intent intent =  getIntent();
        String textToConvert = intent.getStringExtra("textToConvert");

        //To call the Ceaser method for Decryption
        String encryptedText = ceaserEncrypt(textToConvert, 3);
        
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
