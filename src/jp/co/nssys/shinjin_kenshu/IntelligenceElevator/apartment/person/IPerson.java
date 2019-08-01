package jp.co.nssys.shinjin_kenshu.IntelligenceElevator.apartment.person;

/**
 * 待ち人インタフェース
 * @author kenshu
 *
 */
public interface IPerson {

	/**
	 * ストレスが上限に達したかどうか
	 * @return boolean
	 */
	public boolean isStressful();

	/**
	 * ストレスを加算する
	 */
	public void addStress();

	/**
	 * 現在のストレスのgetter
	 * @return int 現在のストレス
	 */
	public int getStress();
}
