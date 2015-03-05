package iss.TourRecommendation.servlet;

import iss.TourRecommendation.dao.LocationDAO;
import iss.TourRecommendation.model.Location;
import iss.TourRecommendation.util.TourUtil;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tour.clips.ClipsServer;
import tour.clips.ClipsServerImplService;

import com.google.gson.Gson;

/**
 * Servlet implementation class RecommendationController
 */
public class RecommendationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RecommendationController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// GEN-FIRST:event_submitActionPerformed
		// TODO add your handling code here:
		System.out.println("*******submitting***********"
				+ request.getParameter("country"));
		ArrayList<String> asians = new ArrayList<String>();
		asians.add("China");
		asians.add("Vietnam");
		asians.add("Singapore");
		asians.add("Indonesia");
		String country = request.getParameter("country");
		if (country == "India")
			; // Do nothing
		else if (asians.contains(country))
			country = "Asia";
		else
			country = "Europe";
		String budgetString = request.getParameter("budget");
		int budget = 0;
		if (budgetString != null)
			budget = Integer.parseInt(budgetString);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/DD/YYYY");
		Date date = null;
		try {
			if (request.getParameter("date") != null)
				date = sdf.parse(request.getParameter("date"));
			if (date == null)
				date = new Date();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String travel_with = request.getParameter("travel_with");

		String preferences = request.getParameter("preferences");
		if (preferences == "Educational Visit")
			preferences = "education";
		else if (preferences == "Heritage")
			preferences = "landmarks";
		List<Location> locations2Visit = new ArrayList<Location>();
		try {

			List<Location> locations = new ArrayList<Location>();
			ClipsServerImplService clipsServerImplService = new ClipsServerImplService();
			ClipsServer clipsServer = clipsServerImplService
					.getClipsServerImplPort();
			List<String> attraction_codes = clipsServer.clipsEngine(country,
					travel_with, TourUtil.getBudgetRange(budget), preferences);

			for (String code : attraction_codes) {
				// Process with hibernate inside here
				Location loc1 = LocationDAO.getLocation(code);
				if (loc1 != null)
					locations2Visit.add(loc1);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("locations", locations2Visit);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}
}
