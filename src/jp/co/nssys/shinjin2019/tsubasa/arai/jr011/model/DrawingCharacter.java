package jp.co.nssys.shinjin2019.tsubasa.arai.jr011.model;

import lombok.Getter;

/**
 * 描画文字のモデル
 * @author tsubasa.arai
 *
 */
public class DrawingCharacter extends ChartDataRecord {
	/**
	 * 描画文字
	 */
	@Getter
	private String 描画文字;

	/**
	 * コンストラクタ
	 * @param 描画文字
	 */
	public DrawingCharacter(String 描画文字) {
		this.描画文字 = 描画文字;
	}

}
