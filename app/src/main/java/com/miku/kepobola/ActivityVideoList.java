package com.miku.kepobola;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ActivityVideoList extends AppCompatActivity {

    String[] listArray={"1) Fouls and Misconduct",
            "2) Match Management",
            "3) Match Officials Technique"};

    ListView listview;
    String fileContent;
    String titleContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Video Lainnya");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listArray);
        listview = findViewById(R.id.listview);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 0:
                        fileContent = "video_fouls.html";
                        titleContent = "FOULS AND MISCONDUCT";
                        break;
                    case 1:
                        fileContent = "video_match.html";
                        titleContent = "MATCH MANAGEMENT";
                        break;
                    case 2:
                        fileContent = "video_official.html";
                        titleContent = "MATCH OFFICIALS TECHNIQUE";
                        break;
                    default:
                        break;
                }

                Intent intent = new Intent(ActivityVideoList.this, ContentActivity.class);
                intent.putExtra("fileContent",  fileContent);
                intent.putExtra("titleContent", titleContent);
                startActivity(intent);

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
