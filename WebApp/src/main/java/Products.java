import Beans.Articles;
import dao.daoArticleImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Products extends HttpServlet {

    daoArticleImp articles = new daoArticleImp();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if (path.equals("/Update.Products")) {
            int idArticle = Integer.parseInt(request.getParameter("id"));
            System.out.println("id" + idArticle);

            request.getRequestDispatcher("Products.jsp").forward(request, response);
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
