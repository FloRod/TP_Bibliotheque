package fr.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.models.Livre;
import fr.service.LivreService;
import fr.service.LivreServiceInterface;
import fr.utils.DataRecovery;
import fr.utils.JsonConvertor;

/**
 * Servlet implementation class AuteurServlet
 */

@WebServlet("/Livre/*")
public class LivreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LivreServlet() {
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
		LivreServiceInterface livreService = new LivreService();
		System.out.println(request.getPathInfo());
		String json = new String();
		try {
			int id = Integer.parseInt(request.getPathInfo().substring(1));
			Livre livre = new Livre();

			livre = livreService.find(id);
			if (livre == null) {
				response.setStatus(HttpServletResponse.SC_BAD_GATEWAY);
				response.getWriter().write("{\"error\":\"ressource non trouvée\"}");
			} else {
				json = JsonConvertor.convert(livre);
				response.setStatus(HttpServletResponse.SC_OK);
				response.getWriter().write(json);
			}
		} catch (NumberFormatException e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().write("{\"error\":\"saisie invalide\"}");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/json;charset=UTF-8");
		LivreServiceInterface livreService = new LivreService();
		boolean boulException = false;

		try {
			Enumeration<String> enumeration = request.getParameterNames();
			Map<String, String> mapAdd = new HashMap<String, String>();
			while (enumeration.hasMoreElements()) {
				String parametre = enumeration.nextElement();
				mapAdd.put(parametre, request.getParameter(parametre));
			}
			livreService.add(mapAdd);
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_BAD_GATEWAY);
			response.getWriter().write("{\"error\":\"saisie invalide\"}");
			//e.printStackTrace();
			boulException = true;
		}
		if(!boulException){
			response.setStatus(HttpServletResponse.SC_CREATED);
			response.getWriter().write("{\"Code 201\":\"succès - création de l'objet\"}");
		}
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	// Attention, problème de cash => impossible de modifier une valeur après une exception
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/json;charset=UTF-8");
		LivreServiceInterface livreService = new LivreService();
		boolean boulException = false;

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
			String data = br.readLine();

			Map<String, String> mapSplit = DataRecovery.recover(data);
			mapSplit.put("id", request.getPathInfo().substring(1));
			livreService.update(mapSplit);
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_BAD_GATEWAY);
			response.getWriter().write("{\"error\":\"saisie invalide\"}");
			boulException = true;
		}
		if (!boulException){
			response.setStatus(HttpServletResponse.SC_OK);
			response.getWriter().write("{\"Code 200\":\"succès de la requète\"}");
		}
	}
}
