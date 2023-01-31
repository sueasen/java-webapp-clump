package presentation.servlet;

import java.io.IOException;
import java.util.function.Consumer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dto.UploadFile;

/**
 * {@link UploadFileServlet}
 */
@WebServlet("/upload_file")
@MultipartConfig
public class UploadFileServlet extends HttpServlet {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "/WEB-INF/view/uploadFile.jsp";
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

		UploadFile dto = new UploadFile();
		fileUpload(request.getPart("img"), (s) -> dto.setImgPath(s));
		fileUpload(request.getPart("audio"), (s) -> dto.setAudioPath(s));
		fileUpload(request.getPart("video"), (s) -> dto.setVideoPath(s));
		request.setAttribute("resultDto", dto);

		doGet(request, response);
	}

	/**
	 * ファイルアップロードしてファイルパスを設定します
	 *
	 * @param part パート
	 * @param consumer ファイルパス設定処理
	 * @throws IOException ファイル書込時の例外
	 */
	private void fileUpload(Part part, Consumer<String> consumer) throws IOException {
		if ("".equals(part.getSubmittedFileName())) {
			return;
		}
		String filePath = "/upload/" + part.getSubmittedFileName();
		part.write(getServletContext().getRealPath(filePath));
		consumer.accept(filePath);
	}
}
