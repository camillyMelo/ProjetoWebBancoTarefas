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
@WebServlet("/UserTask")
public class UsuarioTarefa extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TarefaDao tdao = new TarefaDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioTarefa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = getServletContext();
		Usuario u = (Usuario) sc.getAttribute("usuario");
		try {
			tdao.getTarefa(u.getId());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("lista_tarefas", tdao.getTarefasUsuario());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/listatarefa.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_tarefa = Integer.parseInt(request.getParameter("id_excluir"));
		
		try {
			tdao.deleteTarefa(id_tarefa);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/tarefa_excluida.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
