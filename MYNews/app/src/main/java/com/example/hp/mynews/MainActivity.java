package com.example.hp.mynews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;

import com.example.hp.mynews.datafetch.JsonParser;
import com.example.hp.mynews.datafetch.NewsData;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    final static String APIKey= "https://newsapi.org/v1/articles?source=bbc-news&sortBy=top&apiKey=207446789fcb4997aee20c728b02d67b";
    private RecyclerView recyclerView;
    private DataAdapter adapter;
    private JsonParser jsonParser = new JsonParser();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConnectionClass connectionClass = new ConnectionClass();

        try {




            ArrayList<NewsData> arrayList = jsonParser.JsonParsing(connectionClass.execute(APIKey).get());

            recyclerMain();


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
    private void recyclerMain() {

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new DataAdapter(jsonParser.getlist(), getApplicationContext(), this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        adapter.notifyDataSetChanged();

    }
}
