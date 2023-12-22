
package backend.repository;

import backend.models.UsersMovies;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


    public class UsersMoviesRepositoryImpl implements UsersMoviesRepository{
    Connection conn = null;
    PreparedStatement statement = null;
    String error = null;


    public void listMovies(List <UsersMovies> usersMovieList) {
        
      
        for(int i = 0; i < usersMovieList.size(); i++ ){
            UsersMovies currnetMovie = usersMovieList.get(i);
            System.out.println(i + " "+ currnetMovie.getTitle());
        }
      
    }
    
    public void rentMovie(int userId, int movieId, String title, int vote) {
        try{
        conn = Database.getConnection();
        statement = conn.prepareStatement("INSERT INTO UserMovieList (UserId, MovieId, Title, UserVote) values (?, ?, ?, ?)");
            statement.setInt(1, userId);
            statement.setInt(2, movieId);
            statement.setString(3, title);
            statement.setInt(4, vote);

            statement.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        } finally {
            try {
                statement.close();
                conn.close();
            } catch (NullPointerException | SQLException ex) {
            }
        }

        
    }
    }

    

