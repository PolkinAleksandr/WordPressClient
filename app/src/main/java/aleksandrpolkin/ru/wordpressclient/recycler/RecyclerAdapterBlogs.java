package aleksandrpolkin.ru.wordpressclient.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import aleksandrpolkin.ru.wordpressclient.data.Blogs;
import aleksandrpolkin.ru.wordpressclient.myinterface.OnMyClick;
import aleksandrpolkin.ru.wordpressclient.R;

public class RecyclerAdapterBlogs extends RecyclerView.Adapter<RecyclerAdapterBlogs.BlogsViewHolder> {

    private List<Blogs> blogsList;

    public RecyclerAdapterBlogs(List<Blogs> blogsList) {
        this.blogsList = blogsList;
    }

    @NonNull
    @Override
    public BlogsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_blogs, parent, false);
        return new BlogsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BlogsViewHolder holder, int position) {
        holder.setDataset(blogsList.get(position));
    }

    @Override
    public int getItemCount() {
        return blogsList.size();
    }

    static class BlogsViewHolder extends RecyclerView.ViewHolder {

        private TextView someId;
        private TextView myBlogsWord;
        private ImageView imageView;
        private OnMyClick onMyClick;

        BlogsViewHolder(View itemView) {
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
