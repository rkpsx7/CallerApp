package com.example.callerapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements clickListener {
    private final ArrayList<Model> contacts = new ArrayList<>();
    private Adapter adapter;
    private RecyclerView recyclerView;
    private TextView noContactsInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        buildList();
    }

    private void buildList() {
        for (int i = 0; i < 3; i++) {
            contacts.add(new Model("Home", "778899445"));
            contacts.add(new Model("School", "9988556633"));
            contacts.add(new Model("Abhishek", "7722514547"));
            contacts.add(new Model("Amol", "9865896578"));
        }
    }


    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        noContactsInfo = findViewById(R.id.tvTextView);
        String[] permissions = {Manifest.permission.READ_CONTACTS};
        ActivityCompat.requestPermissions(MainActivity.this, permissions, 01);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 01) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Contacts Permission Granted", Toast.LENGTH_SHORT).show();
                recyclerView.setVisibility(View.VISIBLE);
                noContactsInfo.setVisibility(View.GONE);
                setAdapter();
            } else {
                Toast.makeText(MainActivity.this, "Contacts Permission Denied", Toast.LENGTH_SHORT).show();
                recyclerView.setVisibility(View.GONE);
                noContactsInfo.setVisibility(View.VISIBLE);
            }
        }
    }

    private void setAdapter() {
        adapter = new Adapter(contacts, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(Model model) {

        String num = model.getNo();
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", num, null));
        startActivity(intent);
    }
}