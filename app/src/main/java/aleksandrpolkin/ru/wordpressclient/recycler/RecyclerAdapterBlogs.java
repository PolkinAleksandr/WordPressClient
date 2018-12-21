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
import aleksandrpolkin.ru.wordpressclient.myinterface.CallbackFragment;
import aleksandrpolkin.ru.wordpressclient.R;

public class RecyclerAdapterBlogs extends RecyclerView.Adapter<RecyclerAdapterBlogs.BlogsViewHolder> {

    private List<Blogs> blogsList;
    private String tag;

    public RecyclerAdapterBlogs(List<Blogs> blogsList, String tag) {
        this.blogsList = blogsList;
        this.tag = tag;
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
        holder.setDataset(blogsList.get(position), tag);
    }

    @Override
    public int getItemCount() {
        return blogsList.size();
    }

    static class BlogsViewHolder extends RecyclerView.ViewHolder {

        private TextView someId;
        private TextView myBlogsWord;
        private ImageView imageView;
        private CallbackFragment callbackFragment;

        BlogsViewHolder(View itemView) {
            super(itemView);
            someId = itemView.findViewById(R.id.text_name_blog);
            myBlogsWord = itemView.findViewById(R.id.text_myblog_word);
            imageView = itemView.findViewById(R.id.image_view_recycler_blogs);
        }

        void setDataset(final Blogs blogs, final String tag) {
            someId.setText(blogs.getSomeId());
            myBlogsWord.setText(blogs.getMyBlogsWord());
            callbackFragment = (CallbackFragment) itemView.getContext();
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callbackFragment.setCallbackFragment(tag);
                }
            });
        }
    }
}
