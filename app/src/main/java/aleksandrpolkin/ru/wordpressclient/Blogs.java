package aleksandrpolkin.ru.wordpressclient;

import android.graphics.drawable.Drawable;

public class Blogs {
    private Drawable drawable;
    private String someId;
    private String myBlogsWord;

    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public String getSomeId() {
        return someId;
    }

    public void setSomeId(String someId) {
        this.someId = someId;
    }

    public String getMyBlogsWord() {
        return myBlogsWord;
    }

    public void setMyBlogsWord(String myBlogsWord) {
        this.myBlogsWord = myBlogsWord;
    }

    public void setBlogs(String someId, String myBlogsWord, Drawable drawable){
        this.drawable = drawable;
        this.someId = someId;
        this.myBlogsWord = myBlogsWord;
    }
}
