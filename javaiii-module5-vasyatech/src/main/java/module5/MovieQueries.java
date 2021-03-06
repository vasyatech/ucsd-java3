package module5;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MovieQueries {
	private static final String URL = "jdbc:derby:Example;create=true";
	private Connection connection;
	private ResultSet res = null;
	private Statement stmt = null;
	List<Movie> movies;

	public MovieQueries() {
		try {
			System.out.println("Connecting to database URL: " + URL);
			connection = DriverManager.getConnection(URL);
			
		    stmt = connection.createStatement();
			try {
			    res = stmt.executeQuery("Select * From movies");
			}
			catch (SQLException sqlException) {
				resetExampleDatabase();
				res = stmt.executeQuery("Select * From movies");
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}
	
	private int getNextId() throws SQLException {
		try {
			res = stmt.executeQuery("Select max(id) maxId From movies");
			res.next();
			return res.getInt("maxId") + 1;
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return 0;
	}
	
	ObservableList<Movie> getMovies() throws SQLException{
		res = stmt.executeQuery("Select * From movies");
		movies = new ArrayList<Movie>();
		while (res.next()) {
			Movie movie = new Movie();
			movie.setId(res.getInt("id"));
			movie.setName(res.getString("name"));
			movie.setRating(res.getInt("rating"));
			movie.setDescription(res.getString("description"));
			movies.add(movie);
		}
		ObservableList<Movie> observableList = FXCollections.observableList(movies);
		return observableList;
	}
	
	void resetExampleDatabase() {
		try {
			stmt.execute("DROP TABLE movies"); 
			System.out.println("Creating Table - This will throw an exception if the table is already created.");
			stmt.execute("CREATE TABLE movies (" + "id INTEGER PRIMARY KEY," + "name VARCHAR(255)," + "rating INTEGER,"+ "description VARCHAR(255))");
			System.out.println("adding values into movies table");
			stmt.executeUpdate("INSERT INTO movies VALUES (1, 'Maleficent', 7, '2014 Fantasy/Adventure 1h 38m')");
			stmt.executeUpdate("INSERT INTO movies VALUES (2, 'Elvira: Mistress of the Dark', 6, '1988 Comedy/Horror 1h 36m')");
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}
	
	public void addMovie(String name, int rating, String description) throws SQLException {
		PreparedStatement pstmt = connection.prepareStatement("INSERT INTO movies VALUES (?,?,?,?)");
		int nextId = getNextId();
		pstmt.setInt(1, nextId);
		pstmt.setString(2, name);
		pstmt.setInt(3, rating);
		pstmt.setString(4, description);
		pstmt.executeUpdate();
	}

	public void close() {
		try {
			connection.close();
		} catch (SQLException sqlExeption) {
			sqlExeption.printStackTrace();
		}
	}
}
