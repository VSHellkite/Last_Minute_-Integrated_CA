package backend.sevices;

import backend.models.Movie;
import backend.repository.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class DropMovies {


    public List<Movie> drop(String whatToDrop, int amountOfLines, int offset){

        List<Movie> movieList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String error = null;
        Movie result = null;
        String direction = "";

        matchDrop(whatToDrop);
        if ("shortest".equals(whatToDrop)) {
            direction = "ASC";
        } else {
            direction = "DESC";
        }
        
        
        try {
            conn = Database.getConnection();
            statement = conn.prepareStatement("SELECT * FROM Movies ORDER BY " + String.valueOf(matchDrop(whatToDrop)) + " " + direction + " LIMIT " + String.valueOf(amountOfLines) + " OFFSET " + String.valueOf(offset * amountOfLines));
            resultSet = statement.executeQuery();
            int i = 0;
            while (resultSet.next()) {
                result = new Movie(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDouble(5),
                        resultSet.getString(6),
                        resultSet.getInt(7),
                        resultSet.getString(8),
                        resultSet.getString(9),
                        resultSet.getDouble(10),
                        resultSet.getInt(11),
                        resultSet.getDouble(12)
                );
                movieList.add(result);
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
        return movieList;
    }


    private static String matchDrop(String whatToDrop) {

        String input = whatToDrop;

        String option = null;

        switch (input) {
            case "popularity":
                option = "popularity";
            case "voteAvg":
                option = "voteAvg";
            case "voteCount":
                option = "voteCount";
            case "shortest":
                option = "runtime";
            case "longest":
                option = "runtime";
        }
        return option;
    }


}
