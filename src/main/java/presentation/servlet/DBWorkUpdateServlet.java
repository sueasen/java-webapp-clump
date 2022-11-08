package presentation.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * {@link DBWorkUpdateServlet}
 */
@WebServlet("/db_work_update")
public class DBWorkUpdateServlet extends DBWorkServlet {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		service.update( //
				Integer.parseInt(request.getParameter("id")) //
				, request.getParameter("name") //
				, Integer.parseInt(request.getParameter("version")));
		doGet(request, response);
	}

}
