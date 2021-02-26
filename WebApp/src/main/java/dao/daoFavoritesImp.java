package dao;

import Beans.Articles;
import Beans.Favorites;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class daoFavoritesImp implements daoFavorites {

    @Override
    public Favorites saveFavorite(Favorites f) throws ClassNotFoundException, SQLException {

        Favorites reponse = null;

        String query = "INSERT INTO public.favorites(id_user, id_article) VALUES (?, ?)";

        PreparedStatement statement = ConnectDB.getCon().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

        statement.setInt(1, f.getId_User());
        statement.setInt(2, f.getId_Article());

        statement.executeUpdate();

        ResultSet rs = statement.getGeneratedKeys();

        //reponse = new Articles( IdArticle, a.getNameArticle(), a.getDescription(), a.getPrice(), a.getQteStock(), a.getImage());
        return reponse;
    }


}
