package dto;

/**
 * {@link Memo}
 */
public class Memo {

	/** 名前 String型 変数名 name*/
	String name;

	/** メッセージ String型 変数名 message */
	String message;

	/**
	 * コンストラクタ
	 * @param name 名前
	 * @param message メッセージ
	 */
	public Memo(String name, String message) {
		this.name = name;
		this.message = message;
	}

	/**
	 * name を設定します
	 * @param name 名前
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * message を設定します
	 * @param message メッセージ
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * name を取得します
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * message を取得します
	 * @return message
	 */
	public String getMessage() {
		return message;
	}

}
