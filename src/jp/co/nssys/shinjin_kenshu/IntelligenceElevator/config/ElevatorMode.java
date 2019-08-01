package jp.co.nssys.shinjin_kenshu.IntelligenceElevator.config;

import jp.co.nssys.shinjin_kenshu.IntelligenceElevator.apartment.elevator.FastestPeopleElevator;
import jp.co.nssys.shinjin_kenshu.IntelligenceElevator.apartment.elevator.MostPeopleElevator;

/**
 * エレベータ起動モード
 * @author kenshu
 *
 */
public enum ElevatorMode {
	/** 1Fに着いたら、最も待ち人が多いフロアに移動する */
	MOST_PEOPLE(1, "1Fに着いたら、最も待ち人が多いフロアに移動するエレベータ", MostPeopleElevator.class),
	/** 1Fに着いたら、最も初めに並んだ人がいるフロアに移動する */
	FASTEST_PEOPLE(2, "1Fに着いたら、最も初めに並んだ人がいるフロアに移動するエレベータ", FastestPeopleElevator.class);

	/** 起動モード番号 */
	private int mode;
	/** 説明 */
	private String context;
	/** 起動モードに対応したエレベータクラス */
	private Class<?> elevatorClass;

	/**
	 * コンストラクタ
	 * @param mode int 起動モード番号
	 * @param context String 説明
	 * @param elevatorClass Class<?> エレベータクラス
	 */
	private ElevatorMode(int mode, String context, Class<?> elevatorClass) {
		this.mode = mode;
		this.context = context;
		this.elevatorClass = elevatorClass;
	}

	/**
	 * 起動モード番号のgetter
	 * @return int 起動モード番号
	 */
	public int getMode() {
		return this.mode;
	}

	/**
	 * 説明のgetter
	 * @return String 説明
	 */
	public String getContext() {
		return this.context;
	}

	/**
	 * 起動モードに対応したエレベータクラスのgetter
	 * @return Class<?> 起動モードに対応したエレベータクラス
	 */
	public Class<?> getElevatorClass() {
		return this.elevatorClass;
	}

	/**
	 * 指定されたモードに対応するEnumを取得
	 * @param mode int 起動モード番号
	 * @return ElevatorMode 起動モード番号に対応したEnum、存在しない場合はnull
	 */
	public static ElevatorMode valueOf(int mode) {
		for (ElevatorMode elevatorMode : ElevatorMode.values()) {
			if (elevatorMode.mode == mode) {
				return elevatorMode;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		return builder.append(this.mode).append(": ").append(this.context).toString();
	}
}
