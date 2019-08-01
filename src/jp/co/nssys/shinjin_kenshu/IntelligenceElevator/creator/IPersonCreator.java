package jp.co.nssys.shinjin_kenshu.IntelligenceElevator.creator;

import jp.co.nssys.shinjin_kenshu.IntelligenceElevator.apartment.person.IPerson;

/**
 * 待ち人生成インタフェース
 * @author kenshu
 *
 */
public interface IPersonCreator {

	/**
	 * 待ち人生成
	 * @return IPerson
	 */
	public IPerson create();
}
