package dto;

/**
 * {@link ShapeArea}
 */
public class ShapeArea {

	/** サイズ */
	private int size;

	/**
	 * コンストラクタ
	 * @param size サイズ
	 */
	public ShapeArea(int size) {
		this.size = size;
	}

	/**
	 * size を設定します
	 * @param size サイズ
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * size を取得します
	 * @return size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * 円の面積を計算します
	 * @return 円の面積
	 */
	public int calcCircle() {
		return (int) (size * size * 3.14);
	}

	/**
	 * 正方形の面積を計算します
	 * @return 正方形の面積
	 */
}
