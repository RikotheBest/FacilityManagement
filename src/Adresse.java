public class Adresse {
    private String strasse;
    private int post;
    private String land;

    public Adresse(String strasse, int post, String land) {
        this.strasse = strasse;
        this.post = post;
        this.land = land;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public int getPost() {
        return post;
    }

    public void setPost(int post) {
        this.post = post;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }
}
