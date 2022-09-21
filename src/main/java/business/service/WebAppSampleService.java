package business.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dto.WebAppSample;

/**
 * {@link WebAppSampleService}
 */
public class WebAppSampleService {

	/**
	 * WebAppSample を設定したリストを作成します
	 *
	 * @return WebAppSample リスト
	 */
	public List<WebAppSample> createList() {
		return createList(2);
	}

	/**
	 * WebAppSample を size 件数設定したリストを作成します
	 *
	 * @param size 件数
	 * @return WebAppSample リスト
	 */
	public List<WebAppSample> createList(int size) {
		List<WebAppSample> list = new ArrayList<>();
		for (int i = 1; i <= size; i++) {
			insert(list, "Sample_" + i);
		}
		return list;
	}

	/**
	 * WebAppSample を登録します
	 *
	 * @param list WebAppSample リスト
	 * @param name 名前
	 * @return 作成した WebAppSample
	 */
	public WebAppSample insert(List<WebAppSample> list, String name) {
		Integer id = list.isEmpty() ? 1 : list.get(list.size() - 1).getId() + 1;
		WebAppSample sample = new WebAppSample(id, name, new Date());
		list.add(sample);
		return sample;
	}

	/**
	 * ID が一致する WebAppSample を取得します
	 *
	 * @param list WebAppSample リスト
	 * @param id ID
	 * @return 削除した WebAppSample
	 */
	public WebAppSample select(List<WebAppSample> list, Integer id) {
		for (WebAppSample sample : list) {
			if (sample.getId().equals(id)) {
				return sample;
			}
		}
		return null;
		//		return list.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
	}

	/**
	 * ID が一致する WebAppSample を更新します
	 *
	 * @param list WebAppSample リスト
	 * @param id ID
	 * @param name 名前
	 * @return 更新した WebAppSample
	 */
	public WebAppSample update(List<WebAppSample> list, Integer id, String name) {
		WebAppSample sample = select(list, id);
		if (sample == null) {
			return null;
		}
		sample.setName(name);
		sample.setUpdateDate(new Date());
		return sample;
	}

	/**
	 * ID が一致する WebAppSample を削除します
	 *
	 * @param list WebAppSample リスト
	 * @param id ID
	 * @return 削除した WebAppSample
	 */
	public WebAppSample delete(List<WebAppSample> list, Integer id) {
		WebAppSample sample = select(list, id);
		if (sample == null) {
			return null;
		}
		list.remove(sample);
		return sample;
	}

}
