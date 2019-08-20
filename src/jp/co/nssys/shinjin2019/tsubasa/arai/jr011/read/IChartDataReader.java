package jp.co.nssys.shinjin2019.tsubasa.arai.jr011.read;

import java.io.IOException;

public interface IChartDataReader {
	public abstract ChartDataReadResult 海図データを読み込み() throws IOException;
}
