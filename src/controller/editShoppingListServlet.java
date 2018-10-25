package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListItem;

/**
 * Servlet implementation class editShoppingListServlet
 */
@WebServlet("/editShoppingListServlet")
public class editShoppingListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editShoppingListServlet() {
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
		String act = request.getParameter("doThisToItem");
		if (act == null) {
		 //no button has been selected
		getServletContext().getRequestDispatcher("/viewAllItemsServlet").forward(request, response);
		} else if (act.equals("Delete Selected Item")) {
			int tempId = 0;
			try {
			    tempId = Integer.parseInt(request.getParameter("id"));
			}
			catch (Exception e) {
				getServletContext().getRequestDispatcher("/viewAllItemsServlet").forward(request, response);
			}
			ListItem itemToDelete = dao.searchForItemById(tempId);
			dao.deleteItem(itemToDelete);
			getServletContext().getRequestDispatcher("/viewAllItemsServlet").forward(request, response);
		} else if (act.equals("Edit Selected Item")) {
			int tempId = 0;
			try {
			    tempId = Integer.parseInt(request.getParameter("id"));
			}
			catch (Exception e) {
				getServletContext().getRequestDispatcher("/viewAllItemsServlet").forward(request, response);
			}
			ListItem itemToEdit = dao.searchForItemById(tempId);
			request.setAttribute("itemToEdit", itemToEdit);
			getServletContext().getRequestDispatcher("/edit-item.jsp").forward(request, response);
		} else if (act.equals("Add New Item")) {
		getServletContext().getRequestDispatcher("/addItem.html").forward(request, response);
		}
	}

}
