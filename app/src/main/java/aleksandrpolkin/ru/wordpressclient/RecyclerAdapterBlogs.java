package aleksandrpolkin.ru.wordpressclient;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerAdapterBlogs extends RecyclerView.Adapter<RecyclerAdapterBlogs.ViewHolder>{

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

    static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView someId;
        private TextView myBlogsWord;
        private ImageView imageView;
        private OnMyBlogsClick onMyBlogsClick;

        public ViewHolder(View itemView) {
            super(itemView);
            someId = itemView.findViewById(R.id.some_id);
            myBlogsWord = itemView.findViewById(R.id.myblog_word);
            imageView = itemView.findViewById(R.id.imageView_recycler_blogs);
        }

        void setDataset(final Blogs blogs){
            someId.setText(blogs.getSomeId());
            myBlogsWord.setText(blogs.getMyBlogsWord());
            onMyBlogsClick = (OnMyBlogsClick) imageView.getContext();
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onMyBlogsClick.setOnMyClick();
                }
            });
        }
    }
}
