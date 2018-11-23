package aleksandrpolkin.ru.wordpressclient.Recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import aleksandrpolkin.ru.wordpressclient.Class.Category;
import aleksandrpolkin.ru.wordpressclient.R;

public class RecyclerAdapterCategory extends RecyclerView.Adapter<RecyclerAdapterCategory.ViewHolder> {

    private List<Category> categoryList;

    public RecyclerAdapterCategory(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public RecyclerAdapterCategory.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_category, parent, false);
        return new RecyclerAdapterCategory.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterCategory.ViewHolder holder, int position) {
        holder.setDataset(categoryList.get(position));
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView description;

        ViewHolder(View itemView) {
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
