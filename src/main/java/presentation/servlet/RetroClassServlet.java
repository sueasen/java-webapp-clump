package presentation.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.service.RetroClassService;
import dto.Memo;
import dto.ShapeArea;

/**
 * {@link SampleMemoServlet}
 */
@WebServlet("/retro_class")
public class RetroClassServlet extends HttpServlet {

	private RetroClassService service = new RetroClassService();

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (null == request.getParameter("workno")) {
			request.getSession().invalidate();
		}
		String view = "/WEB-INF/view/retroClass.jsp";
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
			int input = Integer.parseInt(request.getParameter("input1"));
			ShapeArea result = service.work1(input);
			request.setAttribute("result1", result);
			request.setAttribute("input1", input);

		} else if ("2".equals(request.getParameter("workno"))) {
			String input1 = request.getParameter("input21");
			String input2 = request.getParameter("input22");
			Memo result = service.work2(input1, input2);
			request.setAttribute("result2", result);
			request.setAttribute("input21", input1);
			request.setAttribute("input22", input2);

		} else if ("3".equals(request.getParameter("workno"))) {
			String input1 = request.getParameter("input31");
			String input2 = request.getParameter("input32");
			Memo result = service.work3(input1, input2);
			@SuppressWarnings("unchecked")
			List<Memo> results = Optional.ofNullable((List<Memo>) request.getSession().getAttribute("result3memoDates"))
					.orElse(new ArrayList<>());
			Optional.ofNullable(result).ifPresent(memo -> results.add(memo));
			request.getSession().setAttribute("result3memoDates", results);

		} else if ("4".equals(request.getParameter("workno"))) {
			String input = request.getParameter("input4");
			String result = service.work4(input);
			request.setAttribute("result4", result);
			request.setAttribute("input4", input);
		}

		doGet(request, response);
	}

}
