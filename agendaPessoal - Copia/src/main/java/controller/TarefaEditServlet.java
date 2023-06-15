package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

import model.Tarefa;
import dao.TarefaDao;

/**
 * Servlet implementation class TarefaEditarServlet
 */
@WebServlet("/TaskEditServlet")
public class TarefaEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TarefaDao tdao = new TarefaDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TarefaEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = (String) request.getSession().getAttribute("usuario");
		if(usuario != null) {
			int id_tarefa = Integer.parseInt(request.getParameter("id_tarefa"));
			ServletContext vc = getServletContext();
			vc.setAttribute("id_tarefa", id_tarefa);
			
			Tarefa tarefa = null;
			try {
				tarefa = tdao.getTarefaEdit(id_tarefa);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			request.setAttribute("titulo", tarefa.getTitulo());
			request.setAttribute("descricao", tarefa.getDescricao());
			request.setAttribute("data_criacao", tarefa.getData_cricao());
			request.setAttribute("data_conclusao", tarefa.getData_conclusao());
			request.setAttribute("status", tarefa.getStatus());
			
			vc.setAttribute("tarefa", tarefa);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/tarefa_editar.jsp");
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/login.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = (String) request.getSession().getAttribute("usuario");
		if(usuario != null) {
			Tarefa t = new Tarefa();
			
			String titulo = request.getParameter("titulo");
			t.setTitulo(titulo);
			String descricao = request.getParameter("descricao");
			t.setDescricao(descricao);
			String data_criacao = request.getParameter("data_criacao");
			String data_conclusao = request.getParameter("data_conclusao");
			String status = request.getParameter("status");
			t.setStatus(status);
			
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
			
			ServletContext sc = getServletContext();
			int id_tarefa = (int) sc.getAttribute("id_tarefa");
			t.setId(id_tarefa);
			
			try {
				tdao.updateTarefa(t);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/tarefa_editada.jsp");
				dispatcher.forward(request, response);
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/login.jsp");
			dispatcher.forward(request, response);
		}
	}

}
