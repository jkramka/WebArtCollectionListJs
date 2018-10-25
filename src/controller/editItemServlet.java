package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListItem;

/**
 * Servlet implementation class editItemServlet
 */
@WebServlet("/editItemServlet")
public class editItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListItemHelper dao = new ListItemHelper();
		//makes sure that there are no fields left blank.
		String artist = request.getParameter("artist");
		if (artist == null) {
			getServletContext().getRequestDispatcher("/edit-item.jsp").forward(request, response);
		}
		String item = request.getParameter("item");
		if (artist == null) {
			getServletContext().getRequestDispatcher("/edit-item.jsp").forward(request, response);
		}
		int year = 0;
		try {
			year = Integer.parseInt(request.getParameter("year"));
		}
		catch (Exception e) {
			getServletContext().getRequestDispatcher("/edit-item.jsp").forward(request, response);
		}
		if (year == 0) {
			getServletContext().getRequestDispatcher("/edit-item.jsp").forward(request, response);
		}
		//Updates the record.
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		ListItem itemToUpdate = dao.searchForItemById(tempId);
		itemToUpdate.setItem(item);
		itemToUpdate.setArtist(artist);
		itemToUpdate.setYear(year);
		dao.updateItem(itemToUpdate);
		getServletContext().getRequestDispatcher("/viewAllItemsServlet").forward(request, response);
	}

}
