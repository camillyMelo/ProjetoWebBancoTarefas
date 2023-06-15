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
        	if(usuarioDao.ifUsuario(username, password) == 0) {
        		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/login_erro.jsp");
				dispatcher.forward(request, response);
        	}else {
        		log("teste");
        	}
        
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
			 
			
				try {
					Usuario u = usuarioDao.getUsuario(username, password);	
			//if(u != null) {
				
				request.getSession().setAttribute("usuario", username);
				ServletContext sc = getServletContext();
				sc.setAttribute("login", username);
				sc.setAttribute("senha", password);
				sc.setAttribute("usuario", u);
				
				try {
					tarefadao.getTarefa(u);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//request.setAttribute("lista_tarefas", tarefadao.getTarefasUsuario());
				//ListaTarefa dispatcher = new ListaTarefa();
				//dispatcher.doGet(request, response);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/loginsucess.jsp");
				dispatcher.forward(request, response);
			
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}