package jp.co.nssys.shinjin_kenshu.IntelligenceElevator.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import jp.co.nssys.shinjin_kenshu.IntelligenceElevator.apartment.Apartment;
import jp.co.nssys.shinjin_kenshu.IntelligenceElevator.apartment.Floor;
import jp.co.nssys.shinjin_kenshu.IntelligenceElevator.apartment.elevator.IElevator;
import jp.co.nssys.shinjin_kenshu.IntelligenceElevator.config.ApartmentConfig;
import jp.co.nssys.shinjin_kenshu.IntelligenceElevator.config.CommonConfig;
import jp.co.nssys.shinjin_kenshu.IntelligenceElevator.config.PersonConfig;
import jp.co.nssys.shinjin_kenshu.IntelligenceElevator.creator.IPersonCreator;

/**
 * エレベータシステム管理
 * @author kenshu
 *
 */
public class ElevatorSystemManager {

	/** 諦めた人数 */
	private int outCount;

	/** 移動できた人数 */
	private int clearCount;

	/** フロア数 */
	private int floorNum;

	/** マンション */
	private Apartment apartment;

	/** 住民生成 */
	private IPersonCreator personCreator;

	/** 共通設定 */
	private CommonConfig commonConfig;

	/** 平均ストレス値 */
	private double stressAverage;

	/**
	 * ルール表示
	 */
	public static void printRule(CommonConfig commonConfig, ApartmentConfig apartmentConfig, PersonConfig personConfig) {
		System.out.printf("・一度にエレベータに乗れるのは%d人まで\n", apartmentConfig.getElevatorMaxNum());
		System.out.printf("・エレベータを動かすごとに、待っている住民のストレスが「1」溜まる\n");
		System.out.printf("・ストレスの上限は「%d」\n", personConfig.getNormalPersonStressMax());
		System.out.printf("・%d人諦めて階段を使ったら終了\n", commonConfig.getGameOverCount());

		System.out.println();
	}

	/**
	 * コンストラクタ
	 * @param floor int フロア数
	 * @param personCraetor IPersonCreator 待ち人生成用インスタンス
	 * @param elevator IElevator エレベータインスタンス
	 * @param commonConfig CommonConfig 共通設定
	 * @parama apartmentConfig ApartmentConfig マンション関連設定
	 */
	public ElevatorSystemManager(IPersonCreator personCreator, IElevator elevator, CommonConfig commonConfig, ApartmentConfig apartmentConfig) {
		// 各種変数初期化
		this.outCount = 0;
		this.clearCount = 0;
		this.floorNum = apartmentConfig.getGameFloorNum();
		this.personCreator = personCreator;
		this.stressAverage = 0;
		this.commonConfig = commonConfig;

		// フロア生成
		List<Floor> floorList = new ArrayList<>();
		for (int i = 0; i < this.floorNum; i++) {
			floorList.add(new Floor(apartmentConfig, i + 1));
		}
		elevator.setNowFloor(1);

		this.apartment = new Apartment(apartmentConfig, floorList, elevator);
	}

	/**
	 * 移動できた人数のgetter
	 * @return int 移動できた人数
	 */
	public int getClearCount() {
		return this.clearCount;
	}

	/**
	 * ゲームオーバーかどうか
	 * @return boolean
	 */
	public boolean isGameOver() {
		return this.outCount >= this.commonConfig.getGameOverCount();
	}

	/**
	 * 待ち人を生成する
	 */
	public void createPerson() {
		// 1階には待ち住民を作らない
		for (int i = 1; i < this.floorNum; i++) {
			// 生成する人数をランダムに設定する
			int createNum = new Random().nextInt(2);

			for (int j = 0; j < createNum; j++) {
				this.apartment.addPersonToFloor(i + 1, this.personCreator.create());
			}
		}
	}

	/**
	 * エレベータを移動させる
	 */
	public void moveElevator() {
		// 移動先を自動で設定
		int floorNum = this.apartment.moveElevator();
		System.out.printf("移動先[階]:%d\n", floorNum);
		if (floorNum == 1) {
			// 1階の場合はエレベータから全員降ろす
			this.clearCount += this.apartment.removePersonsFromElevator();

			// 平均ストレス値を算出
			if (this.stressAverage == 0) {
				this.stressAverage = this.apartment.calcStressAverage();
			} else {
				this.stressAverage = (this.stressAverage + this.apartment.calcStressAverage()) / 2;
			}
		} else {
			// 1階以外の場合はそのフロアの待ち人を乗せられるだけ乗せる
			this.apartment.addPersonsToElevator();
		}
	}

	/**
	 * 全てのフロアの待ち住民にストレスを加える
	 */
	public void addStress() {
		for (int i = 0; i < this.floorNum; i++) {
			// 指定したフロアの待ち人にストレスを加える
			this.apartment.addStress(i + 1);
		}
	}

	/**
	 * ストレスチェック
	 */
	public void checkStress() {
		for (int i = 0; i < this.floorNum; i++) {
			// 指定したフロアの、ストレスが上限に達した待ち人を取り除く
			this.outCount += this.apartment.removeStressfulPerson(i + 1);
		}
	}

	/**
	 * 現在の状況を表示
	 */
	public void printNowStatus() {
		System.out.printf("out:%d clear:%d\n", this.outCount, this.clearCount);
		System.out.printf("平均ストレス値: %.2f\n", this.stressAverage);

		System.out.println(this.apartment.toString());
	}
}
