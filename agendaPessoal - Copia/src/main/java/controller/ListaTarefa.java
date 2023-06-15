package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;

import java.io.IOException;

import dao.TarefaDao;
/**
 * Servlet implementation class UsuarioTarefa
 */
@WebServlet("/listatarefa")
public class ListaTarefa extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TarefaDao tdao = new TarefaDao();
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaTarefa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String usuario = (String) request.getSession().getAttribute("usuario");
	//	if(usuario != null) {
			ServletContext sc = getServletContext();
			Usuario u = (Usuario) sc.getAttribute("usuario");
			try {
				tdao.getTarefa(u);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("lista_tarefas", tdao.getTarefasUsuario());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/listatarefa.jsp");
			dispatcher.forward(request, response);
	//	} else {
		//	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/login.jsp");
		//	dispatcher.forward(request, response);
		//}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usuario = (String) request.getSession().getAttribute("usuario");
		//if(usuario != null) {
			int id_tarefa = Integer.parseInt(request.getParameter("id_excluir"));
			
			try {
				tdao.deleteTarefa(id_tarefa);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/tarefa_deletar.jsp");
				dispatcher.forward(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//}else {
		//	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/login.jsp");
		//	dispatcher.forward(request, response);
		//}
	}

}
