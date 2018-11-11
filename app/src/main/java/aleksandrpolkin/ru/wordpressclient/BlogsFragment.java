package aleksandrpolkin.ru.wordpressclient;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import aleksandrpolkin.ru.wordpressclient.Class.Blogs;
import aleksandrpolkin.ru.wordpressclient.Recycler.RecyclerAdapterBlogs;


public class BlogsFragment extends Fragment {

    static final String FRAGMENT_TAG = "fragment_blogs";
    private List<Blogs> blogsList;

    public static BlogsFragment createInstance() {
        return new BlogsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.screen_fragment_blogs, container, false);
        blogsList = new ArrayList<>();
        createBlogs("Мой блог", "myblog.wordpress.com", null);
        createBlogs("Мой блог1", "myblog1.wordpress.com", null);
        RecyclerView recyclerViewBlogs = v.findViewById(R.id.recycler_blogs);
        recyclerViewBlogs.setLayoutManager(new LinearLayoutManager(v.getContext()));
        RecyclerView.Adapter adapterRecycler = new RecyclerAdapterBlogs(blogsList);
        recyclerViewBlogs.setAdapter(adapterRecycler);
        return v;
    }

    public void createBlogs(String someId, String myWord, Drawable drawable) {
        Blogs blogs = new Blogs();
        blogs.setBlogs(someId, myWord, drawable);
        blogsList.add(blogs);
    }

}