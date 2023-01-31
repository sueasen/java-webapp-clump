package presentation.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

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

    String type = request.getParameter("type");
    if ("man".equals(type)) {
      executeWebApiGetImage(response, new URL("https://randomuser.me/api"),
          json -> json.get("results").get(0).get("picture").get("large"));

    } else if ("cat".equals(type)) {
      executeWebApiGetImage(response, new URL("https://aws.random.cat/meow"),
          json -> json.get("file"));

    } else if ("fox".equals(type)) {
      executeWebApiGetImage(response, new URL("https://randomfox.ca/floof/"),
          json -> json.get("image"));

    } else if ("star".equals(type)) {
      executeWebApiGetImage(response, new URL(
          "https://livlog.xyz/hoshimiru/constellation?lat=35.605&lng=140.123&date=2023-1-18&hour=11&min=0"),
          json -> json.get("result").get(0).get("starImage"));

    }
  }

  /**
   * WebAPI を実行しJSONより画像を取得してレスポンスに設定します
   *
   * @param response レスポンス
   * @param url URL
   * @param jsonFunction json から画像を取得する処理
   */
  void executeWebApiGetImage(HttpServletResponse response, URL url,
      Function<JsonNode, Object> jsonFunction)
      throws IOException {

    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
    urlConnection.setRequestMethod("GET");
    urlConnection.setRequestProperty("User-agent", "Mozilla/5.0");

    try (
        AutoCloseable closeable = () -> urlConnection.disconnect();
        InputStream stream = urlConnection.getInputStream();) {

      ObjectMapper mapper = new ObjectMapper();
      JsonNode json = mapper.readTree(stream);
      Map<String, Object> map = new HashMap<>();
      map.put("image", jsonFunction.apply(json));
      response.getWriter().print(mapper.writeValueAsString(map));

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
