package jp.co.nssys.shinjin_kenshu.chart_drawing.read;

import java.util.ArrayList;
import java.util.List;

import jp.co.nssys.shinjin_kenshu.chart_drawing.model.Feature;

/**
 * 海図データ読み込み結果。
 */
public class ChartDataReadResult {

	/** 読み込み失敗の結果。 */
	public static final ChartDataReadResult FAILURE = new ChartDataReadResult(
			false, Double.NaN, Double.NaN, Double.NaN, Double.NaN, new ArrayList<Feature>());

	/** 読み込みに成功したかどうか。 */
	private boolean isSuccess;

	/** 海図データ座標範囲の最小x座標。 */
	private double minX;

	/** 海図データ座標範囲の最小y座標。 */
	private double minY;

	/** 海図データ座標範囲の最大x座標。 */
	private double maxX;

	/** 海図データ座標範囲の最大y座標。 */
	private double maxY;

	/** 海図データの地物のリスト。 */
	private List<Feature> features;

	/**
	 * コンストラクタ。
	 *
	 * @param isSuccess 読み込みに成功したかどうか。
	 * @param minX 海図データ座標範囲の最小x座標。
	 * @param minY 海図データ座標範囲の最小y座標。
	 * @param maxX 海図データ座標範囲の最大x座標。
	 * @param maxY 海図データ座標範囲の最大y座標。
	 * @param features 海図データの地物のリスト。
	 */
	public ChartDataReadResult(boolean isSuccess, double minX, double minY, double maxX, double maxY, List<Feature> features) {
		this.isSuccess = isSuccess;
		this.minX = minX;
		this.minY = minY;
		this.maxX = maxX;
		this.maxY = maxY;
		this.features = features;
	}

	/**
	 * 読み込みに成功したかどうかを取得します。
	 *
	 * @return 読み込みに成功したかどうか。
	 */
	public boolean getIsSuccess() {
		return this.isSuccess;
	}

	/**
	 * 海図データ座標範囲の最小x座標を取得します。
	 *
	 * @return 海図データ座標範囲の最小x座標。
	 */
	public double getMinX() {
		return this.minX;
	}

	/**
	 * 海図データ座標範囲の最小y座標を取得します。
	 *
	 * @return 海図データ座標範囲の最小y座標。
	 */
	public double getMinY() {
		return this.minY;
	}

	/**
	 * 海図データ座標範囲の最大x座標を取得します。
	 *
	 * @return 海図データ座標範囲の最大x座標。
	 */
	public double getMaxX() {
		return this.maxX;
	}

	/**
	 * 海図データ座標範囲の最大y座標を取得します。
	 *
	 * @return 海図データ座標範囲の最大y座標。
	 */
	public double getMaxY() {
		return this.maxY;
	}

	/**
	 * 海図データの地物のリストを取得します。
	 *
	 * @return 海図データの地物のリスト。
	 */
	public List<Feature> getFeatures() {
		return new ArrayList<Feature>(this.features);
	}
}
