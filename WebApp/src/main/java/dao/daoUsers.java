package dao;

import Beans.Articles;
import Beans.Users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class daoUsers implements daoUsersImp{

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
        reponse = new Users( IdUser, u.getUsername(), u.getEmail(), u.getPassword());


        return reponse;
    }
}
