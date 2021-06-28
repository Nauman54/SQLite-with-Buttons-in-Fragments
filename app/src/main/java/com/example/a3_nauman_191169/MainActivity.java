package com.example.a3_nauman_191169;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a3_nauman_191169.Fragments.InsertFragment;
import com.example.a3_nauman_191169.Fragments.ViewFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        getSupportFragmentManager().beginTransaction().add(R.id.container,new InsertFragment()).commit();

    }
}
