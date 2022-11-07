package presentation.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * {@link DBWorkInsertServlet}
 */
@WebServlet("/db_work_insert")
public class DBWorkInsertServlet extends DBWorkServlet {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		service.insert(request.getParameter("name"));
		doGet(request, response);
	}

}
