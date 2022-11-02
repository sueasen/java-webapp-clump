package dto;

/**
 * {@link UploadFile}
 */
public class UploadFile {

	/** 画像パス */
	private String imgPath;

	/** 音声パス */
	private String audioPath;

	/** 動画パス */
	private String videoPath;

	/**
	 * コンストラクタ
	 */
	public UploadFile() {
	}

	/**
	 * コンストラクタ
	 * @param imgPath 画像パス
	 * @param audioPath 音声パス
	 * @param videoPath 動画パス
	 */
	public UploadFile(String imgPath, String audioPath, String videoPath) {
		this.imgPath = imgPath;
		this.audioPath = audioPath;
		this.videoPath = videoPath;
	}

	/**
	 * @return imgPath
	 */
	public String getImgPath() {
		return imgPath;
	}

	/**
	 * @param imgPath セットする imgPath
	 */
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	/**
	 * @return audioPath
	 */
	public String getAudioPath() {
		return audioPath;
	}

	/**
	 * @param audioPath セットする audioPath
	 */
	public void setAudioPath(String audioPath) {
		this.audioPath = audioPath;
	}

	/**
	 * @return videoPath
	 */
	public String getVideoPath() {
		return videoPath;
	}

	/**
	 * @param videoPath セットする videoPath
	 */
	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}

}
