package presentation.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * {@link SampleServlet}
 */
@WebServlet("/sample")
public class SampleServlet extends HttpServlet {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "/WEB-INF/view/sample.jsp";
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
		log("************************************ param");
		request.getParameterMap().entrySet()
				.forEach(e -> log(e.getKey() + ":" + Arrays.toString(e.getValue())));
		System.out.println("************************************ atr");
		Collections.list(request.getAttributeNames()).stream()
				.forEach(s -> log(s + ":" + request.getAttribute(s)));
		System.out.println("************************************ atr session");
		Collections.list(request.getSession().getAttributeNames()).stream()
				.forEach(s -> log(s + ":" + request.getSession().getAttribute(s)));
		Collections.list(request.getParameterNames()).forEach(n -> request.setAttribute(n, request.getParameter(n)));

		doGet(request, response);
	}
}
