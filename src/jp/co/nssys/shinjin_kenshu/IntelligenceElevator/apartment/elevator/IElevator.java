package jp.co.nssys.shinjin_kenshu.IntelligenceElevator.apartment.elevator;

import java.util.List;

import jp.co.nssys.shinjin_kenshu.IntelligenceElevator.apartment.Floor;
import jp.co.nssys.shinjin_kenshu.IntelligenceElevator.apartment.person.IPerson;

/**
 * エレベータインタフェース
 * @author kenshu
 *
 */
public interface IElevator {

	/**
	 * 現在のフロアを取得
	 * @return int 現在のフロア
	 */
	int getNowFloor();

	/**
	 * 現在のフロアを設定
	 * @param nowFloor int 現在のフロア
	 */
	void setNowFloor(int nowFloor);

	/**
	 * エレベータに人を追加する
	 * @param person IPerson 人
	 * @return boolean 追加結果
	 */
	boolean addPerson(IPerson person);

	/**
	 * エレベータに乗っている全ての人を降ろす
	 * @return int 降ろした人数
	 */
	int removePersons();

	/**
	 * エレベータに乗っている人数が上限に達しているかどうか
	 * @return boolean 上限に達しているかどうか
	 */
	boolean isCapacityOver();

	/**
	 * エレベータを移動させる
	 * @param floorList List<Floor> フロアリスト
	 * @return int 移動先
	 */
	int move(List<Floor> floorList);
}
