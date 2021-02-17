import Beans.Articles;
import dao.ConnectDB;
import dao.daoArticleImp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductsAdmin extends HttpServlet {

    daoArticleImp articles = new daoArticleImp();

    public void init(HttpServletRequest request, HttpServletResponse response){
        
        try {
            List<Articles> articleCarte = articles.getAll();
            request.setAttribute("articleCarte", articleCarte);
            System.out.println(articleCarte.get(0).getNameArticle() );
            request.getRequestDispatcher("ProductsAdmin.jsp").forward(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path = request.getServletPath();
        if(path.equals("/Ajouter.test")){
            System.out.println(ConnectDB.getCon());
            System.out.println("post");
            //Do Some stuff
            //get data
            String nameProduct = request.getParameter("Name");
            String priceProduct = request.getParameter("Price");
            String qteProduct = request.getParameter("Qte");
            String descProduct = request.getParameter("Desc");
            String imageProduct = request.getParameter("fileToUpload");

            //request.getRequestDispatcher(url).forward(request, response);

            try {
                Articles a = articles.saveArticle(new Articles(nameProduct, descProduct, Double.parseDouble(priceProduct), Integer.parseInt(qteProduct),imageProduct ));

                request.getRequestDispatcher("ProductsAdmin.jsp").forward(request, response);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
            response.sendRedirect("all.test");
            //request.getRequestDispatcher("ProductsAdmin.jsp").forward(request, response);
        }
        else if (path.equals("/Update.test")){

            int idArticle = Integer.parseInt(request.getParameter("IdArticle"));
            String nameProduct = request.getParameter("Name");
            String priceProduct = request.getParameter("Price");
            String qteProduct = request.getParameter("Qte");
            String descProduct = request.getParameter("Desc");
            String imageProduct = request.getParameter("fileToUpload");
            System.out.println("hi");
            try {
                articles.updateArticle(new Articles(idArticle,nameProduct, descProduct, Double.parseDouble(priceProduct), Integer.parseInt(qteProduct),imageProduct ));
                request.getRequestDispatcher("ProductsAdmin.jsp").forward(request, response);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }



            response.sendRedirect("all.test");


        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.getRequestDispatcher("ProductsAdmin.jsp").forward(request, response);

        String path = request.getServletPath();
        if(path.equals("/all.test")){
            List<Articles> articleCarte = null;
            System.out.println("all");
            try {
                articleCarte = articles.getAll();
                request.setAttribute("articleCarte",articleCarte);
                System.out.println(articleCarte.get(0).getPrice());
                request.getRequestDispatcher("ProductsAdmin.jsp").forward(request, response);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }catch(Exception e){

                e.printStackTrace();

            }
        }
        if(path.equals("/Delete.test")){
            int idArticle = Integer.parseInt(request.getParameter("id"));
            System.out.println("id" + idArticle);

            try {
                articles.deleteById(idArticle);
                request.getRequestDispatcher("ProductsAdmin.jsp").forward(request, response);
                //response.sendRedirect("Ajouter.test");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            response.sendRedirect("all.test");

        }


        }

}

