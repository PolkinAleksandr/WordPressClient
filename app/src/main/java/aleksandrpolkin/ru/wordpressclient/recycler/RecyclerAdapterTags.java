package aleksandrpolkin.ru.wordpressclient.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import aleksandrpolkin.ru.wordpressclient.data.Tags;
import aleksandrpolkin.ru.wordpressclient.R;

public class RecyclerAdapterTags extends RecyclerView.Adapter<RecyclerAdapterTags.ViewHolder> {

    private List<Tags> tagsList;

    public RecyclerAdapterTags(List<Tags> tagsList) {
        this.tagsList = tagsList;
    }

    @NonNull
    @Override
    public RecyclerAdapterTags.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_tags, parent, false);
        return new RecyclerAdapterTags.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterTags.ViewHolder holder, int position) {
        holder.setDataset(tagsList.get(position));
    }

    @Override
    public int getItemCount() {
        return tagsList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView someId;

        ViewHolder(View itemView) {
            super(itemView);
            someId = itemView.findViewById(R.id.recycler_tags_text);
        }

        void setDataset(final Tags tags) {
            someId.setText(tags.getSomeId());
            someId.setCompoundDrawablesWithIntrinsicBounds(tags.getDrawable(), null, null, null);
        }
    }
}