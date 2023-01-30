package presentation.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * {@link ApiWorkJson2Servlet}
 */
@WebServlet("/api_work_json2")
public class ApiWorkJson2Servlet extends HttpServlet {

  /**
   * {@inheritDoc}
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    URL url = new URL("https://randomuser.me/api");
    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
    urlConnection.setRequestMethod("GET");

    try (
        AutoCloseable closeable = () -> urlConnection.disconnect();
        InputStream stream = urlConnection.getInputStream();) {

      JsonNode json = new ObjectMapper().readTree(stream);
      response.setCharacterEncoding("UTF-8");
      response.setContentType("application/json");
      response.getWriter().print(json);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
