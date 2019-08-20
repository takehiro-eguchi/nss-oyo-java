package jp.co.nssys.shinjin_kenshu.IntelligenceElevator.apartment.elevator;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import jp.co.nssys.shinjin_kenshu.IntelligenceElevator.apartment.Floor;
import jp.co.nssys.shinjin_kenshu.IntelligenceElevator.config.ApartmentConfig;

/**
 * 最も初めに並んだ人のフロアに移動するエレベータ
 * @author kenshu
 *
 */
public class FastestPeopleElevator extends AbstractElevator {

	public FastestPeopleElevator(ApartmentConfig apartmentConfig) {
		super(apartmentConfig);
	}

	@Override
	protected int up(List<Floor> floorList) {
		// ストレス値の上昇が一様であるから最も初めに並んだものが最もストレスが高くなる
//		Optional<Floor> floorOpt = floorList.stream()
//				.max(comparingInt(f -> f.getWaitPersonList().size()));
//		return floorOpt.get().getFloor();
		Comparator<Floor> fastestPeopleComp = Comparator
				.comparingInt(f -> f.getWaitPersonList().stream().mapToInt(p -> p.getStress()).max().getAsInt());
		Comparator<Floor> floorComp = Comparator.comparingInt(Floor::getFloor);

		// ストレス最大の人が存在するフロア > 階数が高いフロア の順で移動するフロアを選択する
		Optional<Floor> floor = floorList.stream().max(fastestPeopleComp.thenComparing(floorComp));
		return floor.get().getFloor();
		// TODO 仮に最上階を返す
//		return floorList.get(floorList.size() - 1).getFloor();
	}

}
