package aleksandrpolkin.ru.wordpressclient.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import aleksandrpolkin.ru.wordpressclient.data.NameBlogs;
import aleksandrpolkin.ru.wordpressclient.myinterface.CallbackFragment;
import aleksandrpolkin.ru.wordpressclient.R;

public class RecyclerAdapterNameBlogs extends RecyclerView.Adapter<RecyclerAdapterNameBlogs.NameBlogViewHolder> {

    private List<NameBlogs> nameBlogs;
    private String tag;

    public RecyclerAdapterNameBlogs(List<NameBlogs> nameBlogsList, String tag) {
        this.nameBlogs = nameBlogsList;
        this.tag = tag;
    }

    @NonNull
    @Override
    public NameBlogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_name_blogs, parent, false);
        return new NameBlogViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NameBlogViewHolder holder, int position) {
        holder.setDataset(nameBlogs.get(position), tag);
    }

    @Override
    public int getItemCount() {
        return nameBlogs.size();
    }

    static class NameBlogViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView time;
        private TextView align;
        private ImageView avatar;
        private ImageView postImage;
        private CallbackFragment callbackFragment;

        NameBlogViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.text_name);
            time = itemView.findViewById(R.id.text_date);
            align = itemView.findViewById(R.id.text_align);
            avatar = itemView.findViewById(R.id.image_avatar);
            postImage = itemView.findViewById(R.id.image_post);

        }

        void setDataset(final NameBlogs nameBlogs, final String tag) {
            name.setText(nameBlogs.getName());
            time.setText(nameBlogs.getDate());
            align.setText(nameBlogs.getAlign());
            avatar.setImageDrawable(nameBlogs.getAvatar());
            postImage.setImageDrawable(nameBlogs.getPost());
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
