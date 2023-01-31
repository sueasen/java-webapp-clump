package business.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * {@link RetroMethodService}
 */
public class RetroMethodService {

	/**
	 * 復習 数字を3つ引数で受け取って足し算した結果を返すメソッドを作る
	 *
	 * @param num1 数字1
	 * @param num2 数字2
	 * @param num3 数字3
	 * @return num1, num2, num3 を足した数字
	 */
	public int work1(int num1, int num2, int num3) {
		return num1 + num2 + num3;
	}

	/**
	 * 復習 文字列の名前を引数で受け取って「こんにちは！ ○○○さん 」を返すメソッドを作る
	 *
	 * @param name 名前
	 * @return こんにちは！ + name + さん の文字列
	 */
	public String work2(String name) {
		return "こんにちは！" + name + "さん";
	}

	/**
	 * 復習 数字 input を受け取って以下を設定した Map を返すメソッドを作る
	 * ・キー：target, 値：0-9 の乱数
	 * ・キー：score,  値：input と乱数が 0 の場合、100、input と乱数が同じ場合、inputの10倍、それ以外は -1
	 *
	 * @param input 入力数字
	 * @return 生成した乱数(target)、入力値と比較した結果(score) を設定したマップ
	 */
	public Map<String, Integer> work3(int input) {
		Map<String, Integer> map = new HashMap<>();
		int target = new Random().nextInt(10);
		map.put("target", target);
		if (input == target && input == 0) {
			map.put("score", 100);
		} else if (input == target) {
			map.put("score", input * 10);
		} else {
			map.put("score", -1);
		}
		return map;
	}

	/**
	 * 復習 method を使ってなんかやってみよう
	 */
	//	public 戻り値 work4(引数...) {
	//	}
}
