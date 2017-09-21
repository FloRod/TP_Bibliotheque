package fr.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.models.Auteur;
import fr.service.AuteurService;
import fr.service.AuteurServiceInterface;
import fr.utils.JsonConvertor;

/**
 * Servlet implementation class ListAutServlet
 */
@WebServlet("/Auteurs")
public class ListAuteurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListAuteurServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/json;charset=UTF-8");
		AuteurServiceInterface auteurService = new AuteurService();

		List<Auteur> listAuteur = auteurService.lister();
		String json = JsonConvertor.convert(listAuteur);
		System.out.println(json);

		if (json != null) {
			response.setStatus(HttpServletResponse.SC_OK);
			response.getWriter().write(json);
		} else {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().write(json);
		}
	}

}
