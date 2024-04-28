package com.example.app12;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Fragment1 extends Fragment {
    public Fragment1() {
        super(R.layout.fragment_1);
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText getId = view.findViewById(R.id.get_id);
        EditText getName = view.findViewById(R.id.get_name);
        EditText getAuthor = view.findViewById(R.id.get_author);

        Button bUpload = view.findViewById(R.id.button2);
        bUpload.setOnClickListener((v) -> {
            APIData.addDataToApi(getId.getText().toString(),
                    getName.getText().toString(), getAuthor.getText().toString());
        });
        Button bGet = view.findViewById(R.id.button3);
        bGet.setOnClickListener((v) -> {
            APIData.getDataFromApi();
        });
        Button bDeleteAll = view.findViewById(R.id.button4);
        bDeleteAll.setOnClickListener((v) -> {
            APIData.deleteDataFromApi(Integer.parseInt(getId.getText().toString()));
        });
    }

}