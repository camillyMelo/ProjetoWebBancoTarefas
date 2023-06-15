package controller;

import java.io.IOException;
import java.text.ParseException;

import dao.TarefaDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Tarefa;
import model.Usuario;

/**
 * Servlet implementation class DadosEmpregado
 */
@WebServlet("/novatarefa")
public class TarefasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TarefaDao tdao = new TarefaDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TarefasServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = (String) request.getSession().getAttribute("usuario");
		//if(usuario != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/novatarefa.jsp");
			dispatcher.forward(request, response);
		//} else {
		//	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/login.jsp");
		//	dispatcher.forward(request, response);
		//}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String usuario = (String) request.getSession().getAttribute("usuario");
		//if(usuario != null) {
		String titulo = request.getParameter("titulo");
		String descricao = request.getParameter("descricao");
		String data_criacao = request.getParameter("data_criacao");
		String data_conclusao = request.getParameter("data_conclusao");
		String status = request.getParameter("status");
		
		Tarefa t = new Tarefa();
		t.setTitulo(titulo);
		t.setDescricao(descricao);
		t.setStatus(status);
		
		ServletContext sc = getServletContext();
		Usuario u = (Usuario) sc.getAttribute("usuario");
		t.setUsuario(u);
		
		java.text.DateFormat fmt = new java.text.SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date data_criacaoSQL;
		try {
			data_criacaoSQL = new java.sql.Date(fmt.parse(data_criacao).getTime());
			t.setData_cricao(data_criacaoSQL);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Date data_conclusaoSQL;
		try {
			data_conclusaoSQL = new java.sql.Date(fmt.parse(data_conclusao).getTime());
			t.setData_conclusao(data_conclusaoSQL);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		try {
			tdao.registerTarefa(t);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			tdao.getTarefa(u);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("lista_tarefas", tdao.getTarefasUsuario());
		request.setAttribute("usuario", u);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/listatarefa.jsp");
		dispatcher.forward(request, response);
	//}else {
	//	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/login.jsp");
	//	dispatcher.forward(request, response);
	//}
}
	}


