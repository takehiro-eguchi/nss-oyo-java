package jp.co.nssys.shinjin_kenshu.IntelligenceElevator.config;

/**
 * 待ち人関連設定
 * @author kenshu
 *
 */
public class PersonConfig {

	/** 待ち人の種類：初期値 */
	public static final int DEF_PERSON_TYPE_NUM = 1;

	/** 一般的な待ち人のストレスの上限：初期値 */
	public static final int DEF_NORMAL_PERSON_STRESS_MAX = 9;

	/** 待ち人の種類 */
	private int personTypeNum;

	/** 一般的な待ち人のストレスの上限 */
	private int normalPersonStressMax;

	/**
	 * 待ち人の種類のgetter
	 * @return int 待ち人の種類
	 */
	public int getPersonTypeNum() {
		return this.personTypeNum;
	}

	/**
	 * 待ち人の種類のsetter
	 * @param personTypeNum int 待ち人の種類
	 */
	public void setPersonTypeNum(int personTypeNum) {
		this.personTypeNum = personTypeNum;
	}

	/**
	 * 一般的な待ち人のストレスの上限のgetter
	 * @return int 一般的な待ち人のストレスの上限
	 */
	public int getNormalPersonStressMax() {
		return this.normalPersonStressMax;
	}

	/**
	 * 一般的な待ち人のストレスの上限のsetter
	 * @param normalPersonStressMax int 一般的な待ち人のストレスの上限
	 */
	public void setNormalPersonStressMax(int normalPersonStressMax) {
		this.normalPersonStressMax = normalPersonStressMax;
	}
}
