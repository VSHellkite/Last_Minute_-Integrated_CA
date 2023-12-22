package backend;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Arrays;


public class SetUp {

    public static void main() {

        String csvFilePath = "C:\\mywork\\src\\Last_Minute_-Integrated_CA\\EirVid\\src\\Movie_Metadata.csv";
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Movies", "admin", "password")) {
            String insertQuery = "INSERT INTO Movies (MovieId, OriginalLanguage, OriginalTitle, Overview, Popularity, ReleseDate, Runtime, Tag, Title, VoteAvg, VoteCount, Price) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (BufferedReader br = new BufferedReader(new InputStreamReader(SetUp.class.getResourceAsStream("../Movie_Metadata.csv"))); PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                int id = 0;
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");

                    System.out.println(Arrays.toString(data));
                    preparedStatement.setInt(1, ++id);
                    preparedStatement.setString(2, data[0]);
                    preparedStatement.setString(3, data[1]);
                    preparedStatement.setString(4, data[2]);
                    preparedStatement.setDouble(5, Double.parseDouble(data[3]));
                    preparedStatement.setDate(6, new java.sql.Date(formatter.parse(data[4]).getTime()));
                    preparedStatement.setInt(7, Integer.parseInt(data[5]));
                    preparedStatement.setString(8, data[6]);
                    preparedStatement.setString(9, data[7]);
                    preparedStatement.setDouble(10, Double.parseDouble(data[8]));
                    preparedStatement.setInt(11, Integer.parseInt(data[9]));
                    preparedStatement.setDouble(12, Double.parseDouble(data[10]));


                    preparedStatement.executeUpdate();
                }

                System.out.println("Data imported successfully!");

            } catch (java.sql.SQLIntegrityConstraintViolationException e) {
                // ignore duplicate entries
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
