package com.example.quotegenerator;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class QuoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bu = getIntent().getExtras();
        String quote = "Placeholder";
        if(bu!=null)
            quote = bu.getString("quote");

        TextView quoteText = (TextView) findViewById(R.id.quoteText);
        quoteText.setText(quote);

        View someview = findViewById(R.id.screen);
        int r=0, g=0, b=0;
        r = new Random().nextInt(256);
        g = new Random().nextInt(256);
        b = new Random().nextInt(256);
        someview.setBackgroundColor(Color.rgb(r, g, b));

        quoteText.setTextColor(Color.rgb(255-r,255-g,255-b));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == android.R.id.home){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }
}
