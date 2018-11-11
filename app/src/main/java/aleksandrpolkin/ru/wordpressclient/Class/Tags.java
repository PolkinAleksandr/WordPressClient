package aleksandrpolkin.ru.wordpressclient.Class;

import android.graphics.drawable.Drawable;

public class Tags {
    private String someId;
    private Drawable drawable;

    public String getSomeId() {
        return someId;
    }

    public void setSomeId(String someId) {
        this.someId = someId;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public void setTags(String someId, Drawable drawable) {
        this.someId = someId;
        this.drawable = drawable;
    }
}
