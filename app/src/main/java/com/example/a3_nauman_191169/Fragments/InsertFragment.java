package com.example.a3_nauman_191169.Fragments;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a3_nauman_191169.R;
import com.example.a3_nauman_191169.SqliteDB_helper;

public class InsertFragment extends Fragment {

    EditText editText_id, editText_name, editText_city, editText_age;
    Button button_saveData, button_viewData;
    SqliteDB_helper sqliteDB_helper;

    public InsertFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_insert, container, false);

        editText_id = view.findViewById(R.id.et_id);
        editText_name = view.findViewById(R.id.et_name);
        editText_city = view.findViewById(R.id.et_city);
        editText_age = view.findViewById(R.id.et_age);

        button_saveData = view.findViewById(R.id.btn_saveData);
        button_viewData = view.findViewById(R.id.btn_viewData);

        sqliteDB_helper = new SqliteDB_helper(getContext());

        button_saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = editText_id.getText().toString();
                String name = editText_name.getText().toString();
                String city = editText_city.getText().toString();
                String age = editText_age.getText().toString();

                boolean checkSaved = sqliteDB_helper.insertStudentData(id, name, city, age);
                if (checkSaved == true) {
                    Toast.makeText(getContext(), "Data Saved Successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Data Not Saved", Toast.LENGTH_SHORT).show();
                }

            }
        });

        button_viewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,new ViewFragment()).commit();
            }
        });

        return view;
    }


}