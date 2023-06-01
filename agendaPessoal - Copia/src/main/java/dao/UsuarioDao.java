package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Usuario;

public class UsuarioDao {
	
	 public int registerUsuario(Usuario usuario) throws ClassNotFoundException {
	        String INSERT_USERS_SQL = "INSERT INTO usuarios" +
	            "  ( login, nome, senha, email) VALUES " +
	            " ( ?, ?, ?, ?);";

	        int result = 0;
	       // id = id + 1;

	        Class.forName("com.mysql.jdbc.Driver");

	        try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/employees", "root", "");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
	           // preparedStatement.setInt(1, id); mudei o banco para auto increment
	            preparedStatement.setString(1, usuario.getLogin());
	            preparedStatement.setString(2, usuario.getNome());
	            preparedStatement.setString(3, usuario.getSenha());
	            preparedStatement.setString(4, usuario.getEmail());

	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            result = preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            // process sql exception
	            e.printStackTrace();
	        }
	        return result;
	    }
	 
	 public int getLoginUsuario(String l, String s) throws ClassNotFoundException {
	        String SELECT_USERS_SQL = "SELECT id, nome, email from usuarios" +
	            "  WHERE login = ? AND senha = ?;";

	        int result = 0;

	        Class.forName("com.mysql.jdbc.Driver");

	        try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/employees", "root", "");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERS_SQL)) {
	        	preparedStatement.setString(1, l);
	            preparedStatement.setString(2, s);
	            

	            ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
					System.out.println(rs.getString("id"));
					System.out.println(rs.getString("nome"));
					System.out.println(rs.getString("email"));
		
					result = 1;
				}

	        } catch (SQLException e) {
	            // process sql exception
	            e.printStackTrace();
	        }
	        return result;
	    }
	 
	 public Usuario getIdUsuario (String l, String s) throws ClassNotFoundException {
			String LOGIN_USERS_SQL = "SELECT id, nome, email FROM usuarios "
					+ "WHERE login = ? AND senha = ?;";
			Class.forName("com.mysql.jdbc.Driver");
			
			try (Connection connection = DriverManager.
					getConnection("jdbc:mysql://localhost:3306/employees", "root", "");
					
					PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_USERS_SQL)){;
					
					preparedStatement.setString(1, l);
					preparedStatement.setString(2, s);
					
					System.out.println("Entrei");
					
					ResultSet rs1 = preparedStatement.executeQuery();
					while (rs1.next()) {
						System.out.println(rs1.getString("id"));
						System.out.println(rs1.getString("nome"));
						System.out.println(rs1.getString("email"));
						
						Usuario loginUsuario = new Usuario();
						loginUsuario.setNome(rs1.getString("nome"));
						loginUsuario.setId(rs1.getInt("id"));
						loginUsuario.setEmail(rs1.getString("email"));
						return loginUsuario;
					}
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			return null;
		}


}