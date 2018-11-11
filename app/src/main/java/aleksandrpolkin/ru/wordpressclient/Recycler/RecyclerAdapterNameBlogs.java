package aleksandrpolkin.ru.wordpressclient.Recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import aleksandrpolkin.ru.wordpressclient.Class.NameBlogs;
import aleksandrpolkin.ru.wordpressclient.Interface.OnMyClick;
import aleksandrpolkin.ru.wordpressclient.R;

public class RecyclerAdapterNameBlogs extends RecyclerView.Adapter<RecyclerAdapterNameBlogs.ViewHolder> {

    private List<NameBlogs> nameBlogs;

    public RecyclerAdapterNameBlogs(List<NameBlogs> nameBlogsList) {
        this.nameBlogs = nameBlogsList;
    }

    @NonNull
    @Override
    public RecyclerAdapterNameBlogs.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_name_blogs, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterNameBlogs.ViewHolder holder, int position) {
        holder.setDataset(nameBlogs.get(position));
    }

    @Override
    public int getItemCount() {
        return nameBlogs.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView time;
        private TextView align;
        private ImageView avatar;
        private ImageView postImage;
        private OnMyClick onMyClick;

        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.text_name);
            time = itemView.findViewById(R.id.text_date);
            align = itemView.findViewById(R.id.text_align);
            avatar = itemView.findViewById(R.id.image_avatar);
            postImage = itemView.findViewById(R.id.image_post);

        }

        void setDataset(final NameBlogs nameBlogs) {
            name.setText(nameBlogs.getName());
            time.setText(nameBlogs.getDate());
            align.setText(nameBlogs.getAlign());
            avatar.setImageDrawable(nameBlogs.getAvatar());
            postImage.setImageDrawable(nameBlogs.getPost());
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
