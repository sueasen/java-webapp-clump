package business.service;

import dto.Memo;
import dto.ShapeArea;

/**
 * {@link RetroClassService}
 */
public class RetroClassService {

	/**
	 * 復習 入力数字をサイズに設定した ShapeArea クラスのインスタンスを生成して返却しよう
	 *      クラス ShapeArea に以下のメソッドを追加する
	 *      ・正方形の面積(int型)を返すメソッド calcSquare(引数なし)
	 *
	 * @param input 入力数字
	 * @return input を設定した Area
	 */
	public ShapeArea work1(int input) {
		return null;
	}

	/**
	 * 復習 入力した名前、メッセージを設定するクラス Memo を作成しインスタンスを生成して返却しよう
	 *      クラス Memo は以下のように作成する
	 *      ・インスタンス変数 : String型 name, String型 message
	 *      ・コンストラクタ ： インスタンス変数と同名の引数を受け取り各変数に設定
	 *      ・メソッド : インスタンス変数の getter, setter
	 *
	 * @param name 名前
	 * @param message メッセージ
	 * @return メモ
	 */
	public Memo work2(String name, String message) {
		return null;
	}

	/**
	 * 復習 クラス Memo を継承する クラス MemoDate を作成しインスタンスを生成して返却しよう
	 *      クラス MemoDate は以下のように作成する
	 *      ・インスタンス変数：Date型 createDate
	 *      ・コンストラクタ：親クラスのインスタンス変数と同名の引数を受け取り各変数に設定
	 *                        createDate に現在日付を設定
	 *      ・メソッド : インスタンス変数の getter, setter
	 *
	 * @param name 名前
	 * @param message メッセージ
	 * @return 日付メモ
	 */
	public Memo work3(String name, String message) {
		return null;
	}

	/**
	 * 復習 クラスを使ってなんかやってみよう
	 */
	public String work4(String input) {
		return "ここを書き換えて面白いのを作ろう！ input : " + input;
	}
}
