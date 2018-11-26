package aleksandrpolkin.ru.wordpressclient;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import aleksandrpolkin.ru.wordpressclient.Class.PostTag;
import aleksandrpolkin.ru.wordpressclient.Recycler.RecyclerAdapterPostTag;

public class PostActivity extends AppCompatActivity {

    public static Intent createNewIntent(Context context) {
        return new Intent(context, PostActivity.class);
    }

    private List<PostTag> postTagList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_post);

        getSupportActionBar().setTitle(getResources().getString(R.string.text_tittle_post_tag));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = findViewById(R.id.fab_add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        postTagList = new ArrayList<>();
        createPostTag("Тег1", getResources().getColor(R.color.red));
        createPostTag("Тег2", getResources().getColor(R.color.green_dark));
        createPostTag("Длинный тег", getResources().getColor(R.color.blue_dark));
        RecyclerView recyclerViewNameBlog = findViewById(R.id.recycle_view_post_tag);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewNameBlog.setLayoutManager(linearLayoutManager);
        RecyclerView.Adapter adapterRecycler = new RecyclerAdapterPostTag(postTagList);
        recyclerViewNameBlog.setAdapter(adapterRecycler);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.post, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    public void createPostTag(String text, int color) {
        PostTag postTag = new PostTag();
        postTag.setPostTag(color, text);
        postTagList.add(postTag);
    }
}
