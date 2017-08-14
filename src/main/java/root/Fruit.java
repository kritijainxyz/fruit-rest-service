package root;

public class Fruit {

    private long id;
    private String name;
    private String url;

    public Fruit() {
    }

    public Fruit(long id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
