package jp.co.nssys.shinjin_kenshu.IntelligenceElevator.apartment.person;

/**
 * 待ち人抽象クラス
 * 待ち人の共通処理を実装
 * @author kenshu
 *
 */
public abstract class AbstractPerson implements IPerson {

	/** ストレスの上限値 */
	protected int maxStress;

	/** 現在のストレス */
	protected int stress;

	/**
	 * コンストラクタ
	 * @param maxStress int ストレスの上限値
	 */
	public AbstractPerson(int maxStress) {
		this.maxStress = maxStress;
		this.stress = 0;
	}

	@Override
	public int getStress() {
		return stress;
	}

	@Override
	public boolean isStressful() {
		return this.stress >= this.maxStress;
	}

	@Override
	public void addStress() {
		this.stress++;
	}

}
