import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OracleUserDao implements UserDao {

	Connection connection;

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public User searchByUsername(String username) {
		String sql = "SELECT * FROM USER WHERE FIRSTNAME=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				User user = new User();
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
