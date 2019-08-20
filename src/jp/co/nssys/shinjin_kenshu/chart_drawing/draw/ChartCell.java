package jp.co.nssys.shinjin_kenshu.chart_drawing.draw;

import jp.co.nssys.shinjin_kenshu.chart_drawing.ChartDataController;

/**
 * 海図のマス。
 */
public class ChartCell {

	/** x座標。 */
	private double x;

	/** y座標。 */
	private double y;

	/** x座標（計算用）。 */
	private int xForCalc;

	/** y座標（計算用）。 */
	private int yForCalc;

	/** 描画文字。 */
	private String drawingCharacter;

	/**
	 * コンストラクタ。
	 *
	 * @param x x座標。
	 * @param y y座標。
	 */
	public ChartCell(double x, double y) {
		this.x = x;
		this.y = y;
		this.xForCalc = (int)Math.round(this.x * ChartDataController.FACTOR_FOR_COORDINATE_CALC);
		this.yForCalc = (int)Math.round(this.y * ChartDataController.FACTOR_FOR_COORDINATE_CALC);
		this.drawingCharacter = "　";
	}

	/**
	 * x座標を取得します。
	 *
	 * @return x座標。
	 */
	public double getX() {
		return this.x;
	}

	/**
	 * y座標を取得します。
	 *
	 * @return y座標。
	 */
	public double getY() {
		return this.y;
	}

	/**
	 * x座標（計算用）を取得します。
	 *
	 * @return x座標（計算用）。
	 */
	public int getXForCalc() {
		return this.xForCalc;
	}

	/**
	 * y座標（計算用）を取得します。
	 *
	 * @return y座標（計算用）。
	 */
	public int getYForCalc() {
		return this.yForCalc;
	}

	/**
	 * 描画文字を取得します。
	 *
	 * @return 描画文字。
	 */
	public String getDrawingCharacter() {
		return this.drawingCharacter;
	}

	/**
	 * 描画文字を設定します。
	 *
	 * @param drawingCharacter 描画文字。
	 */
	public void setDrawingCharacter(String drawingCharacter) {
		this.drawingCharacter = drawingCharacter;
	}
}
