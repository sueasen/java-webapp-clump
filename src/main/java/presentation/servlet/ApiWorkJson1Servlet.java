package presentation.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import dto.Memo;

/**
 * {@link ApiWorkJson1Servlet}
 */
@WebServlet("/api_work_json1")
public class ApiWorkJson1Servlet extends HttpServlet {

  /**
   * {@inheritDoc}
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    Object apiData = null;
    if ("map".equals(request.getParameter("type"))) {
      Map<String, Object> map = new HashMap<>();
      map.put("name", "Servlet JSON 返却(Map)");
      map.put("message", "Servlet で JSON 返す Web API を作る（Map利用）");
      apiData = map;

    } else if ("dto".equals(request.getParameter("type"))) {
      Memo dto = new Memo(//
          "Servlet JSON 返却(Dto)", "Servlet で JSON 返す Web API を作る（Dto利用）");
      apiData = dto;
    }

    response.setCharacterEncoding("UTF-8");
    response.setContentType("application/json");
    response.getWriter().print(new ObjectMapper().writeValueAsString(apiData));
  }

}
