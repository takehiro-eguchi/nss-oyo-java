package jp.co.nssys.shinjin2019.tsubasa.arai.jr011.read;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

import jp.co.nssys.shinjin2019.tsubasa.arai.jr011.model.ChartDataRecord;
import jp.co.nssys.shinjin2019.tsubasa.arai.jr011.model.Feature;

public class ChartDataFileReader implements IChartDataReader {

	private String ファイルパス;

	public ChartDataFileReader(String ファイルパス) {
		this.ファイルパス = ファイルパス;
	}

	/**
	 * @throws IOException
	 * @see jp.co.nssys.shinjin2019.tsubasa.arai.jr011.read.IChartDataReader#海図データを読み込み()
	 */
	public ChartDataReadResult 海図データを読み込み() throws IOException {
		ChartDataReadResult chartDataReadResult;
		ChartDataRecordStore chartDataRecordStore = new ChartDataRecordStore();
		Map<Integer, Feature> featureMap = new LinkedHashMap<>();
		try (InputStream is = new FileInputStream(ファイルパス)) {
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "Shift-JIS"));
			String record = br.readLine();

			String[] firstRecodeData = new String[4];
			firstRecodeData = record.split(",");
			double[] firstRecord = new double[4];
			for (int i = 0; i < 4; i++) {
				firstRecord[i] = Double.parseDouble(firstRecodeData[i]);
			}
			chartDataReadResult = new ChartDataReadResult(firstRecord[0], firstRecord[1],
					firstRecord[2], firstRecord[3]);

			while ((record = br.readLine()) != null) {
				String[] dataList = record.split(",");
				String key = dataList[0];
				ChartDataRecord chartDataRecord = Readers.getReader(key).読み込み(dataList, chartDataRecordStore);
				if (!(chartDataRecord instanceof ChartDataRecord)) {
					System.out.println("dekitenai");
				}
				if (chartDataRecord instanceof Feature) {
					featureMap.put(Integer.valueOf(dataList[1]), (Feature) chartDataRecord);
				}
				chartDataRecordStore.レコードを追加(Integer.valueOf(dataList[1]), chartDataRecord);
			}
		}
		chartDataReadResult.setFeatureMap(featureMap);

		return chartDataReadResult;
	}
}
