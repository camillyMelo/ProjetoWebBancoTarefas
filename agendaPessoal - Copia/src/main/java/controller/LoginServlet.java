package controller;
import java.io.IOException;

import dao.TarefaDao;
import dao.UsuarioDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsuarioDao usuarioDao = new UsuarioDao();
	TarefaDao tarefadao = new TarefaDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/login.jsp");
		dispatcher.forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        String username = request.getParameter("login");
        String password = request.getParameter("senha");
      
        try {
			Usuario u = usuarioDao.getIdUsuario(username, password);
			if(u != null) {
				
				ServletContext sc = getServletContext();
				sc.setAttribute("login", username);
				sc.setAttribute("password", password);
				sc.setAttribute("usuario", u);
				
				try {
					tarefadao.getTarefa(u.getId());
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 request.setAttribute("username", username);    
				 request.setAttribute("password", password);
				
				Tarefas dispatcher = new Tarefas();
				dispatcher.doGet(request, response);
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/login_erro.jsp");
				dispatcher.forward(request, response);
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}

    
	}

}