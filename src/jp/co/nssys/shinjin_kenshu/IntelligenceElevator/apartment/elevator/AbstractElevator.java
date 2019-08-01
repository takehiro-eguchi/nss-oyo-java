package jp.co.nssys.shinjin_kenshu.IntelligenceElevator.apartment.elevator;

import java.util.ArrayList;
import java.util.List;

import jp.co.nssys.shinjin_kenshu.IntelligenceElevator.apartment.Floor;
import jp.co.nssys.shinjin_kenshu.IntelligenceElevator.apartment.person.IPerson;
import jp.co.nssys.shinjin_kenshu.IntelligenceElevator.config.ApartmentConfig;

/**
 * エレベータ抽象クラス
 * エレベータの共通処理を実装
 * @author kenshu
 *
 */
public abstract class AbstractElevator implements IElevator {

	/** マンション関連設定 */
	private ApartmentConfig apartmentConfig;

	/** 現在のフロア */
	private int nowFloor;

	/** エレベータに乗っている人のリスト */
	private List<IPerson> personList;

	/**
	 * コンストラクタ
	 * @param apartmentConfig ApartmentConfig マンション関連設定
	 */
	public AbstractElevator(ApartmentConfig apartmentConfig) {
		this.apartmentConfig = apartmentConfig;
		this.nowFloor = 0;
		this.personList = new ArrayList<>();
	}

	@Override
	public int getNowFloor() {
		return this.nowFloor;
	}

	@Override
	public void setNowFloor(int nowFloor) {
		this.nowFloor = nowFloor;
	}

	@Override
	public boolean addPerson(IPerson person) {
		if (this.isCapacityOver()) {
			return false;
		}
		return this.personList.add(person);
	}

	@Override
	public int removePersons() {
		int personNum = this.personList.size();
		this.personList.clear();

		return personNum;
	}

	@Override
	public boolean isCapacityOver() {
		return this.personList.size() >= this.apartmentConfig.getElevatorMaxNum();
	}

	@Override
	public int move(List<Floor> floorList) {
		int moveFloor = 0;
		if (this.nowFloor == 1) {
			// 1階に入る場合は上昇
			moveFloor = up(floorList);
		} else {
			// 1階以外に入る場合は1つ下のフロアへ
			moveFloor = this.nowFloor - 1;
		}
		// 人のいないフロアを飛ばす
		moveFloor = this.moveNotEmptyFloor(moveFloor, floorList);
		this.nowFloor = moveFloor;
		return moveFloor;
	}

	/**
	 * 上昇先を指定する
	 * @param floorList List<Floor> フロアリスト
	 * @return int 上昇先フロア
	 */
	protected abstract int up(List<Floor> floorList);

	/**
	 * 行先のフロアに誰もいないか確認
	 * @param moveFloor int 行先
	 * @param floorList List<Floor> フロアリスト
	 * @return boolean
	 */
	protected Boolean isMoveFloorEmpty(int moveFloor, List<Floor> floorList) {
		for (Floor floor : floorList) {
			if (floor.getFloor() == moveFloor) {
				return floor.getWaitPersonList().isEmpty();
			}
		}
		return null;
	}

	/**
	 * 指定したフロアに誰もいない場合、待ち住民がいるフロアまで下げる
	 * @param moveFloor int 指定フロア
	 * @param floorList List<Floor> フロアリスト
	 * @return int 待ち住民がいるフロア or 1階
	 */
	protected int moveNotEmptyFloor(int moveFloor, List<Floor> floorList) {
		// 指定フロアから順に1階まで、待ち人がいるか判定していく
		for (int i = moveFloor; i >= 1; i--) {
			moveFloor = i;
			if (this.isMoveFloorEmpty(i, floorList)) {
				//
				continue;
			} else {
				// 待ち人が1人でもいるフロアに決定
				break;
			}
		}
		return moveFloor;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("□");
		for (IPerson person : this.personList) {
			builder.append(person.getStress());
		}

		return builder.toString();
	}

}
