package aleksandrpolkin.ru.wordpressclient;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
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

import aleksandrpolkin.ru.wordpressclient.Class.NameBlogs;
import aleksandrpolkin.ru.wordpressclient.Interface.OnMyClick;
import aleksandrpolkin.ru.wordpressclient.Recycler.RecyclerAdapterNameBlogs;

public class NameBlogsActivity extends AppCompatActivity implements OnMyClick {

    private List<NameBlogs> nameBlogsList;

    public static Intent createNewIntent(Context context) {
        return new Intent(context, NameBlogsActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_name_blogs);

        getSupportActionBar().setTitle(getResources().getString(R.string.text_tittle_blogs_name));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        nameBlogsList = new ArrayList<>();
        createNameBlogs("Василий Петров", "Сегодня, 13:45", "Заголовок Поста",
                getResources().getDrawable(R.drawable.material_image_3), getResources().getDrawable(R.drawable.ic_avatar_astronaut));
        createNameBlogs("Иван Иванов", "Вчера, 13:45", "Заголовок Поста",
                getResources().getDrawable(R.drawable.material_image_3), getResources().getDrawable(R.drawable.ic_avatar_astronaut));
        RecyclerView recyclerViewNameBlog = findViewById(R.id.recycler_view_name_blogs);
        recyclerViewNameBlog.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView.Adapter adapterRecycler = new RecyclerAdapterNameBlogs(nameBlogsList);
        recyclerViewNameBlog.setAdapter(adapterRecycler);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.blogs_list, menu);
        return true;
    }

    public void createNameBlogs(String name, String time, String align, Drawable post, Drawable avatar) {
        NameBlogs nameBlogs = new NameBlogs();
        nameBlogs.setNameBlogs(name, time, align, post, avatar);
        nameBlogsList.add(nameBlogs);
    }

    @Override
    public void setOnMyClick() {
        startActivity(PostActivity.createNewIntent(this));
    }
}
