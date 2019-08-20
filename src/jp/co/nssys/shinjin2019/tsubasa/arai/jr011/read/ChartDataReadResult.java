package jp.co.nssys.shinjin2019.tsubasa.arai.jr011.read;

import java.util.Map;

import jp.co.nssys.shinjin2019.tsubasa.arai.jr011.model.Feature;
import lombok.Getter;
import lombok.Setter;

public class ChartDataReadResult {

	@Getter
	private boolean 成功したかどうか;
	@Getter
	private double 描画範囲の最小x座標;
	@Getter
	private double 描画範囲の最小y座標;
	@Getter
	private double 描画範囲の最大x座標;
	@Getter
	private double 描画範囲の最大y座標;
	@Getter
	@Setter
	private Map<Integer, Feature> featureMap;

	public ChartDataReadResult(double 描画範囲の最小x座標, double 描画範囲の最小y座標,
			double 描画範囲の最大x座標, double 描画範囲の最大y座標) {
		this.描画範囲の最小x座標 = 描画範囲の最小x座標;
		this.描画範囲の最小y座標 = 描画範囲の最小y座標;
		this.描画範囲の最大x座標 = 描画範囲の最大x座標;
		this.描画範囲の最大y座標 = 描画範囲の最大y座標;
	}
}
