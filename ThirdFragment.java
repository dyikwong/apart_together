package com.android.example.apart_together;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ThirdFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("message");
        final DatabaseReference myRef2 = database.getReference("body");
        final DatabaseReference emojiRef = database.getReference("emoji");
        final EditText text = view.findViewById(R.id.name_text);
        final EditText body = view.findViewById(R.id.body_text);

        view.findViewById(R.id.happy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emojiRef.setValue("happy");
            }
        });
        view.findViewById(R.id.sad).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emojiRef.setValue("sad");
            }
        });
        view.findViewById(R.id.mad).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emojiRef.setValue("mad");
            }
        });
        view.findViewById(R.id.think).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emojiRef.setValue("think");
            }
        });
        view.findViewById(R.id.heart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emojiRef.setValue("heart");
            }
        });
        view.findViewById(R.id.scared).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emojiRef.setValue("scared");
            }
        });

        view.findViewById(R.id.submit_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String str = text.getText().toString();
                final String str2 = body.getText().toString();
                myRef.setValue(str);
                myRef2.setValue(str2);
                text.setText("");
                body.setText("");
            }
        });
    }
}