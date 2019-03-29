package com.example.quotegenerator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText quote = (EditText) findViewById(R.id.quote);
        Button btn = (Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!quote.getText().toString().matches("")){
                    Intent intent = new Intent(MainActivity.this, QuoteActivity.class);
                    Bundle b = new Bundle();
                    b.putString("quote", quote.getText().toString());
                    intent.putExtras(b);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast toast = Toast.makeText(getApplicationContext(),"Por favor introduce un texto", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
}
