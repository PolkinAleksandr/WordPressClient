package aleksandrpolkin.ru.wordpressclient;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import aleksandrpolkin.ru.wordpressclient.data.PostTag;
import aleksandrpolkin.ru.wordpressclient.recycler.RecyclerAdapterPostTag;

public class PostFragment extends Fragment {

    private List<PostTag> postTagList;
    static final String FRAGMENT_POST = "fragment_post";

    public static PostFragment createInstance() {
        return new PostFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.screen_post, container, false);

        FloatingActionButton fab = v.findViewById(R.id.fab_comments);
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
        RecyclerView recyclerViewNameBlog = v.findViewById(R.id.recycle_view_post_tag);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewNameBlog.setLayoutManager(linearLayoutManager);
        RecyclerView.Adapter adapterRecycler = new RecyclerAdapterPostTag(postTagList);
        recyclerViewNameBlog.setAdapter(adapterRecycler);

        return v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        inflater.inflate(R.menu.post, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getActivity() != null) {
            Toolbar toolbar = getActivity().findViewById(R.id.toolbar_main);
            toolbar.setTitle(getResources().getString(R.string.text_tittle_post_tag));
        }
    }

    public void createPostTag(String text, int color) {
        PostTag postTag = new PostTag();
        postTag.setPostTag(color, text);
        postTagList.add(postTag);
    }
}
