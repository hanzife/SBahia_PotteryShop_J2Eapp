package dao;

import Beans.Articles;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class daoArticleImp implements daoArticle {

    @Override
    public List<Articles> getAll() throws ClassNotFoundException, SQLException {
        List<Articles> articles = new ArrayList<Articles>();

        Statement statement = ConnectDB.getCon().createStatement();
        System.out.println("creation de l'objet Statement");

        ResultSet resultat;

        String requete = "SELECT * FROM public.\"Articles\"";

        resultat = statement.executeQuery(requete);

        while (resultat.next()) {

            int IdArticle = resultat.getInt("IdArticle");
            String NameArticle = resultat.getString("NameArticle");
            double Price = resultat.getDouble("Price");
            int QteStock = resultat.getInt("QteStock");
            String Description = resultat.getString("Description");
            String Image = resultat.getString("Image");
            System.out.println(IdArticle);

            Articles a = new Articles(IdArticle, NameArticle, Description, Price, QteStock, Image);


            articles.add(a);
        }

        return articles;

    }

    @Override
    public Articles getById(int IdArticle) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public Articles saveArticle(Articles a) throws ClassNotFoundException, SQLException {

        Articles reponse = null;

        int IdArticle;


        IdArticle = -1;

        String query = "INSERT INTO public.\"Articles\"(\"QteStock\", \"Price\", \"NameArticle\", \"Description\", \"Image\") VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = ConnectDB.getCon().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

        statement.setInt(1, a.getQteStock());
        statement.setDouble(2, a.getPrice());
        statement.setString(3, a.getNameArticle());
        statement.setString(4, a.getDescription());
        statement.setString(5, a.getImage());

        statement.executeUpdate();

        ResultSet rs = statement.getGeneratedKeys();

        if (rs.next()) {
            IdArticle = rs.getInt(1);
        }
        reponse = new Articles(IdArticle, a.getNameArticle(), a.getDescription(), a.getPrice(), a.getQteStock(), a.getImage());
        return reponse;
    }


    @Override
    public Articles updateArticle(Articles a) throws ClassNotFoundException, SQLException {
        Articles reponse = null;

        String query = "UPDATE public.\"Articles\" SET \"QteStock\"=?, \"Price\"=?, \"NameArticle\"=?, \"Description\"=?, \"Image\"=? WHERE \"IdArticle\" = ?";

        PreparedStatement statement = ConnectDB.getCon().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

        statement.setInt(1, a.getQteStock());
        statement.setDouble(2, a.getPrice());
        statement.setString(3, a.getNameArticle());
        statement.setString(4, a.getDescription());
        statement.setString(5, a.getImage());
        statement.setInt(6, a.getIdArticle());

        statement.executeUpdate();

        //ResultSet rs = statement.getGeneratedKeys();


        reponse = new Articles(a.getIdArticle(), a.getNameArticle(), a.getDescription(), a.getPrice(), a.getQteStock(), a.getImage());
        return reponse;

    }

    @Override
    public int deleteById(int IdArticle) throws SQLException {

        PreparedStatement ps = ConnectDB.getCon().prepareStatement("DELETE FROM public.\"Articles\" WHERE \"IdArticle\" = ?");
        ps.setInt(1, IdArticle);
        ps.executeUpdate();

        return 0;

    }


}
