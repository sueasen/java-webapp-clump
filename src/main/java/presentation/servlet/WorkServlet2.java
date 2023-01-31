package presentation.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * {@link WorkServlet2}
 */
@WebServlet("/web_app_work2")
@MultipartConfig
public class WorkServlet2 extends HttpServlet {

  /**
   * {@inheritDoc}
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String view = "/WEB-INF/view/work.jsp";
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

    Part part = request.getPart("file1");
    request.getSession().setAttribute("imgBytes", readAllBytes(part.getInputStream()));
    doGet(request, response);
  }

  /**
   * InputStreamをByte配列にする
   *
   * @param inputStream inputStream
   * @return Byte配列
   * @throws IOException
   */
  public byte[] readAllBytes(InputStream inputStream) throws IOException {
    ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    int nRead;
    byte[] data = new byte[16777215];
    while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
      buffer.write(data, 0, nRead);
    }
    return buffer.toByteArray();
  }
}
