package aleksandrpolkin.ru.wordpressclient.Class;

import android.graphics.drawable.Drawable;

public class NameBlogs {
    private String name;
    private String date;
    private String align;
    private Drawable post;
    private Drawable avatar;

    public Drawable getAvatar() {
        return avatar;
    }

    public void setAvatar(Drawable avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Drawable getPost() {
        return post;
    }

    public void setPost(Drawable post) {
        this.post = post;
    }

    public String getAlign() {
        return align;
    }

    public void setAlign(String align) {
        this.align = align;
    }

    public void setNameBlogs(String name, String date, String align, Drawable post, Drawable avatar) {
        this.date = date;
        this.post = post;
        this.name = name;
        this.align = align;
        this.avatar = avatar;
    }
}
