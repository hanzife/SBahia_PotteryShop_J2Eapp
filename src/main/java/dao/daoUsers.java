package dao;

import Beans.Articles;
import Beans.Users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class daoUsers implements daoUsersImp {

    @Override
    public Users getById(int IdUser) throws ClassNotFoundException, SQLException {

       return null;
    }

    public Users saveUser(Users u) throws ClassNotFoundException, SQLException {

        Users reponse = null;

        int IdUser;
        IdUser = -1;

        String query = "INSERT INTO public.\"Users\"(\"username\", \"email\", \"password\") VALUES (?, ?, ?)";

        PreparedStatement statement = ConnectDB.getCon().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

        statement.setString(1, u.getUsername());
        statement.setString(2, u.getEmail());
        statement.setString(3, u.getPassword());

        statement.executeUpdate();

        ResultSet rs = statement.getGeneratedKeys();

        if (rs.next()) {
            IdUser = rs.getInt(1);
        }
        reponse = new Users(IdUser, u.getUsername(), u.getEmail(), u.getPassword());


        return reponse;
    }

    public List<Users> getAll() throws ClassNotFoundException, SQLException {

        List<Users> users = new ArrayList<Users>();

        Statement statement = ConnectDB.getCon().createStatement();

        ResultSet resultat;

        String requete = "SELECT * FROM public.\"Users\"";

        resultat = statement.executeQuery(requete);

        while (resultat.next()) {

            int IdUser = resultat.getInt("IdUser");
            String username = resultat.getString("username");
            String email = resultat.getString("email");
            String password = resultat.getString("password");

            Users u = new Users(IdUser, username, email, password);


            users.add(u);
        }

        return users;

    }


}
