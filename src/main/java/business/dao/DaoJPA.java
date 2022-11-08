package business.dao;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

import business.entity.IFEntity;

/**
 * {@link DaoJPA}
 */
public class DaoJPA<T extends IFEntity<K>, K> {

	Class<T> entityClass;

	/**
	 * コンストラクタ
	 * @param entityClass entityClass
	 */
	public DaoJPA(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	/**
	 * EntityManagerを生成します
	 * @return EntityManager
	 */
	public EntityManager createEntityManager() {
		return Persistence.createEntityManagerFactory("webappdb").createEntityManager();
	}

	/**
	 * SQLを実行します
	 * @param function function
	 * @return entity
	 */
	public <E> E executeQuery(Function<EntityManager, E> function) {
		EntityManager entityManager = createEntityManager();
		return function.apply(entityManager);
	}

	/**
	 * 更新SQLをトランザクションを開始して実行します
	 * @param consumer consumer
	 */
	public void executeUpdate(Consumer<EntityManager> consumer) {
		EntityManager entityManager = createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		consumer.accept(entityManager);
		entityTransaction.commit();
	}

	/**
	 * Entity を全件取得します
	 * @return entityリスト
	 */
	public List<T> findAll() {
		return executeQuery(entityManager -> {
			CriteriaQuery<T> query = entityManager.getCriteriaBuilder().createQuery(entityClass);
			return entityManager.createQuery(query.select(query.from(entityClass))).getResultList();
		});
	}

	/**
	 * Entity を取得します
	 * @param id ID
	 * @param entity
	 */
	public T find(K id) {
		return executeQuery(entityManager -> entityManager.find(entityClass, id));
	}

	/**
	 * Entity を登録します
	 * @param entity entity
	 */
	public void insert(T entity) {
		executeUpdate(entityManager -> entityManager.persist(entity));
	}

	/**
	 * Entity を更新します
	 * @param entity entity
	 */
	public void update(T entity) {
		executeUpdate(entityManager -> entityManager.merge(entity));
	}

	/**
	 * Entity を削除します
	 * @param entity entity
	 */
	public void delete(T entity) {
		executeUpdate(entityManager -> entityManager.remove(entityManager.find(entityClass, entity.getId())));
	}

}
