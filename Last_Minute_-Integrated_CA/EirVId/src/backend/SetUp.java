
package backend;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


    public class SetUp {
        public static void main() {
        String csvFilePath = "C:\\mywork\\src\\Last_Minute_-Integrated_CA\\EirVid\\src\\Movie_Metadata.csv";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Movies", "admin", "password")) {
            String insertQuery = "INSERT INTO Movies (column1, column2, column3, column4, column5, column6, column7, column8, column9) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath));
                 PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    
                    preparedStatement.setString(1, data[0]);
                    preparedStatement.setString(2, data[1]);
                    preparedStatement.setString(3, data[2]);
                    preparedStatement.setString(4, data[3]);
                    preparedStatement.setString(5, data[4]);
                    preparedStatement.setString(6, data[5]);
                    preparedStatement.setString(7, data[6]);
                    preparedStatement.setString(8, data[7]);
                    preparedStatement.setString(9, data[8]);
                    

                    preparedStatement.executeUpdate();
                }

                System.out.println("Data imported successfully!");

            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
