package homework3.dataaccess.repository;

import org.springframework.core.io.ClassPathResource;

import javax.management.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.stream.Collectors;

@org.springframework.stereotype.Repository
public class Repository {
    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    String script = read("C:\\Users\\U_M15BZ\\Desktop\\DataAccess\\src\\main\\resources\\Select.sql");

    public String getProductName(String name) throws SQLException {
        Connection conn = DriverManager.getConnection("");
        PreparedStatement prepStmt = conn.prepareStatement(script);
        prepStmt.setString(1, name);
        ResultSet rs = prepStmt.executeQuery();
        return rs.getString(0);
    }

}
