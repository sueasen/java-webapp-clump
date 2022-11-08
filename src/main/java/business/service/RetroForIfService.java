package business.service;

import java.util.List;

/**
 * {@link RetroForIfService}
 */
public class RetroForIfService {

	/**
	 * 復習 if 文を使って target と input を比較して以下の文字列を返す
	 * ・target が input と同じ場合、「正解！」
	 * ・target が input より大きい場合、「大きい．．．」
	 * ・target が input より小さい場合、「小さい．．．」
	 *
	 * @param target 当てたい数字
	 * @param input 入力数字
	 * @return target, input の比較結果
	 */
	public String work1(int target, int input) {
		if (target == input) {
			return "正解！";
		} else if (target > input) {
			return "大きい．．．";
		} else {
			return "小さい．．．";
		}
	}

	/**
	 * 復習 for 文を使って input までの数字を文字連結した値を返す
	 *
	 * @param input 入力数字
	 * @return input までの数字を文字連結した値
	 */
	public String work2(int input) {
		String result = "";
		for (int i = 0; i <= input; i++) {
			result += i;
		}
		return input + " まで連結した文字列 : " + result;
	}

	/**
	 * 復習 targets の各値と input を比較して以下の文字列を返す
	 * ・targets の合計値と input が一致する場合、「大吉！ スコア : 888」 ※ 888 は input の値の10倍
	 * ・targets の先頭と input が一致する場合、「中吉！ スコア : 888」※ 888 は input の値の5倍
	 * ・targets の最後と input が一致する場合、「小吉！ スコア : 888」※ 888 は input の値の4倍
	 * ・targets のいずれかと input が一致する場合、「吉！ スコア : 888」※ 888 は input の値
	 * ・上記以外の場合、「大凶．．． スコア : 888」※ 888 は input の -1倍
	 *
	 * @param targets 当てたい数字リスト
	 * @param input 入力数字
	 * @return targets, input の比較結果
	 */
	public String work3(List<Integer> targets, int input) {
		int sum = 0;
		for (Integer i : targets) {
			sum += i;
		}
		if (sum == input) {
			return "大吉！ スコア : " + (input * 10);
		} else if (targets.get(0) == input) {
			return "中吉！ スコア : " + (input * 5);
		} else if (targets.get(targets.size() - 1) == input) {
			return "小吉！ スコア : " + (input * 4);
		} else if (targets.contains(input)) {
			return "吉！ スコア : " + input;
		} else {
			return "大凶．．． スコア : " + (input * -1);
		}
	}

	/**
	 * 復習 if, for を使ってなんかやってみよう
	 */
	public String work4(String input) {
		return "ここを書き換えて面白いのを作ろう！ input : " + input;
	}
}
