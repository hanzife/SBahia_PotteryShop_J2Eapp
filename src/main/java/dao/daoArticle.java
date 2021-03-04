package dao;

import Beans.Articles;

import java.sql.SQLException;
import java.util.List;

public interface daoArticle {

    public List<Articles> getAll() throws ClassNotFoundException, SQLException;

    public Articles getById(int IdArticle) throws ClassNotFoundException, SQLException;

    public Articles saveArticle(Articles a) throws ClassNotFoundException, SQLException;

    public Articles updateArticle(Articles a) throws ClassNotFoundException, SQLException;

    public int deleteById(int IdArticle) throws SQLException;
}
