package model;

import java.util.ArrayList;
import java.util.List;

import dao.RecordCheckDAO;

public class PointLogic {
	// データベースからpoint+levelを取得
	AccountBeans ab = new AccountBeans();
	private int nowCharaPoint = ab.getCharaPoint();
	private int nowCharaLevel = ab.getCharaLevel();

		/**
		 * Do_resultの結果に応じてPoint + Levelを増加
		 * @param rb
		 * @return
		 */
		public List<Integer> calcPoint(RecordBeans rb) {
		List<Integer> list = new ArrayList<Integer>();
		/* recordが正常にされていた場合の処理
		 if(一定期間の更新処理){
		*/
		RecordCheckDAO dao = new RecordCheckDAO();
		RecordBeans returnRb = dao.findRecordBeans(rb);
		int getPoint = 0;
		// boolean型をintに変換
		List<Boolean> results = new ArrayList<Boolean>();
		results.add(returnRb.getDo_result1());
		results.add(returnRb.getDo_result2());
		results.add(returnRb.getDo_result3());
		for (boolean result : results) {
			if (result)
				getPoint++;
		}

		// アカウントの保有ポイント
		if (getPoint == 1) {
			getPoint = 3;
		} else if (getPoint == 2) {
			getPoint = 5;
		} else if (getPoint == 3) {
			getPoint = 10;
		} else {
			getPoint = 0;
		}
		nowCharaPoint += getPoint;

		// キャラクターのレベルとポイントをリストに追加
		if (nowCharaPoint < 90) {
			list.add(1, nowCharaPoint);
		} else if (nowCharaPoint >= 90 && nowCharaLevel < 180) {
			list.add(2, nowCharaPoint);
		} else if (nowCharaPoint >= 180 && nowCharaPoint < 270) {
			list.add(3, nowCharaPoint);
		} else if (nowCharaPoint >= 270 && nowCharaPoint < 360) {
			list.add(4, nowCharaPoint);
		} else {
			list.add(5, nowCharaPoint);
		}
		System.out.println(nowCharaPoint + ":" + getPoint + ":" + nowCharaLevel);
		return list;
	}

	/**
	 * ポイント減少に応じてキャラクターのレベルも減少
	 * @param ab
	 * @return
	 */
	public List<Integer> decreasePoint(AccountBeans ab) {
		List<Integer> list = new ArrayList<Integer>();
		nowCharaLevel -= 10;
		if (nowCharaPoint < 90) {
			list.add(1, nowCharaPoint);
		} else if (nowCharaPoint >= 90 && nowCharaLevel < 180) {
			list.add(2, nowCharaPoint);
		} else if (nowCharaPoint >= 180 && nowCharaPoint < 270) {
			list.add(3, nowCharaPoint);
		} else if (nowCharaPoint >= 270 && nowCharaPoint < 360) {
			list.add(4, nowCharaPoint);
		} else {
			list.add(5, nowCharaPoint);
		}
		return list;
	}
	/* TODO ポイントがマイナスにならない機能
	 *      例外処理の追記
	 * 		登録日の取得
	 * 		boolean型do_result→int
	 */

}
