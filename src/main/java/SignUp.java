import Beans.Users;
import dao.daoUsers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUp extends HttpServlet {

    daoUsers users = new daoUsers();


    public  boolean validate_email(String email) {
        Pattern regex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = regex.matcher(email);
        return matcher.find();
    }

    //Password Validation
    public boolean validate_password(String password) {
        boolean test = true;
        if(password.length() < 8){ //Must be at least 8 characters
            test = false;
        }
        return test;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path = request.getServletPath();
        if (path.equals("/SignUp")) {

            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            if(email!="" || password!="" ||  username!="") {


                if (!validate_email(email)) {
                    request.setAttribute("errorEmail", "email Must contain @ and a domaine");
                    //System.out.println("email or password incorect format");
                    request.getRequestDispatcher("SignUp.jsp").forward(request, response);
                } else if (!validate_password(password)) {
                    request.setAttribute("errorPassword", "Password Must be at least 8 characters");
                    request.getRequestDispatcher("SignUp.jsp").forward(request, response);
                } else {

                    try {

                        Users u = users.saveUser(new Users(username, email, password));


                        request.getRequestDispatcher("login.jsp").forward(request, response);
                    } catch (SQLException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    //response.sendRedirect("all.test");
                    //request.getRequestDispatcher("ProductsAdmin.jsp").forward(request, response);
                }
            }
            else{
                request.getRequestDispatcher("SignUp.jsp").forward(request, response);
                request.setAttribute("errorEmpty", "*");
                System.out.println("*");

            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("SignUp.jsp").forward(request, response);

    }
}

