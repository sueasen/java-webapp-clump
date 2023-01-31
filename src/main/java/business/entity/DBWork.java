package business.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity(name = "DB_WORK")
public class DBWork implements IFEntity<Integer> {

	/** ID */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/** 名前 */
	private String name;

	/** バージョン */
	@Version
	private Integer version;

	/**
	 * コンストラクタ
	 */
	public DBWork() {
	}

	/**
	 * コンストラクタ
	 * @param id ID
	 * @param name 名前
	 * @param version バージョン
	 */
	public DBWork(Integer id, String name, Integer version) {
		this.id = id;
		this.name = name;
		this.version = version;
	}

	/**
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id セットする id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return version
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * @param version セットする version
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

}
