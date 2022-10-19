package presentation.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Work;

/**
 * {@link WorkServlet}
 */
@WebServlet("/web_app_work") // URLになるパスの一部
public class WorkServlet extends HttpServlet {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "/WEB-INF/view/work.jsp"; // ブラウザに表示するJSP
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String input1 = request.getParameter("input1");
		request.setAttribute("result1", "入力したのは " + input1);

		request.setAttribute("resultDto", new Work(input1));

		doGet(request, response);
	}
}
