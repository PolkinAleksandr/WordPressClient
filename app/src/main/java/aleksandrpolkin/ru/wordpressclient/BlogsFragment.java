package aleksandrpolkin.ru.wordpressclient;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import aleksandrpolkin.ru.wordpressclient.data.Blogs;
import aleksandrpolkin.ru.wordpressclient.recycler.RecyclerAdapterBlogs;


public class BlogsFragment extends Fragment {

    static final String FRAGMENT_BLOGS = "fragment_blogs";
    private List<Blogs> blogsList;

    public static BlogsFragment createInstance() {
        return new BlogsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.screen_fragment_blogs, container, false);
        setHasOptionsMenu(true);
        blogsList = new ArrayList<>();
        createBlogs("Мой блог", "myblog.wordpress.com", null);
        createBlogs("Мой блог1", "myblog1.wordpress.com", null);
        RecyclerView recyclerViewBlogs = view.findViewById(R.id.recycler_blogs);
        recyclerViewBlogs.setLayoutManager(new LinearLayoutManager(view.getContext()));
        RecyclerView.Adapter adapterRecycler = new RecyclerAdapterBlogs(blogsList, NameBlogsFragment.FRAGMENT_NAME_BLOG);
        recyclerViewBlogs.setAdapter(adapterRecycler);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getActivity() != null) {
            Toolbar toolbar = getActivity().findViewById(R.id.toolbar_main);
            toolbar.setTitle(getResources().getString(R.string.text_tittle_blogs));
        }
    }

    public void createBlogs(String someId, String myWord, Drawable drawable) {
        Blogs blogs = new Blogs();
        blogs.setBlogs(someId, myWord, drawable);
        blogsList.add(blogs);
    }

}