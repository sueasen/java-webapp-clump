package dto;

/**
 * {@link Work}
 */
public class Work {

	/** 入力値 */
	private String input;

	/**
	 * コンストラクタ
	 * @param input 入力値
	 */
	public Work(String input) {
		this.input = input;
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
