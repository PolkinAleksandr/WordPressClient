package aleksandrpolkin.ru.wordpressclient.Class;

public class Category {
    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String name, String descroption) {
        this.name = name;
        this.description = descroption;
    }
}
