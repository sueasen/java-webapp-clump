package business.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import dto.WebAppSample;

class WebAppSampleServiceTest {

	/**
	 * createList のテストを実施します
	 *
	 * @return WebAppSample リスト
	 */
	@Test
	public void testCreateList001() {
		List<WebAppSample> result = new WebAppSampleService().createList();
		assertEquals(2, result.size());
	}

	/**
	 * createList(int) のテストを実施します
	 *
	 * @return WebAppSample リスト
	 */
	@Test
	public void testCreateList002() {
		List<WebAppSample> result = new WebAppSampleService().createList(4);
		assertEquals(4, result.size());
	}

	/**
	 * insert のテストを実施します
	 *
	 * @return WebAppSample リスト
	 */
	@Test
	public void testInsert001() {
		List<WebAppSample> list = new ArrayList<>();
		WebAppSample result = new WebAppSampleService().insert(list, "test");
		assertEquals(1, result.getId());
		assertEquals("test", result.getName());
		assertNotNull(result.getUpdateDate());
		assertEquals(1, list.size());
		assertEquals(result, list.get(0));
	}

	/**
	 * select のテストを実施します(取得するIDが存在あり)
	 *
	 * @return WebAppSample リスト
	 */
	@Test
	public void testSelect001() {
		WebAppSample sampl1 = new WebAppSample(1, "test1", new Date());
		WebAppSample sampl2 = new WebAppSample(2, "test2", new Date());
		List<WebAppSample> list = Arrays.asList(sampl1, sampl2);
		WebAppSample result = new WebAppSampleService().select(list, 1);
		assertEquals(sampl1, result);
	}

	/**
	 * select のテストを実施します(取得するIDが存在なし)
	 *
	 * @return WebAppSample リスト
	 */
	@Test
	public void testSelect002() {
		WebAppSample sampl1 = new WebAppSample(1, "test1", new Date());
		WebAppSample sampl2 = new WebAppSample(2, "test2", new Date());
		List<WebAppSample> list = Arrays.asList(sampl1, sampl2);
		WebAppSample result = new WebAppSampleService().select(list, 3);
		assertNull(result);
	}

	/**
	 * update のテストを実施します(取得するIDが存在あり)
	 *
	 * @return WebAppSample リスト
	 */
	@Test
	public void testUpdate001() {
		WebAppSample sampl1 = new WebAppSample(1, "test1", new Date());
		WebAppSample sampl2 = new WebAppSample(2, "test2", new Date());
		List<WebAppSample> list = new ArrayList<>(Arrays.asList(sampl1, sampl2));
		WebAppSample result = new WebAppSampleService().update(list, 1, "test11");
		assertEquals(sampl1, result);
		assertEquals("test11", result.getName());
		assertEquals("test11", list.get(0).getName());
		assertEquals("test2", list.get(1).getName());
	}

	/**
	 * update のテストを実施します(取得するIDが存在なし)
	 *
	 * @return WebAppSample リスト
	 */
	@Test
	public void testUpdate002() {
		WebAppSample sampl1 = new WebAppSample(1, "test1", new Date());
		WebAppSample sampl2 = new WebAppSample(2, "test2", new Date());
		List<WebAppSample> list = new ArrayList<>(Arrays.asList(sampl1, sampl2));
		WebAppSample result = new WebAppSampleService().update(list, 3, "test11");
		assertNull(result);
		assertEquals("test1", list.get(0).getName());
		assertEquals("test2", list.get(1).getName());
	}

	/**
	 * delete のテストを実施します(取得するIDが存在あり)
	 *
	 * @return WebAppSample リスト
	 */
	@Test
	public void testDelete001() {
		WebAppSample sampl1 = new WebAppSample(1, "test1", new Date());
		WebAppSample sampl2 = new WebAppSample(2, "test2", new Date());
		List<WebAppSample> list = Arrays.asList(sampl1, sampl2).stream().collect(Collectors.toList());
		WebAppSample result = new WebAppSampleService().delete(list, 1);
		assertEquals(sampl1, result);
		assertEquals(1, list.size());
	}

	/**
	 * delete のテストを実施します(取得するIDが存在なし)
	 *
	 * @return WebAppSample リスト
	 */
	@Test
	public void testDelete002() {
		WebAppSample sampl1 = new WebAppSample(1, "test1", new Date());
		WebAppSample sampl2 = new WebAppSample(2, "test2", new Date());
		List<WebAppSample> list = Arrays.asList(sampl1, sampl2).stream().collect(Collectors.toList());
		WebAppSample result = new WebAppSampleService().delete(list, 3);
		assertNull(result);
		assertEquals(2, list.size());
	}

}
