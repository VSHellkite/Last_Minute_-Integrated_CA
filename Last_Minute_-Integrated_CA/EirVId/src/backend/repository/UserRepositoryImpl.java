package backend.repository;


import backend.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class UserRepositoryImpl implements UserRepository {

    @Override
    public User login(String userlogin, String password) {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String error = null;
        User result = null;

        try {
            conn = Database.getConnection();

            statement = conn.prepareStatement("SELECT USERID, USERLOGIN, PASSWORD, USERNAME  FROM user where USERLOGIN = ? AND PASSWORD = ?");

            statement.setString(1, userlogin);
            statement.setString(2, password);

            resultSet = statement.executeQuery();

            if (!resultSet.next()) {
                error = "User doesn't exist or invalid credentials provided.";
            } else {
                result = new User(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                );
            }

        } catch (SQLException ex) {
            error = ex.getMessage();

        } finally {
            try {
                resultSet.close();
                statement.close();
                conn.close();
            } catch (NullPointerException | SQLException ex) {
            }
        }

        if (error != null) {
            throw new RuntimeException(error);
        }
        return result;
    }


    @Override
    public boolean isUserExists(String userlogin) {
        return getUser(userlogin) != null;
    }


    @Override
    public User createUser(User newUser) {
        newUser.setUserid(getNextUserId());
        insertUser(newUser);
        return getUser(newUser.getUserlogin());
    }

    private int getNextUserId() {
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String error = null;
        int result = -1;

        try {
            conn = Database.getConnection();
            statement = conn.createStatement();

            resultSet = statement.executeQuery("SELECT max(USERID) FROM user");
            resultSet.next();
            result = resultSet.getInt(1) + 1;

        } catch (SQLException ex) {
            error = ex.getMessage();

        } finally {
            try {
                resultSet.close();
                statement.close();
                conn.close();
            } catch (NullPointerException | SQLException ex) {
            }
        }

        if (error != null) {
            throw new RuntimeException(error);
        }

        return result;
    }


    private void insertUser(User user) {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String error = null;

        try {
            conn = Database.getConnection();

            statement = conn.prepareStatement("insert into user (USERID, USERLOGIN, PASSWORD, NAME, SURNAME, USERROLE) values (?, ?, ?, ?, ?, ?)");
            statement.setInt(1, user.getUserid());
            statement.setString(2, user.getUserlogin());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getUsername());

            statement.executeUpdate();

        } catch (SQLException ex) {
            error = ex.getMessage();

        } finally {
            try {
                resultSet.close();
                statement.close();
                conn.close();
            } catch (NullPointerException | SQLException ex) {
            }
        }

        if (error != null) {
            throw new RuntimeException(error);
        }
    }


    private User getUser(String userlogin) {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String error = null;
        User result = null;

        try {
            conn = Database.getConnection();

            statement = conn.prepareStatement("SELECT USERID, USERLOGIN, PASSWORD, USERNAME from user where USERLOGIN = ?");

            statement.setString(1, userlogin);
            
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                result = new User(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                );
            }

        } catch (SQLException ex) {
            error = ex.getMessage();

        } finally {
            try {
                resultSet.close();
                statement.close();
                conn.close();
            } catch (NullPointerException | SQLException ex) {
            }
        }

        if (error != null) {
            throw new RuntimeException(error);
        }

        return result;

    }


    


}
