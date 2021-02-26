package Beans;

public class Favorites {
    private int Id_User;
    private int Id_Article;

    public Favorites(int Id_User, int Id_Article) {
        super();
        this.Id_User = Id_User;
        this.Id_Article = Id_Article;
    }


    public int getId_User() {
        return Id_User;
    }

    public void setId_User(int id_User) {
        Id_User = id_User;
    }

    public int getId_Article() {
        return Id_Article;
    }

    public void setId_Article(int id_Article) {
        Id_Article = id_Article;
    }
}