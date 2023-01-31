package business.entity;

public interface IFEntity<K> {

	/**
	 * @return id
	 */
	public K getId();

	/**
	 * @return version
	 */
	public Integer getVersion();

}
