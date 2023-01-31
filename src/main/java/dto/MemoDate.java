package dto;

import java.util.Date;

/**
 * {@link MemoDate}
 */
public class MemoDate extends Memo {

	/** 作成日 Date型(java.util.Date) 変数名 createDate */
	Date createDate;

	/**
	 * コンストラクタ
	 * @param name 名前
	 * @param message メッセージ
	 */
	public MemoDate(String name, String message) {
		super(name, message);
		this.createDate = new Date();
	}

	/**
	 * createDate を設定します
	 * @param createDate 作成日
	 */
	public void setcCeateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * createDate を取得します
	 * @return createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

}
