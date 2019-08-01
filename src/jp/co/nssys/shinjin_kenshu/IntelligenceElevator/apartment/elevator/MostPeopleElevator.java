package jp.co.nssys.shinjin_kenshu.IntelligenceElevator.apartment.elevator;

import java.util.List;

import jp.co.nssys.shinjin_kenshu.IntelligenceElevator.apartment.Floor;
import jp.co.nssys.shinjin_kenshu.IntelligenceElevator.config.ApartmentConfig;

/**
 * 最も待ち人が多いフロアに移動するエレベータ
 * @author kenshu
 *
 */
public class MostPeopleElevator extends AbstractElevator {

	public MostPeopleElevator(ApartmentConfig apartmentConfig) {
		super(apartmentConfig);
	}

	@Override
	protected int up(List<Floor> floorList) {
		// TODO 仮に最上階を返す
		return floorList.get(floorList.size() - 1).getFloor();
	}

}
