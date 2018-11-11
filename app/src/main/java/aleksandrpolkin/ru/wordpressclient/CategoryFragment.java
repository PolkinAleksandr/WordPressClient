package aleksandrpolkin.ru.wordpressclient;


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

import aleksandrpolkin.ru.wordpressclient.Class.Category;
import aleksandrpolkin.ru.wordpressclient.Recycler.RecyclerAdapterCategory;

public class CategoryFragment extends Fragment {


    static final String FRAGMENT_TAG = "screen_fragment_category";
    private List<Category> categoryList;

    public static CategoryFragment createInstance() {
        return new CategoryFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.screen_fragment_category, container, false);
        categoryList = new ArrayList<>();
        createCategory("Категория1", "Описание категории 1");
        createCategory("Категория2", "Описание категории 2");
        RecyclerView recyclerViewCategory = v.findViewById(R.id.recycler_view_category);
        recyclerViewCategory.setLayoutManager(new LinearLayoutManager(v.getContext()));
        RecyclerView.Adapter adapterRecycler = new RecyclerAdapterCategory(categoryList);
        recyclerViewCategory.setAdapter(adapterRecycler);
        return v;
    }

    public void createCategory(String name, String description) {
        Category category = new Category();
        category.setCategory(name, description);
        categoryList.add(category);
    }
}
