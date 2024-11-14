package com.example.digitclassifier;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.divyanshu.draw.activity.DrawingActivity;

public class MainActivity2 extends AppCompatActivity implements Button.OnClickListener {
    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.input_Et);
        textView = (TextView)findViewById(R.id.output_Tv);

        Button button = (Button)findViewById(R.id.input_Btn);
        button.setOnClickListener(this) ;
        Button actBtn = findViewById(R.id.activity_launch_Btn);
        actBtn.setOnClickListener(this) ;
        Button drawSampleBtn = findViewById(R.id.draw_sample_Btn);
        drawSampleBtn.setOnClickListener(this) ;
        Button drawBtn = findViewById(R.id.draw_Btn);
        drawBtn.setOnClickListener(this) ;
    }


    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()) {
            case R.id.input_Btn :
                String text = editText.getText().toString();
                textView.setText(text);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(10 * 1000);
                            Toast.makeText(MainActivity2.this, "complete", Toast.LENGTH_SHORT).show();
//                            runOnUiThread(new Runnable() {
//                                @Override
//                                public void run() {
//                                    Toast.makeText(MainActivity.this, "complete", Toast.LENGTH_SHORT).show();
//                                }
//                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

                break ;
            case R.id.activity_launch_Btn :
                i = new Intent(MainActivity2.this, MyActivity.class);
                startActivity(i);
                break ;
            case R.id.draw_sample_Btn :
                i = new Intent(MainActivity2.this, DrawingActivity.class);
                startActivity(i);
                break ;
            case R.id.draw_Btn :
                i = new Intent(MainActivity2.this, DrawActivity.class);
                startActivity(i);
                break ;
        }
    }
}
