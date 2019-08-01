package jp.co.nssys.shinjin_kenshu.IntelligenceElevator.creator;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import jp.co.nssys.shinjin_kenshu.IntelligenceElevator.apartment.elevator.IElevator;
import jp.co.nssys.shinjin_kenshu.IntelligenceElevator.config.ApartmentConfig;
import jp.co.nssys.shinjin_kenshu.IntelligenceElevator.config.ElevatorMode;

/**
 * エレベータ生成クラス
 * @author kenshu
 *
 */
public class ElevatorCreator {

	/**
	 * 生成
	 * @return IElevator エレベータインスタンス
	 */
	public static IElevator create(ApartmentConfig apartmentConfig) {
		// 選択肢表示
		for (ElevatorMode elevatorMode : ElevatorMode.values()) {
			System.out.println(elevatorMode);
		}

		int mode = 0;
		IElevator elevator = null;
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		while (elevator == null) {
			try {
				// モード入力
				System.out.print("入力: ");
				mode = Integer.parseInt(scan.nextLine());

				// モードに対応するエレベータを生成
				ElevatorMode elevatorMode = ElevatorMode.valueOf(mode);
				if (elevatorMode != null) {
					Constructor<?> constructor = elevatorMode.getElevatorClass().getConstructor(ApartmentConfig.class);
					elevator = (IElevator) constructor.newInstance(apartmentConfig);
				}
			} catch (NumberFormatException e) {
				System.out.println("入力エラー: 整数入力");
			} catch (InstantiationException | IllegalAccessException | NoSuchMethodException
					| SecurityException | IllegalArgumentException | InvocationTargetException e) {
				System.out.println("生成エラー: エレベータ");
			}

			if (elevator == null) {
				System.out.println("入力エラー: モード不一致");
			}
		}

		return elevator;
	}
}
