package jp.co.nssys.shinjin_kenshu.IntelligenceElevator.config;

/**
 * 共通設定
 * @author kenshu
 *
 */
public class CommonConfig {

	/** ゲームオーバー：初期値 */
	public static final int DEF_GAME_OVER_COUNT = 1;

	/** ゲームオーバー */
	private int gameOverCount;

	/**
	 * ゲームオーバー値のgetter
	 * @return int ゲームオーバー値
	 */
	public int getGameOverCount() {
		return this.gameOverCount;
	}

	/**
	 * ゲームオーバー値のsetter
	 * @param gameOverCount int ゲームオーバー値
	 */
	public void setGameOverCount(int gameOverCount) {
		this.gameOverCount = gameOverCount;
	}
}
