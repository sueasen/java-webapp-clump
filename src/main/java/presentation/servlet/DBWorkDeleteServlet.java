package presentation.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * {@link DBWorkDeleteServlet}
 */
@WebServlet("/db_work_delete")
public class DBWorkDeleteServlet extends DBWorkServlet {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		service.delete( //
				Integer.parseInt(request.getParameter("id")) //
				, Integer.parseInt(request.getParameter("version")));
		doGet(request, response);
	}

}
