package io.github.ytam.retrofitnew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import io.github.ytam.retrofitnew.ui.Photos;
import io.github.ytam.retrofitnew.ui.Todos;

public class Home extends AppCompatActivity {


    Button btnTodos, btnPhotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnPhotos = findViewById(R.id.btnPhotos);
        btnTodos = findViewById(R.id.btnTodos);


        btnTodos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, Todos.class));
            }
        });

        btnPhotos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, Photos.class));
            }
        });
    }
}
