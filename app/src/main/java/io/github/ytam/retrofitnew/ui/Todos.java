package io.github.ytam.retrofitnew.ui;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import io.github.ytam.retrofitnew.adapter.TodosAdapter;
import io.github.ytam.retrofitnew.model.RetroTodos;
import io.github.ytam.retrofitnew.network.GetDataService;
import io.github.ytam.retrofitnew.network.RetrofitClientInstance;
import io.github.ytam.retrofitnew.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Todos extends AppCompatActivity {

    private TodosAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos);

        progressDoalog = new ProgressDialog(Todos.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();

        /*Create handle for the RetrofitInstance interface*/
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);

        Call<List<RetroTodos>> call = service.getAllTodos();
        call.enqueue(new Callback<List<RetroTodos>>() {

            @Override
            public void onResponse(Call<List<RetroTodos>> call, Response<List<RetroTodos>> response) {
                progressDoalog.dismiss();
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<RetroTodos>> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(Todos.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(List<RetroTodos> photoList) {
        recyclerView = findViewById(R.id.customRecyclerView);
        adapter = new TodosAdapter(this,photoList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Todos.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

}
