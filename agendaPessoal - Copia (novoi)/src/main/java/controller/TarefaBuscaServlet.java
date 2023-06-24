package controller;

import java.io.IOException;
import java.util.List;
import model.Tarefa;
import model.Usuario;
import dao.TarefaDao;
import dao.UsuarioDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns= {"/search"})
	public class TarefaBuscaServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
		UsuarioDao tdao = new UsuarioDao();
		TarefaDao ttdao = new TarefaDao();
		GlobalFunctions globalFunction = new GlobalFunctions();
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public TarefaBuscaServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
				if(globalFunction.checkSession(request, response)) {
					String usuario = (String) request.getSession().getAttribute("usuario");
					if(usuario == null) {
						System.out.print("usuário null");
					}
					ServletContext sc = getServletContext();
					Usuario user = (Usuario) sc.getAttribute("usuario");
				String search = request.getParameter("search");
				//HttpSession session=request.getSession(false);  
				String userid=(String)sc.getAttribute("login"); 			
						
				    try {
						user = tdao.listUserId(userid);
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
				
				try {
					List<Tarefa> agenda = ttdao.searchActivities(user.getLogin(),search);
					request.setAttribute("lista_tarefas", agenda);
					 RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/listatarefa.jsp");
				     dispatcher.forward(request, response);
				}catch(ClassNotFoundException e) {
					e.printStackTrace();
				}
				}else {
					 RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/login.jsp");
				     dispatcher.forward(request, response);
				}
			} catch (ClassNotFoundException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
				if(globalFunction.checkSession(request, response)) {
					doGet(request, response);
					}else {
						 RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/login.jsp");
					     dispatcher.forward(request, response);
					}
			} catch (ClassNotFoundException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}