package jp.co.nssys.shinjin_kenshu.IntelligenceElevator;

import jp.co.nssys.shinjin_kenshu.IntelligenceElevator.apartment.elevator.IElevator;
import jp.co.nssys.shinjin_kenshu.IntelligenceElevator.config.ApartmentConfig;
import jp.co.nssys.shinjin_kenshu.IntelligenceElevator.config.CommonConfig;
import jp.co.nssys.shinjin_kenshu.IntelligenceElevator.config.PersonConfig;
import jp.co.nssys.shinjin_kenshu.IntelligenceElevator.creator.ElevatorCreator;
import jp.co.nssys.shinjin_kenshu.IntelligenceElevator.creator.IPersonCreator;
import jp.co.nssys.shinjin_kenshu.IntelligenceElevator.creator.RandomPersonCreator;
import jp.co.nssys.shinjin_kenshu.IntelligenceElevator.input.ConfigReader;
import jp.co.nssys.shinjin_kenshu.IntelligenceElevator.manager.ElevatorSystemManager;

/**
 * エレベータ自動制御システム Main
 * @author kenshu
 *
 */
public class Main {

	public static void main(String[] args) {
		// 起動時に、所定の位置にある設定ファイルを読み込み
		ConfigReader reader = new ConfigReader();
		CommonConfig commonConfig = reader.readCommonConfig("setting_common.config");
		ApartmentConfig apartmentConfig = reader.readApartmentConfig("setting_apartment.config");
		PersonConfig personConfig = reader.readPersonConfig("setting_person.config");

		// ルール説明
		ElevatorSystemManager.printRule(commonConfig, apartmentConfig, personConfig);

		// 準備
		IPersonCreator personCreator = new RandomPersonCreator(personConfig);
		IElevator elevator = ElevatorCreator.create(apartmentConfig);
		ElevatorSystemManager manager = new ElevatorSystemManager(personCreator, elevator, commonConfig, apartmentConfig);

		// 終了条件を満たすまで続ける
		while (!manager.isGameOver()) {
			// 待ち人生成
			manager.createPerson();

			// 現在の状況を表示
			manager.printNowStatus();

			// 待機
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("待機エラー");
			}

			// エレベータ移動
			manager.moveElevator();

			// ストレスが溜まる
			manager.addStress();

			// ストレスチェック
			manager.checkStress();
		}

		// 終了、最終結果を表示
		System.out.println("ストレスが上限に達した人が現れました。終了します。");
		manager.printNowStatus();
	}

}
