import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQLJDBC {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:8080/calculadora";
        String user = "postgres";
        String password = "postgres";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa a la base de datos PostgreSQL!");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos PostgreSQL");
            e.printStackTrace();
        }
    }
}