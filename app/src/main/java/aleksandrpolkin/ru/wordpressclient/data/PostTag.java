package aleksandrpolkin.ru.wordpressclient.data;

public class PostTag {
    private int color;
    private String text;

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setPostTag(int color, String text) {
        this.color = color;
        this.text = text;
    }
}
