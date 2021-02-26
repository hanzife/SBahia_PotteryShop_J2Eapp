import Beans.Articles;
import Beans.Users;
import dao.ConnectDB;
import dao.daoArticleImp;
import dao.daoUsers;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignUp extends HttpServlet {

    daoUsers users = new daoUsers();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path = request.getServletPath();
        if (path.equals("/SignUp")) {

            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            try {

                Users u = users.saveUser(new Users(username, email, password));


                request.getRequestDispatcher("Products.jsp").forward(request, response);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            //response.sendRedirect("all.test");
            //request.getRequestDispatcher("ProductsAdmin.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("SignUp.jsp").forward(request, response);

    }
}

