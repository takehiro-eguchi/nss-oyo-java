package jp.co.nssys.shinjin_kenshu.IntelligenceElevator.input;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import jp.co.nssys.shinjin_kenshu.IntelligenceElevator.config.ApartmentConfig;
import jp.co.nssys.shinjin_kenshu.IntelligenceElevator.config.CommonConfig;
import jp.co.nssys.shinjin_kenshu.IntelligenceElevator.config.PersonConfig;

/**
 * 設定読み込みクラス
 * @author kenshu
 *
 */
public class ConfigReader {

	/**
	 * 共通設定を読み込む
	 * @param fileName String 読み込みファイル名
	 * @return CommonConfig 設定
	 */
	public CommonConfig readCommonConfig(String fileName) {
		CommonConfig config = new CommonConfig();
		boolean isDef = false;

		File file = new File(fileName);
		try (Scanner scan = new Scanner(file);) {
			String configStr = scan.nextLine();

			// 設定文字列を変換
			int gameOverCount = Integer.parseInt(configStr);
			config.setGameOverCount(gameOverCount);
		} catch (FileNotFoundException e) {
			System.out.println("設定ファイルが存在しませんでした。デフォルト値を使用します。");
			isDef = true;
		} catch (NumberFormatException e) {
			System.out.println("設定ファイルのフォーマットに誤りがありました。デフォルト値を使用します。");
			isDef = true;
		}

		// 読み込み失敗時にデフォルト値を使用
		if (isDef) {
			config.setGameOverCount(CommonConfig.DEF_GAME_OVER_COUNT);
		}

		return config;
	}

	/**
	 * マンション関連の設定を読み込む
	 * @param fileName String 読み込みファイル名
	 * @return ApartmentConfig 設定
	 */
	public ApartmentConfig readApartmentConfig(String fileName) {
		ApartmentConfig config = new ApartmentConfig();
		boolean isDef = false;

		File file = new File(fileName);
		try (Scanner scan = new Scanner(file);) {
			String configStr = scan.nextLine();
			// 設定文字列を分割
			String[] configs = configStr.split(",");

			// 設定内容のフォーマットに誤りがある場合
			if (configStr.equals("") || configStr.trim().length() == 0 || configs.length != 3) {
				throw new IllegalArgumentException();
			}

			// 設定文字列を変換
			int gameFloorNum = Integer.parseInt(configs[0]);
			int floorMaxNum = Integer.parseInt(configs[1]);
			int elevatorMaxNum = Integer.parseInt(configs[2]);
			config.setGameFloorNum(gameFloorNum);
			config.setFloorMaxNum(floorMaxNum);
			config.setElevatorMaxNum(elevatorMaxNum);
		} catch (FileNotFoundException e) {
			System.out.println("設定ファイルが存在しませんでした。デフォルト値を使用します。");
			isDef = true;
		} catch (IllegalArgumentException e) {
			System.out.println("設定ファイルのフォーマットに誤りがありました。デフォルト値を使用します。");
			isDef = true;
		}

		// 読み込み失敗時にデフォルト値を使用
		if (isDef) {
			config.setGameFloorNum(ApartmentConfig.DEF_GAME_FLOOR_NUM);
			config.setFloorMaxNum(ApartmentConfig.DEF_FLOOR_MAX_NUM);
			config.setElevatorMaxNum(ApartmentConfig.DEF_ELEVATOR_MAX_NUM);
		}

		return config;
	}

	/**
	 * 待ち人関連の設定を読み込む
	 * @param fileName String 読み込みファイル名
	 * @return PersonConfig 設定
	 */
	public PersonConfig readPersonConfig(String fileName) {
		PersonConfig config = new PersonConfig();
		boolean isDef = false;

		File file = new File(fileName);
		try (Scanner scan = new Scanner(file);) {
			String configStr = scan.nextLine();
			// 設定文字列を分割
			String[] configs = configStr.split(",");

			// 設定内容のフォーマットに誤りがある場合
			if (configStr.equals("") || configStr.trim().length() == 0 || configs.length != 2) {
				throw new IllegalArgumentException();
			}

			// 設定文字列を変換
			int personTypeNum = Integer.parseInt(configs[0]);
			int normalPersonStressMax = Integer.parseInt(configs[1]);
			config.setPersonTypeNum(personTypeNum);
			config.setNormalPersonStressMax(normalPersonStressMax);
		} catch (FileNotFoundException e) {
			System.out.println("設定ファイルが存在しませんでした。デフォルト値を使用します。");
			isDef = true;
		} catch (IllegalArgumentException e) {
			System.out.println("設定ファイルのフォーマットに誤りがありました。デフォルト値を使用します。");
			isDef = true;
		}

		// 読み込み失敗時にデフォルト値を使用
		if (isDef) {
			config.setPersonTypeNum(PersonConfig.DEF_PERSON_TYPE_NUM);
			config.setNormalPersonStressMax(PersonConfig.DEF_NORMAL_PERSON_STRESS_MAX);
		}

		return config;
	}

}
