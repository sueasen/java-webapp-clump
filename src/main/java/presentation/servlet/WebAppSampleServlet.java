package presentation.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.service.WebAppSampleService;

/**
 * {@link SampleMemoServlet}
 */
@WebServlet("/web_app_sample")
public class WebAppSampleServlet extends HttpServlet {

	private WebAppSampleService service = new WebAppSampleService();

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().invalidate();
		request.getSession().setAttribute("webAppSamples", service.createList());
		String view = "/WEB-INF/view/webAppSample.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	//	/**
	//	 * {@inheritDoc}
	//	 */
	//	@Override
	//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	//			throws ServletException, IOException {
	//
	//		request.setCharacterEncoding("UTF-8");
	//
	//		if ("1".equals(request.getParameter("workno"))) {
	//			int input = Integer.parseInt(request.getParameter("input1"));
	//			int target = new Random().nextInt(10);
	//			String result = service.work1(target, input);
	//			request.setAttribute("result1", result);
	//			request.setAttribute("input1", input);
	//			request.setAttribute("target1", target);
	//
	//		} else if ("2".equals(request.getParameter("workno"))) {
	//			int input = Integer.parseInt(request.getParameter("input2"));
	//			String result = service.work2(input);
	//			request.setAttribute("result2", result);
	//			request.setAttribute("input2", input);
	//
	//		} else if ("3".equals(request.getParameter("workno"))) {
	//			Random random = new Random();
	//			int input = Integer.parseInt(request.getParameter("input3"));
	//			List<Integer> targets = Arrays.asList(random.nextInt(33) + 1, random.nextInt(33) + 1,
	//					random.nextInt(33) + 1);
	//			String result = service.work3(targets, input);
	//			request.setAttribute("result3", result);
	//			request.setAttribute("input3", input);
	//			request.setAttribute("targets3", targets);
	//
	//		} else if ("4".equals(request.getParameter("workno"))) {
	//			String input = request.getParameter("input4");
	//			String result = service.work4(input);
	//			request.setAttribute("result3", result);
	//			request.setAttribute("input3", input);
	//		}
	//
	//		doGet(request, response);
	//	}

}
