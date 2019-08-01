package jp.co.nssys.shinjin_kenshu.IntelligenceElevator.apartment;

import java.util.List;

import jp.co.nssys.shinjin_kenshu.IntelligenceElevator.apartment.elevator.IElevator;
import jp.co.nssys.shinjin_kenshu.IntelligenceElevator.apartment.person.IPerson;
import jp.co.nssys.shinjin_kenshu.IntelligenceElevator.config.ApartmentConfig;

/**
 * マンションクラス
 * @author kenshu
 *
 */
public class Apartment {

	/** マンション関連設定 */
	private ApartmentConfig apartmentConfig;

	/** フロアリスト */
	private List<Floor> floorList;

	/** エレベータ */
	private IElevator elevator;

	/**
	 * コンストラクタ
	 * @param apartmentConfig ApartmentConfig マンション関連設定
	 * @param floorList フロアリスト
	 * @param elevator エレベータ
	 */
	public Apartment(ApartmentConfig apartmentConfig, List<Floor> floorList, IElevator elevator) {
		this.apartmentConfig = apartmentConfig;
		this.floorList = floorList;
		this.elevator = elevator;
	}

	/**
	 * 指定した階に待ち人を追加する
	 * @param floorNum 階数
	 * @param person 住民
	 */
	public void addPersonToFloor(int floorNum, IPerson person) {
		for (Floor floor : this.floorList) {
			if (floor.getFloor() == floorNum) {
				floor.addPerson(person);
				break;
			}
		}
	}

	/**
	 * エレベータを指定した階数に移動する
	 * @param floor 階数
	 */
	public void moveElevator(int floor) {
		this.elevator.setNowFloor(floor);
	}

	/**
	 * エレベータを自動で移動させる
	 * @return
	 */
	public int moveElevator() {
		return this.elevator.move(this.floorList);
	}

	/**
	 * エレベータに乗っている人を全て取り除く
	 * @return 取り除いた人数
	 */
	public int removePersonsFromElevator() {
		return this.elevator.removePersons();
	}

	/**
	 * 現在エレベータがいるフロアから、待ち人を乗せられるだけ乗せる
	 */
	public void addPersonsToElevator() {
		int nowFloor = this.elevator.getNowFloor();
		for (Floor floor : this.floorList) {
			if (floor.getFloor() == nowFloor) {
				IPerson person = null;
				// エレベータの上限に達するか、そのフロアの待ち人がいなくなるまで
				while (!this.elevator.isCapacityOver()
						&& (person = floor.removeFirstPerson()) != null) {
					this.elevator.addPerson(person);
				}
			}
		}
	}

	/**
	 * 指定したフロアの待ち人にストレスを加える
	 * @param floorNum 階数
	 */
	public void addStress(int floorNum) {
		for (Floor floor : this.floorList) {
			if (floor.getFloor() == floorNum) {
				floor.addStress();
				break;
			}
		}
	}

	/**
	 * 指定したフロアの、ストレスが上限に達した人を取り除く
	 * @param floorNum 階数
	 * @return int 取り除いた人数
	 */
	public int removeStressfulPerson(int floorNum) {
		int removeNum = 0;
		for (Floor floor : this.floorList) {
			if (floor.getFloor() == floorNum) {
				removeNum = floor.removeStressfulPerson();
				break;
			}
		}
		return removeNum;
	}

	/**
	 * 2階以上の待ち人の平均ストレス値を算出
	 * @return double 平均ストレス値
	 */
	public double calcStressAverage() {
		int sumStress = 0;
		int sumCount = 0;
		for (Floor floor : this.floorList) {
			if (floor.getFloor() != 1) {
				List<IPerson> waitPersonList = floor.getWaitPersonList();
				sumCount += waitPersonList.size();
				for (IPerson person : waitPersonList) {
					sumStress += person.getStress();
				}
			}
		}
		if (sumCount == 0) {
			return 0;
		}
		return (double)sumStress / sumCount;
	}

	@Override
	public String toString() {
		StringBuilder borderBuilder = new StringBuilder();
		for (int i = 0; i < this.apartmentConfig.getFloorMaxNum() + String.valueOf(this.floorList.size()).length() + 1; i++) {
			borderBuilder.append("-");
		}
		String border = borderBuilder.toString();

		StringBuilder builder = new StringBuilder();
		for (int i = this.floorList.size() - 1; i >= 0; i--) {
			builder.append(border).append("\n");
			builder.append(this.floorList.get(i));
			if (this.elevator.getNowFloor() == i + 1) {
				builder.append(elevator.toString()).append("\n");
			} else {
				builder.append("\n");
			}
		}
		builder.append(border).append("\n");
		return builder.toString();
	}
}
