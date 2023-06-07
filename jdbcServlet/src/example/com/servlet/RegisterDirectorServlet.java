package example.com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import example.com.bean.Director;
import example.com.dao.DirectorDAO;
import example.com.util.ConnectionManager;

@WebServlet("/RegisterDirectorServlet")
public class RegisterDirectorServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int id = 30;
		String name = "三谷 ";
		String birth = "1961-07-08";

		Director director = new Director();
		director.setId(id);
		director.setName(name);
		director.setBirth(Date.valueOf(birth));

		try (Connection con = ConnectionManager.getConnection()) {

			DirectorDAO dao = new DirectorDAO(con);

			dao.insert(director);

		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

		request.getRequestDispatcher("/WEB-INF/jsp/registerDirectorComplete.jsp")
				.forward(request, response);
	}
}
