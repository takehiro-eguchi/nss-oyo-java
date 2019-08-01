package jp.co.nssys.shinjin_kenshu.IntelligenceElevator.config;

/**
 * マンション関連設定
 * @author kenshu
 *
 */
public class ApartmentConfig {

	/** フロア数：初期値 */
	public static final int DEF_GAME_FLOOR_NUM = 5;

	/** フロアの待ち人の上限人数：初期値 */
	public static final int DEF_FLOOR_MAX_NUM = 10;

	/** エレベータに乗れる上限人数：初期値 */
	public static final int DEF_ELEVATOR_MAX_NUM = 5;


	/** フロア数 */
	private int gameFloorNum;

	/** フロアの待ち人の上限人数 */
	private int floorMaxNum;

	/** エレベータに乗れる上限人数 */
	private int elevatorMaxNum;

	/**
	 * フロア数のgetter
	 * @return int フロア数
	 */
	public int getGameFloorNum() {
		return this.gameFloorNum;
	}

	/**
	 * フロア数のsetter
	 * @param gameFloorNum int フロア数
	 */
	public void setGameFloorNum(int gameFloorNum) {
		this.gameFloorNum = gameFloorNum;
	}

	/**
	 * フロアの待ち人の上限人数のgetter
	 * @return int フロアの待ち人の上限人数
	 */
	public int getFloorMaxNum() {
		return this.floorMaxNum;
	}

	/**
	 * フロアの待ち人の上限人数のsetter
	 * @param floorMaxNum int フロアの待ち人の上限人数
	 */
	public void setFloorMaxNum(int floorMaxNum) {
		this.floorMaxNum = floorMaxNum;
	}

	/**
	 * エレベータに乗れる上限人数のgetter
	 * @return int エレベータに乗れる上限人数
	 */
	public int getElevatorMaxNum() {
		return this.elevatorMaxNum;
	}

	/**
	 * エレベータに乗れる上限人数のsetter
	 * @param elevatorMaxNum int エレベータに乗れる上限人数
	 */
	public void setElevatorMaxNum(int elevatorMaxNum) {
		this.elevatorMaxNum = elevatorMaxNum;
	}
}
