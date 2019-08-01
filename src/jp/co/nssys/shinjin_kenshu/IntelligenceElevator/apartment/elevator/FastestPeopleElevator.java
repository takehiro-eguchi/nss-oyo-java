package jp.co.nssys.shinjin_kenshu.IntelligenceElevator.apartment.elevator;

import java.util.List;

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
		// TODO 仮に最上階を返す
		return floorList.get(floorList.size() - 1).getFloor();
	}

}
