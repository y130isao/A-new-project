package model;

public class PointLogic {
	// データベースからpoint+levelを取得
	/**
	 * Do_resultの結果に応じてPoint + Levelを増加
	 * @param rb
	 * @return
	 */
	public AccountBeans calcPoint(AccountBeans ab, boolean do_result1, boolean do_result2, boolean do_result3) {
		/* recordが正常にされていた場合の処理
		 if(一定期間の更新処理){
		*/
		int nowCharaPoint = ab.getCharaPoint();
		int nowCharaLevel = ab.getCharaLevel();
		int getPoint = 0;
		// boolean型をintに変換
		boolean results[] = {do_result1, do_result2, do_result3};
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
		ab.setCharaPoint(nowCharaPoint);

		// キャラクターのレベルとポイントをリストに追加
		if (nowCharaPoint < 90) {
			nowCharaLevel = 1;
		} else if (nowCharaPoint >= 90 && nowCharaPoint < 180) {
			nowCharaLevel = 2;
		} else if (nowCharaPoint >= 180 && nowCharaPoint < 270) {
			nowCharaLevel = 3;
		} else if (nowCharaPoint >= 270 && nowCharaPoint < 360) {
			nowCharaLevel = 4;
		} else {
			nowCharaLevel = 5;
		}
		ab.setCharaLevel(nowCharaLevel);
		return ab;
	}

	/**
	 * ポイント減少に応じてキャラクターのレベルも減少
	 * @param ab
	 * @return
	 */
	public void decreasePoint(AccountBeans ab) {
		int nowCharaPoint = ab.getCharaPoint();
		int nowCharaLevel = ab.getCharaLevel();
		nowCharaPoint -= 10;
		ab.setCharaPoint(nowCharaPoint);
		if (nowCharaPoint < 90) {
			nowCharaLevel = 1;
		} else if (nowCharaPoint >= 90 && nowCharaPoint < 180) {
			nowCharaLevel = 2;
		} else if (nowCharaPoint >= 180 && nowCharaPoint < 270) {
			nowCharaLevel = 3;
		} else if (nowCharaPoint >= 270 && nowCharaPoint < 360) {
			nowCharaLevel = 4;
		} else {
			nowCharaLevel = 5;
		}
		ab.setCharaLevel(nowCharaLevel);
	}
	/* TODO ポイントがマイナスにならない機能
	 *      例外処理の追記
	 */

}
