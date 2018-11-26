package aleksandrpolkin.ru.wordpressclient.Recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import aleksandrpolkin.ru.wordpressclient.Class.Blogs;
import aleksandrpolkin.ru.wordpressclient.Interface.OnMyClick;
import aleksandrpolkin.ru.wordpressclient.R;

public class RecyclerAdapterBlogs extends RecyclerView.Adapter<RecyclerAdapterBlogs.ViewHolder> {

    private List<Blogs> blogsList;

    public RecyclerAdapterBlogs(List<Blogs> blogsList) {
        this.blogsList = blogsList;
    }

    @NonNull
    @Override
    public RecyclerAdapterBlogs.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_blogs, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterBlogs.ViewHolder holder, int position) {
        holder.setDataset(blogsList.get(position));
    }

    @Override
    public int getItemCount() {
        return blogsList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView someId;
        private TextView myBlogsWord;
        private ImageView imageView;
        private OnMyClick onMyClick;

        ViewHolder(View itemView) {
            super(itemView);
            someId = itemView.findViewById(R.id.text_name_blog);
            myBlogsWord = itemView.findViewById(R.id.text_myblog_word);
            imageView = itemView.findViewById(R.id.image_view_recycler_blogs);
        }

        void setDataset(final Blogs blogs) {
            someId.setText(blogs.getSomeId());
            myBlogsWord.setText(blogs.getMyBlogsWord());
            onMyClick = (OnMyClick) itemView.getContext();
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onMyClick.setOnMyClick();
                }
            });
        }
    }
}
