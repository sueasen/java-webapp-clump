package presentation.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.service.WebAppSampleService;
import dto.WebAppSample;

/**
 * {@link SampleMemoServlet}
 */
@WebServlet("/web_app_sample_insert")
public class WebAppSampleInsertServlet extends HttpServlet {

	private WebAppSampleService service = new WebAppSampleService();

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "/WEB-INF/view/webAppSample.jsp";
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

		@SuppressWarnings("unchecked")
		List<WebAppSample> list = (List<WebAppSample>) request.getSession().getAttribute("webAppSamples");
		String name = request.getParameter("name");
		service.insert(list, name);

		doGet(request, response);
	}

}
