package business.service;

import java.util.List;

import business.dao.DaoJPA;
import business.entity.DBWork;

/**
 * {@link DBWorkService}
 */
public class DBWorkService {

	//DBWorkDaoJDBC dao = new DBWorkDaoJDBC();
	//DBWorkDaoJPA dao = new DBWorkDaoJPA();
	DaoJPA<DBWork, Integer> dao = new DaoJPA<>(DBWork.class);

	/**
	 * DBWork を全件取得します
	 *
	 * @return DBWorkリスト
	 */
	public List<DBWork> findAll() {
		return dao.findAll();
	}

	/**
	 * DBWork を取得します
	 *
	 * @param id ID
	 * @return DBWork
	 */
	public DBWork find(int id) {
		return dao.find(id);
	}

	/**
	 * DBWork を登録します
	 *
	 * @param name 名前
	 * @return 登録件数
	 */
	public int insert(String name) {
		DBWork dbWork = new DBWork();
		dbWork.setName(name);
		dao.insert(dbWork);
		return 1;
	}

	/**
	 * DBWork を更新します
	 *
	 * @param id ID
	 * @param name 名前
	 * @param version バージョン
	 * @return 更新件数
	 */
	public int update(int id, String name, int version) {
		DBWork dbWork = dao.find(id);
		if (dbWork == null || !dbWork.getVersion().equals(version)) {
			return 0;
		}
		dbWork.setName(name);
		dao.update(dbWork);
		return 1;
	}

	/**
	 * DBWork を削除します
	 *
	 * @param id ID
	 * @param version バージョン
	 * @return 削除件数
	 */
	public int delete(int id, int version) {
		DBWork dbWork = dao.find(id);
		if (dbWork == null || !dbWork.getVersion().equals(version)) {
			return 0;
		}
		dao.delete(dbWork);
		return 1;
	}

}
