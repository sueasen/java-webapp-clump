package presentation.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.service.RetroMethodService;

/**
 * {@link SampleMemoServlet}
 */
@WebServlet("/retro_method")
public class RetroMethodServlet extends HttpServlet {


	@SuppressWarnings("unused")
	private RetroMethodService service = new RetroMethodService();

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "/WEB-INF/view/retroMethod.jsp";
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

		if ("1".equals(request.getParameter("workno"))) {
			int input1 = Integer.parseInt(request.getParameter("input11"));
			int input2 = Integer.parseInt(request.getParameter("input12"));
			int input3 = Integer.parseInt(request.getParameter("input13"));
			// TODO
			//			int result = service.work1(input1, input2, input3);
			//			request.setAttribute("result1", result);
			request.setAttribute("input11", input1);
			request.setAttribute("input12", input2);
			request.setAttribute("input13", input3);

		} else if ("2".equals(request.getParameter("workno"))) {
			String input = request.getParameter("input2");
			// TODO
			//			String result = service.work2(input);
			//			request.setAttribute("result2", result);
			request.setAttribute("input2", input);

		} else if ("3".equals(request.getParameter("workno"))) {
			int input = Integer.parseInt(request.getParameter("input3"));
			// TODO
			//			Map<String, Integer> result = service.work3(input);
			//			request.setAttribute("result3", result);
			request.setAttribute("input3", input);

		} else if ("4".equals(request.getParameter("workno"))) {
			String input = request.getParameter("input4");
			// TODO
			//			戻り値型 result = service.work4(引数...);
			//			request.setAttribute("result4", result);
			request.setAttribute("input4", input);
		}

		doGet(request, response);
	}

}
