package dto;

import java.util.Date;

/**
 * {@link WebAppSample}
 */
public class WebAppSample {

	/** ID */
	Integer id;

	/** 名前 */
	String name;

	/** 更新日時 */
	Date updateDate;

	/**
	 * コンストラクタ
	 */
	public WebAppSample() {
	}

	/**
	 * コンストラクタ
	 * @param id ID
	 * @param name 名前
	 * @param updateDate 更新日時
	 */
	public WebAppSample(Integer id, String name, Date updateDate) {
		this.id = id;
		this.name = name;
		this.updateDate = updateDate;
	}

	/**
	 * id を取得します
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * id を設定します
	 * @param id ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * name を取得します
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * name を設定します
	 * @param name 名前
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * updateDate を取得します
	 * @return updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * updateDate を設定します
	 * @param updateDate 更新日時
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
