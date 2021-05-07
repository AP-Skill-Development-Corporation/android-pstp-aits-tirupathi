package com.muni.example.myrecycelrview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ExampleAdapter adapter;
    private List<ExampleItem> exampleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillExampleList();
        setUpRecyclerView();
    }

    private void fillExampleList() {
        exampleList = new ArrayList<>();
        exampleList.add(new ExampleItem(R.drawable.ic_baseline_wb_sunny_24, "One", "Ten"));
        exampleList.add(new ExampleItem(R.drawable.ic_baseline_audiotrack_24, "Two", "Eleven"));
        exampleList.add(new ExampleItem(R.drawable.ic_baseline_wb_sunny_24, "Three", "Twelve"));
        exampleList.add(new ExampleItem(R.drawable.ic_baseline_audiotrack_24, "Four", "Thirteen"));
        exampleList.add(new ExampleItem(R.drawable.ic_baseline_wb_sunny_24, "Five", "Fourteen"));
        exampleList.add(new ExampleItem(R.drawable.ic_baseline_audiotrack_24, "Six", "Fifteen"));
        exampleList.add(new ExampleItem(R.drawable.ic_baseline_wb_sunny_24, "Seven", "Sixteen"));
        exampleList.add(new ExampleItem(R.drawable.ic_baseline_audiotrack_24, "Eight", "Seventeen"));
        exampleList.add(new ExampleItem(R.drawable.ic_baseline_wb_sunny_24, "Nine", "Eighteen"));
    }

    private void setUpRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new ExampleAdapter();
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_example, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }
}