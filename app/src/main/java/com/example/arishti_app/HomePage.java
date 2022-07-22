package com.example.arishti_app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity {
    ListView listView;
    ArrayList<String> list;
    Button btn_add, btn_delete, btn_data;
    EditText editText;
    ArrayAdapter<String> arrayAdapter;
    private Context context;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        //object reference
        listView = (ListView) findViewById(R.id.hp_listview);
        btn_add = (Button) findViewById(R.id.hp_add);
        editText = (EditText) findViewById(R.id.hp_text);
        list = new ArrayList<String>();
        arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, list);
        btn_delete = (Button) findViewById(R.id.hp_delete);
        btn_data = (Button) findViewById(R.id.data_access);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                list.add(text);
                listView.setAdapter(arrayAdapter);
                arrayAdapter.notifyDataSetChanged();
            }
        });
        btn_delete.setOnClickListener((view -> {
            for(int i=0; i<list.size(); i++){
                String text = editText.getText().toString();
                if(list.get(i).equals(text)){
                    list.remove(i);
                    arrayAdapter.notifyDataSetChanged();
                    break;
                }
                else {
                    Toast.makeText(HomePage.this, "No Rows selected!", Toast.LENGTH_SHORT).show();
                }
            }
        }));
        btn_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = editText.getText().toString();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://docs.coincap.io/"));
                startActivity(i);
            }
        });
    }
}
