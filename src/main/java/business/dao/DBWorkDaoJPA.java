package business.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

import business.entity.DBWork;

/**
 * {@link DBWorkDaoJPA}
 */
public class DBWorkDaoJPA {

	/**
	 * EntityManagerを生成します
	 * @return EntityManager
	 */
	public EntityManager createEntityManager() {
		return Persistence.createEntityManagerFactory("webappdb").createEntityManager();
	}

	/**
	 * DBWork を全件取得します
	 */
	public List<DBWork> findAll() {
		EntityManager entityManager = createEntityManager();
		CriteriaQuery<DBWork> query = entityManager.getCriteriaBuilder().createQuery(DBWork.class);
		return entityManager.createQuery(query.select(query.from(DBWork.class))).getResultList();
	}

	/**
	 * DBWork を取得します
	 * @param id ID
	 */
	public DBWork find(int id) {
		EntityManager entityManager = createEntityManager();
		return entityManager.find(DBWork.class, id);
	}

	/**
	 * DBWork を登録します
	 * @param dbWork dbWork
	 * @return 登録件数
	 */
	public int insert(DBWork dbWork) {
		EntityManager entityManager = createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(dbWork);
		entityTransaction.commit();
		return 1;
	}

	/**
	 * DBWork を更新します
	 * @param dbWork dbWork
	 * @return 更新件数
	 */
	public int update(DBWork dbWork) {
		EntityManager entityManager = createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(dbWork);
		entityTransaction.commit();
		return 1;
	}

	/**
	 * DBWork を削除します
	 * @param dbWork dbWork
	 * @return 削除件数
	 */
	public int delete(DBWork dbWork) {
		EntityManager entityManager = createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(entityManager.find(DBWork.class, dbWork.getId()));
		entityTransaction.commit();
		return 1;
	}

}
