package dao;

import Beans.Articles;
import Beans.Favorites;

import java.sql.SQLException;

public interface daoFavorites {
    public Favorites saveFavorite(Favorites f) throws ClassNotFoundException, SQLException;

}
