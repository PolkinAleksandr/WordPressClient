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

import aleksandrpolkin.ru.wordpressclient.data.Tags;
import aleksandrpolkin.ru.wordpressclient.recycler.RecyclerAdapterTags;


/**
 * A simple {@link Fragment} subclass.
 */
public class TagsFragment extends Fragment {


    static final String FRAGMENT_TAG = "screen_fragment_tags";
    private List<Tags> tagsList;

    public static TagsFragment createInstance() {
        return new TagsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.screen_fragment_tags, container, false);
        tagsList = new ArrayList<>();
        createTags("Метка1", getResources().getDrawable(R.drawable.ic_oval_3));
        createTags("Метка2", getResources().getDrawable(R.drawable.ic_oval_3_1));
        RecyclerView recyclerViewTags = v.findViewById(R.id.recycler_fragment_tags);
        recyclerViewTags.setLayoutManager(new LinearLayoutManager(v.getContext()));
        RecyclerView.Adapter adapterRecycler = new RecyclerAdapterTags(tagsList);
        recyclerViewTags.setAdapter(adapterRecycler);
        return v;
    }

    public void createTags(String someId, Drawable drawable) {
        Tags tags = new Tags();
        tags.setTags(someId, drawable);
        tagsList.add(tags);
    }
}
