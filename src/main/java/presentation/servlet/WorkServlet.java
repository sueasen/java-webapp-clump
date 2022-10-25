package presentation.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dto.Work;

/**
 * {@link WorkServlet}
 */
@WebServlet("/web_app_work") // URLになるパスの一部
@MultipartConfig
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

		Part part = request.getPart("file1");
		String filePath = "/upload/" + part.getSubmittedFileName();

		part.write(getServletContext().getRealPath(filePath));

		//実際にファイルが保存されるパス確認
		System.out.println(filePath);
		System.out.println(getServletContext().getRealPath(filePath));
		request.setAttribute("resultDto", new Work(input1, filePath));

		doGet(request, response);
	}
}
