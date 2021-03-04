package Beans;

public class Articles {
    private int IdArticle;
    private String NameArticle;
    private String Description;
    private Double Price;
    private int QteStock;
    private String Image;

    public Articles(String NameArticle, String Description, double Price, int QteStock, String Image) {
        super();
        this.NameArticle = NameArticle;
        this.Price = Price;
        this.Description = Description;
        this.QteStock = QteStock;
        this.Image = Image;
    }

    public Articles(int IdArticle, String NameArticle, String Description, double Price, int QteStock, String Image) {
        super();
        this.setIdArticle(IdArticle);
        this.NameArticle = NameArticle;
        this.Price = Price;
        this.Description = Description;
        this.QteStock = QteStock;
        this.Image = Image;
    }

    public int getIdArticle() {
        return IdArticle;
    }

    public void setIdArticle(int idArticle) {
        IdArticle = idArticle;
    }

    public String getNameArticle() {
        return NameArticle;
    }

    public void setNameArticle(String nameArticle) {
        NameArticle = nameArticle;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public int getQteStock() {
        return QteStock;
    }

    public void setQteStock(int qteStock) {
        QteStock = qteStock;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
