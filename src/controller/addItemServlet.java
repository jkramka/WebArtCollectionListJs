package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListItem;

/**
 * Servlet implementation class addItemServlet
 */
@WebServlet("/addItemServlet")
public class addItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// begins by making sure none of the fields are blank.
		String artist = request.getParameter("artist");
		if (artist == null) {
			getServletContext().getRequestDispatcher("/addItem.html").forward(request, response);
		}
		String item = request.getParameter("item");
		if (artist == null) {
			getServletContext().getRequestDispatcher("/addItem.html").forward(request, response);
		}
		int year = 0;
		try {
			year = Integer.parseInt(request.getParameter("year"));
		}
		catch (Exception e) {
			getServletContext().getRequestDispatcher("/addItem.html").forward(request, response);
		}
		if (year == 0) {
			getServletContext().getRequestDispatcher("/addItem.html").forward(request, response);
		}
		//as long as none of the fields are blank it adds the new record.
		ListItem li = new ListItem(artist, item, year);
		ListItemHelper dao = new ListItemHelper();
		dao.insertItem(li);
		getServletContext().getRequestDispatcher("/viewAllItemsServlet").forward(request, response);
	}

}
