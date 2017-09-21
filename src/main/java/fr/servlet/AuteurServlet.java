package fr.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.models.Auteur;
import fr.service.AuteurService;
import fr.service.AuteurServiceInterface;
import fr.utils.DataRecovery;
import fr.utils.JsonConvertor;

/**
 * Servlet implementation class AuteurServlet
 */

@WebServlet("/Auteur/*")
public class AuteurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AuteurServlet() {
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
		System.out.println(request.getPathInfo());

		if (request.getPathInfo() == null) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		} else {
			int id = Integer.parseInt(request.getPathInfo().substring(1));
			Auteur auteur = auteurService.find(id);
			String json = JsonConvertor.convert(auteur);
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AuteurServiceInterface auteurService = new AuteurService();
		Auteur nouvelAuteur = new Auteur();
		nouvelAuteur.setNom(request.getParameter("nom"));
		nouvelAuteur.setPrenom(request.getParameter("prenom"));
		nouvelAuteur.setLangue(request.getParameter("langue"));
		System.out.println(nouvelAuteur.getNom() + " " + nouvelAuteur.getPrenom() + ", " + nouvelAuteur.getLangue());
		auteurService.save(nouvelAuteur);
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		AuteurServiceInterface auteurService = new AuteurService();
		System.out.println(request.getPathInfo());

		if (request.getPathInfo() == null) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		} else {
			int id = Integer.parseInt(request.getPathInfo().substring(1));
			Auteur auteur = auteurService.find(id);
			BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
			String data = br.readLine();
			System.out.println(data);
			
			List<Auteur>
			DataRecovery.recover(data, auteur);
//			String[] tabSplit = data.split("=|&");
//			for (int i=0; i<tabSplit.length; i++){
//				System.out.println(tabSplit[i]);
//			}
//			Field[] tabField = auteur.getClass().getDeclaredFields();
			for (int i=0; i<tabField.length; i++){
				System.out.println(tabField[i].getName());
			}
	//	Auteur auteurToUpdate = find
		}
	}

}
