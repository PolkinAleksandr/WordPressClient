package aleksandrpolkin.ru.wordpressclient.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import aleksandrpolkin.ru.wordpressclient.data.Category;
import aleksandrpolkin.ru.wordpressclient.R;

public class RecyclerAdapterCategory extends RecyclerView.Adapter<RecyclerAdapterCategory.CategoryViewHolder> {

    private List<Category> categoryList;

    public RecyclerAdapterCategory(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_category, parent, false);
        return new CategoryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.setDataset(categoryList.get(position));
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    static class CategoryViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView description;

        CategoryViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.text_category_name);
            description = itemView.findViewById(R.id.text_category_description);
        }

        void setDataset(final Category category) {
            name.setText(category.getName());
            description.setText(category.getDescription());
        }
    }
}
