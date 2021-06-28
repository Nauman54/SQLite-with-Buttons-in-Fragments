package com.example.a3_nauman_191169.Fragments;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.a3_nauman_191169.Adapters.RecyclerViewAdapter;
import com.example.a3_nauman_191169.Model.Student;
import com.example.a3_nauman_191169.R;
import com.example.a3_nauman_191169.SqliteDB_helper;

import java.util.ArrayList;
import java.util.List;

public class ViewFragment extends Fragment {

    Button btn_insertData, btn_viewData;
    List<Student> studentList = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerViewAdapter RecyclerAdapter;
    SqliteDB_helper sqliteDB_helper;

    public ViewFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view, container, false);

        btn_insertData = view.findViewById(R.id.btn_insertData);
        btn_viewData = view.findViewById(R.id.button_viewData);
        recyclerView = view.findViewById(R.id.recyclerView);
        sqliteDB_helper = new SqliteDB_helper(getContext());

        btn_insertData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new InsertFragment()).commit();
            }
        });

        btn_viewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewDataOnTextView();
            }
        });

        return view;
    }


    public void viewDataOnTextView() {
        Cursor eachRecord_cursor = sqliteDB_helper.getStudentData();
        if (eachRecord_cursor.getCount() == 0) {
            Toast.makeText(getContext(), "No record", Toast.LENGTH_SHORT).show();
            return;
        }
        while (eachRecord_cursor.moveToNext()) {
            String id, name, city, age;
            id = eachRecord_cursor.getString(0);
            name = eachRecord_cursor.getString(1);
            city = eachRecord_cursor.getString(2);
            age = eachRecord_cursor.getString(3);

            studentList.add(new Student(id, name, city, age));
            RecyclerAdapter = new RecyclerViewAdapter(studentList, getContext());
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(RecyclerAdapter);
        }
    }

}