import Beans.Articles;
import Beans.Favorites;
import dao.daoArticleImp;
import dao.daoFavoritesImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Products extends HttpServlet {

    daoArticleImp articles = new daoArticleImp();

    daoFavoritesImp fav = new daoFavoritesImp();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if (path.equals("/Update.Products")) {

            //System.out.println("voting");
            System.out.println("Votting");
            String article_ID = request.getParameter("article_ID");
            int idClient = UserSession.getID();
            System.out.println("idArticle : " + article_ID);
            System.out.println("idUser: " + idClient);

            try{
                Favorites f = fav.saveFavorite(new Favorites(Integer.parseInt(article_ID), idClient));
                System.out.println("added");
                request.getRequestDispatcher("Products.jsp").forward(request, response);
            }catch(Exception e){}

        //int idArticle = Integer.parseInt(request.getParameter("id"));
           // int idUser =  UserSession.getID();
         //
         //   request.getRequestDispatcher("Products.jsp").forward(request, response);
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path = request.getServletPath();
        if (path.equals("/Show.Products")) {
            List<Articles> articleCarte = null;

            try {
                articleCarte = articles.getAll();
                request.setAttribute("articleCarte", articleCarte);

                request.getRequestDispatcher("Products.jsp").forward(request, response);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}
