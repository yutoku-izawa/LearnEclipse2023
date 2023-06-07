package example.com.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import example.com.bean.Director;
import example.com.dao.DirectorDAO;
import example.com.util.ConnectionManager;

@WebServlet("/SearchDirectorServlet")
public class SearchDirectorServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
	throws ServletException, IOException {

		int id = 1;

		try (Connection con = ConnectionManager.getConnection()) {

			DirectorDAO dao = new DirectorDAO(con);

			Director director = dao.selectById(id);

			request.setAttribute("director", director);

		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

		request.getRequestDispatcher("/WEB-INF/jsp/directorDetail.jsp").forward(
				request, response);
	}
}
