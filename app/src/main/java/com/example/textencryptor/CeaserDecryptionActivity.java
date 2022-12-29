package com.example.textencryptor;

import static com.example.textencryptor.CeaserEncryptionActivity.ceaserEncrypt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class CeaserDecryptionActivity extends AppCompatActivity {

    TextView decryptedTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ceaser_decryption);

        setTitle(R.string.ceaser_decrypt_activity);

        //To get TextView element from XML
        decryptedTextView = findViewById(R.id.textView);

        //To  create Intent Object
        Intent intent =  getIntent();
        //To  get data  passed from main  activity
        String textToConvert = intent.getStringExtra("textToConvert");

        //To call the ceaser  decryption  Function
        String decryptedText = ceaserDecrypt(textToConvert, 3);
        decryptedTextView.setText("Decrypted Text : " + decryptedText);
    }


    //This function is for  Ceaser Decryption Algorithm
    public static String ceaserDecrypt(String encryptedText, int shift) {
        return ceaserEncrypt(encryptedText, 26 - shift);
    }

}