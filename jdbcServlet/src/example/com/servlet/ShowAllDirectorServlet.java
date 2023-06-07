package example.com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import example.com.bean.Director;
import example.com.dao.DirectorDAO;
import example.com.util.ConnectionManager;

@WebServlet("/ShowAllDirectorServlet")
public class ShowAllDirectorServlet extends HttpServlet {
	public void doGet(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try (Connection con = ConnectionManager.getConnection()) {

			DirectorDAO dao = new DirectorDAO(con);

			List<Director> directorList = dao.selectAll();

			request.setAttribute("directorList", directorList);

		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

		request.getRequestDispatcher("/WEB-INF/jsp/directorList.jsp").forward(
				request, response);
	}
}
