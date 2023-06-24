package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Tarefa;
import model.Usuario;


public class TarefaDao {
ArrayList<Tarefa> tarefasUsuario = new ArrayList<Tarefa>();
	
	public ArrayList<Tarefa> getTarefasUsuario() {
		return tarefasUsuario;
	}
	 public int registerTarefa(Tarefa tarefa) throws ClassNotFoundException {
	        String INSERT_USERS_SQL = "INSERT INTO tarefa" +
	            "  ( titulo, descricao, status, data_criacao, data_conclusao, login_usuario) VALUES " +
	            " ( ?, ?, ?, ?, ?, ?);";

	        int result = 0;
	       // id = id + 1;

	        Class.forName("com.mysql.jdbc.Driver");

	        try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/tarefas", "root", "");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
	           // preparedStatement.setInt(1, id); mudei o banco para auto increment
	            preparedStatement.setString(1, tarefa.getTitulo());
	            preparedStatement.setString(2, tarefa.getDescricao());
	            preparedStatement.setString(3, tarefa.getStatus());
	            preparedStatement.setDate(4, (Date) tarefa.getData_cricao());
	            preparedStatement.setDate(5, (Date) tarefa.getData_conclusao());
	            preparedStatement.setString(6, tarefa.getUsuario().getLogin());
	            
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            result = preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            // process sql exception
	            e.printStackTrace();
	        }
	        return result;
	    }
	 
	 public void getTarefa ( Usuario usuario) throws ClassNotFoundException {
		 tarefasUsuario.clear();
			String TAREFA_USERS_SQL = "SELECT * FROM tarefa "
					+ "WHERE login_usuario = ?;";
			Class.forName("com.mysql.jdbc.Driver");
			
			try (Connection connection = DriverManager.
					getConnection("jdbc:mysql://localhost:3306/tarefas", "root", "");
					
					PreparedStatement preparedStatement = connection.prepareStatement(TAREFA_USERS_SQL)){;
					
					preparedStatement.setString(1, usuario.getLogin());
					
					System.out.println(preparedStatement);
					int check = 0;
					ResultSet rs1 = preparedStatement.executeQuery();
					while (rs1.next()) {
						System.out.println(rs1.getString("id"));
						System.out.println(rs1.getString("titulo"));
						System.out.println(rs1.getString("descricao"));
						System.out.println(rs1.getString("status"));
						System.out.println(rs1.getString("data_criacao"));
						System.out.println(rs1.getString("data_conclusao"));
						
						Tarefa tarefa = new Tarefa();
						tarefa.setTitulo(rs1.getString("titulo"));
						tarefa.setId(rs1.getInt("id"));
						tarefa.setDescricao(rs1.getString("descricao"));
						tarefa.setStatus(rs1.getString("status"));
						tarefa.setData_cricao(rs1.getDate("data_criacao"));
						tarefa.setData_conclusao(rs1.getDate("data_conclusao"));
						tarefa.setUsuario(usuario);
						//tarefasUsuario.add(tarefa);
						//return tarefa;
						for(Tarefa t : tarefasUsuario) {
		        			if(t.getId() == tarefa.getId()) {
		        				check = 1;
		        			}
		        		}
		        		if(check == 0) {
		        			tarefasUsuario.add(tarefa);
		        		}
					}
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			//return null;
		}
	 
	 public Tarefa getTarefaEdit(int id_tarefa) throws ClassNotFoundException {
			String TAREFA_USERS_SQL = "SELECT * FROM tarefa WHERE id = ?";
	        
	        Class.forName("com.mysql.jdbc.Driver");
	        
	        Tarefa t = null;
	        
	        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tarefas", "root", "");
	        	PreparedStatement preparedStatement = connection.prepareStatement(TAREFA_USERS_SQL)){
	        	preparedStatement.setInt(1, id_tarefa);
	        	System.out.println(preparedStatement);
	        	
	        	ResultSet rs = preparedStatement.executeQuery();
	        	if(rs.next()) {
	        		t = new Tarefa();
	        		t.setId(rs.getInt("id"));
	        		t.setTitulo(rs.getString("titulo"));
	        		t.setDescricao(rs.getString("descricao"));
	        		t.setData_cricao(rs.getDate("data_criacao"));
	        		t.setData_conclusao(rs.getDate("data_conclusao"));
	        		t.setStatus(rs.getString("status"));
	        	}
	        }catch(SQLException ex) {
	        	ex.printStackTrace();
	        }
	        
	        return t;
		}
		
		public void updateTarefa(Tarefa t) throws ClassNotFoundException {
			 String UPDATE_SQL = "UPDATE tarefa SET titulo = ?, descricao = ?, data_criacao = ?, data_conclusao = ?, status = ? WHERE id = ?";
		        
		        Class.forName("com.mysql.jdbc.Driver");
		        
		        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tarefas", "root", "");
		        	PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL)){
		        	preparedStatement.setString(1, t.getTitulo());
		        	preparedStatement.setString(2, t.getDescricao());
		        	preparedStatement.setDate(3, (Date) t.getData_cricao());
		        	preparedStatement.setDate(4, (Date) t.getData_conclusao());
		        	preparedStatement.setString(5, t.getStatus());
		        	preparedStatement.setInt(6, t.getId());
		        	System.out.println(preparedStatement);
		        	
		        	preparedStatement.executeUpdate();
		        	
		        }catch(SQLException e) {
		        	e.printStackTrace();
		        }
		}
		

	 public void deleteTarefa(int id) throws ClassNotFoundException{
	        String DELETE_SQL = "DELETE FROM tarefa WHERE id = ?";
	        
	        Class.forName("com.mysql.jdbc.Driver");
	        
	        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tarefas", "root", "");
	        	PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL)){
	        	preparedStatement.setInt(1, id);
	        	System.out.println(preparedStatement);
	        	
	        	preparedStatement.executeUpdate();
	        	
	        }catch(SQLException e) {
	        	e.printStackTrace();
	        }
}

		public List<Tarefa> searchActivities(String id, String search) throws ClassNotFoundException {
			 List<Tarefa> agenda = new ArrayList<Tarefa>();
		        
		        String SEARCH_USER_SQL = "SELECT * FROM tarefa WHERE login_usuario = ? AND ((descricao LIKE '%"+ search + "%') OR (titulo LIKE '%"+ search +"%'))";
		        
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        
		        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tarefas", "root", "");
		                
		                PreparedStatement preparedStatement = connection
		                        .prepareStatement(SEARCH_USER_SQL)){
		            
		            preparedStatement.setString(1, id);
		            
		            System.out.println(preparedStatement);
		            ResultSet rs = preparedStatement.executeQuery();

		            while(rs.next()) {
		            	Tarefa tarefa = new Tarefa();
						tarefa.setTitulo(rs.getString("titulo"));
						tarefa.setId(rs.getInt("id"));
						tarefa.setDescricao(rs.getString("descricao"));
						tarefa.setStatus(rs.getString("status"));
						tarefa.setData_cricao(rs.getDate("data_criacao"));
						tarefa.setData_conclusao(rs.getDate("data_conclusao"));
					//	tarefa.setUsuario(usuario);
		                agenda.add(tarefa);
		                }
		            
		        }catch(SQLException e) {
		            e.printStackTrace();
		        }
		        
		        return agenda;
		}
		 
}
