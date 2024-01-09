import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "testtest";

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sqlRequest());
            while (resultSet.next()) {
                System.out.println(resultSet.getString("course_name") + " - " + resultSet.getString("average"));
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String sqlRequest() {
        return "SELECT course_name,  count(course_name) / (max(month(subscription_date)) - min(month(subscription_date)) + 1) as average" +
                " FROM skillbox.purchaselist" +
                " WHERE year(subscription_date) = 2018" +
                " group by course_name";
    }
}
