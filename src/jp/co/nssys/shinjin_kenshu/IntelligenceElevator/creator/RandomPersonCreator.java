package jp.co.nssys.shinjin_kenshu.IntelligenceElevator.creator;

import java.util.Random;

import jp.co.nssys.shinjin_kenshu.IntelligenceElevator.apartment.person.IPerson;
import jp.co.nssys.shinjin_kenshu.IntelligenceElevator.apartment.person.NormalPerson;
import jp.co.nssys.shinjin_kenshu.IntelligenceElevator.config.PersonConfig;

/**
 * ランダム待ち人作成クラス
 * @author kenshu
 *
 */
public class RandomPersonCreator implements IPersonCreator {

	/** 待ち人関連設定 */
	private PersonConfig personConfig;

	/**
	 * コンストラクタ
	 * @param personConfig PersonConfig 待ち人関連設定
	 */
	public RandomPersonCreator(PersonConfig personConfig) {
		this.personConfig = personConfig;
	}

	@Override
	public IPerson create() {
		IPerson person;

		// ランダムに待ち人インスタンス作成
		// 今後、待ち人の種類が増えた場合に調整
		int type = new Random().nextInt(this.personConfig.getPersonTypeNum() + 1) + 1;
		switch (type) {
			case 1:
				person = new NormalPerson(this.personConfig.getNormalPersonStressMax());
				break;
			default:
				person = new NormalPerson(this.personConfig.getNormalPersonStressMax());
				break;
		}

		return person;
	}
}
