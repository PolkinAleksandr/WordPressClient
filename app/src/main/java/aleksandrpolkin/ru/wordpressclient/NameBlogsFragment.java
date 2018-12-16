package aleksandrpolkin.ru.wordpressclient;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import aleksandrpolkin.ru.wordpressclient.data.NameBlogs;
import aleksandrpolkin.ru.wordpressclient.recycler.RecyclerAdapterNameBlogs;

public class NameBlogsFragment extends Fragment {

    private List<NameBlogs> nameBlogsList;
    static final String FRAGMENT_NAME_BLOG = "fragment_name_blog";

    public static NameBlogsFragment createInstance() {
        return new NameBlogsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.screen_name_blogs, container, false);

        FloatingActionButton fab = v.findViewById(R.id.fab_add);
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
        RecyclerView recyclerViewNameBlog = v.findViewById(R.id.recycler_view_name_blogs);
        recyclerViewNameBlog.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView.Adapter adapterRecycler = new RecyclerAdapterNameBlogs(nameBlogsList, PostFragment.FRAGMENT_POST);
        recyclerViewNameBlog.setAdapter(adapterRecycler);
        return v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        inflater.inflate(R.menu.blogs_list, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    public void createNameBlogs(String name, String time, String align, Drawable post, Drawable avatar) {
        NameBlogs nameBlogs = new NameBlogs();
        nameBlogs.setNameBlogs(name, time, align, post, avatar);
        nameBlogsList.add(nameBlogs);
    }
}
