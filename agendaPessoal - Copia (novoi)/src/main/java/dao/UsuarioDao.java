package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Tarefa;
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
	            .getConnection("jdbc:mysql://localhost:3306/tarefas", "root", "");

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
	 
	
	 
	 public Usuario getUsuario (String l, String s) throws ClassNotFoundException {
			String LOGIN_USERS_SQL = "SELECT  login, senha, nome, email FROM usuarios "
					+ "WHERE login = ? AND senha = ?;";
			Class.forName("com.mysql.jdbc.Driver");
			Usuario loginUsuario = null;
			try (Connection connection = DriverManager.
					getConnection("jdbc:mysql://localhost:3306/tarefas", "root", "");
					
					PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_USERS_SQL)){;
					
					preparedStatement.setString(1, l);
					preparedStatement.setString(2, s);
					
					System.out.println("Entrei");
					
					ResultSet rs1 = preparedStatement.executeQuery();
					if(rs1.next()) {
						System.out.println(rs1.getString("nome"));
						System.out.println(rs1.getString("email"));
						
						loginUsuario = new Usuario();
						loginUsuario.setLogin(rs1.getString("login"));
						loginUsuario.setNome(rs1.getString("nome"));
						loginUsuario.setSenha(rs1.getString("senha"));
						loginUsuario.setEmail(rs1.getString("email"));
						return loginUsuario;
					}
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			return null;
		
		}
	
	 public int ifUsuario(String l, String s) throws ClassNotFoundException {
		 String LOGIN_USERS_SQL = "SELECT  login, senha, nome, email FROM usuarios "
					+ "WHERE login = ? AND senha = ?;";

	        int result = 0;


	        Class.forName("com.mysql.jdbc.Driver");

	        try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/tarefas", "root", "");
	        		PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_USERS_SQL)){;
					
					preparedStatement.setString(1, l);
					preparedStatement.setString(2, s);
					
					System.out.println("Entrei");
					
					ResultSet rs = preparedStatement.executeQuery();
				if(rs.next()) {
					result = 1;
				}

	        } catch (SQLException e) {
	            // process sql exception
	            e.printStackTrace();
	        }
	        return result;
	    }



	public Usuario listUserId(String login) throws ClassNotFoundException {
		Usuario user = new Usuario();
        
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/tarefas", "root", "");
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection
                .prepareStatement("select login, senha, nome, email FROM usuarios where login = ?")) {
                preparedStatement.setString(1, login);

                System.out.println(preparedStatement);
                ResultSet rs = preparedStatement.executeQuery();
                
                while(rs.next()) {
                
                    user.setEmail(rs.getString("email"));
                    user.setLogin(rs.getString("login"));
                    user.setSenha(rs.getString("senha"));
                    user.setNome(rs.getString("nome"));
                    }
         
    
    }catch(SQLException e) {
        e.printStackTrace();
    }
            return user;
	}



}