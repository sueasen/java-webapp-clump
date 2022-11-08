package dto;

/**
 * {@link Work}
 */
public class Work {

	/** 入力値 */
	private String input;

	/** ファイルパス */
	private String filePath;

	/**
	 * コンストラクタ
	 * @param input 入力値
	 * @param input ファイルパス
	 */
	public Work(String input, String filePath) {
		this.input = input;
		this.filePath = filePath;
	}

	/**
	 * input を取得します
	 * @return input
	 */
	public String getInput() {
		return input;
	}

	/**
	 * input を設定します
	 * @param input 入力値
	 */
	public void setInput(String input) {
		this.input = input;
	}

	/**
	 * filePath を取得します
	 * @return filePath
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * filePath を設定します
	 * @param filePath ファイルパス
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * てきとうな文字列を返します
	 * @return てきとうな文字列
	 */
	public String tekito() {
		return "てきとうすぎる...";
	}

	/**
	 * てきとうな文字列を返します
	 * @return てきとうな文字列
	 */
	public String tekito(String tekito) {
		return "てきとうすぎる...引数..." + tekito + "...入力..." + input;
	}
}
