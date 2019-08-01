package jp.co.nssys.shinjin_kenshu.IntelligenceElevator.apartment;

import java.util.ArrayList;
import java.util.List;

import jp.co.nssys.shinjin_kenshu.IntelligenceElevator.apartment.person.IPerson;
import jp.co.nssys.shinjin_kenshu.IntelligenceElevator.config.ApartmentConfig;

/**
 * フロアクラス
 * @author kenshu
 *
 */
public class Floor {

	/** マンション関連設定 */
	private ApartmentConfig apartmentConfig;

	/** フロアの階数 */
	private int floor;

	/** 待ち人 */
	private List<IPerson> waitPersonList;

	/**
	 * コンストラクタ
	 * @param apartmentConfig ApartmentConfig マンション関連設定
	 * @param floor int フロア数
	 */
	public Floor(ApartmentConfig apartmentConfig, int floor) {
		this.apartmentConfig = apartmentConfig;
		this.floor = floor;
		this.waitPersonList = new ArrayList<>();
	}

	/**
	 * フロアの階数のgetter
	 * @return int フロアの階数
	 */
	public int getFloor() {
		return this.floor;
	}

	/**
	 * 待ち人のgetter
	 * @return List<IPerson> 待ち人
	 */
	public List<IPerson> getWaitPersonList() {
		return this.waitPersonList;
	}

	/**
	 * 人を待ちに追加する
	 * @param person
	 * @return 追加結果
	 */
	public boolean addPerson(IPerson person) {
		// そのフロアで待っている人数の上限から追加するか判断
		return this.waitPersonList.size() <= this.apartmentConfig.getFloorMaxNum() ? this.waitPersonList.add(person)  : false;
	}

	/**
	 * 待ち人の先頭を取り除く
	 * @return 取り除いた人
	 */
	public IPerson removeFirstPerson() {
		return this.waitPersonList.size() > 0 ? this.waitPersonList.remove(0) : null;
	}

	/**
	 * 待ち人のストレスを加算する
	 */
	public void addStress() {
		for (IPerson person : this.waitPersonList ) {
			person.addStress();
		}
	}

	/**
	 * ストレスが上限に達した住民を取り除く
	 * @return int 取り除いた人数
	 */
	public int removeStressfulPerson() {
		int stressfulNum = 0;
		// Listから取り除くため、後ろから順に判定
		for (int i = this.waitPersonList.size() - 1; i >= 0; i--) {
			IPerson person = this.waitPersonList.get(i);
			if (person.isStressful()) {
				// ストレスが上限に達した人を取り除き、人数をカウント
				this.waitPersonList.remove(i);
				stressfulNum++;
			}
		}

		return stressfulNum;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.floor).append(")");
		for (int i = this.apartmentConfig.getFloorMaxNum() - 1; i >= 0; i--) {
			if (i >= this.waitPersonList.size()) {
				builder.append(" ");
			} else {
				builder.append(this.waitPersonList.get(i).getStress());
			}
		}
		return builder.toString();
	}

}
