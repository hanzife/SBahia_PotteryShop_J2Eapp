import Beans.Users;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import dao.*;

public class login extends HttpServlet {


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
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        List<Users> listUsers = null;


        if(email!="" || password!="") {

            if(!validate_email(email)  || !validate_password(password) ) {
                request.setAttribute("error","email or password incorect");
                System.out.println("email or password incorect format");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }else {

                try {
                    listUsers = users.getAll();

                    for (int i = 0; i < listUsers.size(); i++) {

                        if (listUsers.get(i).getEmail().equals(email) && listUsers.get(i).getPassword().equals(password)) {
                            UserSession.setUserID(listUsers.get(i).getIdUser());
                            response.sendRedirect("Products.jsp");
                            System.out.println(UserSession.getID());
                            //request.getRequestDispatcher("home.jsp").forward(request, response);

                        }
                        else {
                            System.out.println("Account Not Found");
                        }

                    }
                } catch (Exception e) {
                }
            }
        }
        else {
            System.out.println("email or password empty");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("login.jsp").forward(request, response);


    }
}
