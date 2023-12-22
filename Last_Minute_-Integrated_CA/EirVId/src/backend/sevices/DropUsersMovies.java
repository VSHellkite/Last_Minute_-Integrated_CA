
package backend.sevices;


import backend.models.UsersMovies;
import backend.repository.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

    public class DropUsersMovies {

        
        public List<UsersMovies> drop(int userId){

        List<UsersMovies> usersMovieList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String error = null;
        UsersMovies result = null;
        String direction = "";

        
        try {
            conn = Database.getConnection();
            statement = conn.prepareStatement("SELECT * FROM UserMovieList WHERE USERID = ?");
            statement.setInt(1, userId);
            resultSet = statement.executeQuery();
            int i = 0;
            while (resultSet.next()) {
                result = new UsersMovies(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getString(3),
                        resultSet.getInt(4)
                                        );
                usersMovieList.add(result);
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
        return usersMovieList;
        } 
        }
        
