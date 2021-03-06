package aleksandrpolkin.ru.wordpressclient.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import aleksandrpolkin.ru.wordpressclient.data.PostTag;
import aleksandrpolkin.ru.wordpressclient.R;

public class RecyclerAdapterPostTag extends RecyclerView.Adapter<RecyclerAdapterPostTag.PostTagViewHolder> {

    private List<PostTag> postTagList;

    public RecyclerAdapterPostTag(List<PostTag> postTagList) {
        this.postTagList = postTagList;
    }

    @NonNull
    @Override
    public PostTagViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_post_tag, parent, false);
        return new PostTagViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PostTagViewHolder holder, int position) {
        holder.setDataset(postTagList.get(position));
    }

    @Override
    public int getItemCount() {
        return postTagList.size();
    }

    static class PostTagViewHolder extends RecyclerView.ViewHolder {

        private TextView text;
        private CardView card;

        PostTagViewHolder(View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text_post_tag);
            card = itemView.findViewById(R.id.card_tag);
        }

        void setDataset(final PostTag postTag) {
            card.setCardBackgroundColor(postTag.getColor());
            text.setText(postTag.getText());
        }
    }
}