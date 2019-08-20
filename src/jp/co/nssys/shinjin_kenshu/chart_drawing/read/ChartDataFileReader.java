package jp.co.nssys.shinjin_kenshu.chart_drawing.read;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.nssys.shinjin_kenshu.chart_drawing.model.ChartDataRecord;
import jp.co.nssys.shinjin_kenshu.chart_drawing.model.Feature;

/**
 * 海図データをファイルから読み込むオブジェクト。
 */
public class ChartDataFileReader implements IChartDataReader {

	/** 地物レコードの種類ID。 */
	private static final int FEATURE_RECORD_TYPE_ID = 10;

	/** 点レコードの種類ID。 */
	private static final int POINT_RECORD_TYPE_ID = 20;

	/** 線レコードの種類ID。 */
	private static final int LINE_RECORD_TYPE_ID = 25;

	/** 面レコードの種類ID。 */
	private static final int SURFACE_RECORD_TYPE_ID = 30;

	/** 描画文字レコードの種類ID。 */
	private static final int DRAWING_CHARACTER_RECORD_TYPE_ID = 40;

	/** レコードのデータ区切り文字。 */
	private static final String RECORD_DATA_SEPARATOR = ",";

	/** ファイルパス。 */
	private String filePath;

	/**
	 * コンストラクタ。
	 *
	 * @param filePath ファイルパス。
	 */
	public ChartDataFileReader(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ChartDataReadResult read() {

		// レコードの種類IDとレコード読み込みオブジェクトを対応付け
		@SuppressWarnings("rawtypes")
		Map<Integer, ChartDataRecordReaderBase> recordReaders = new HashMap<Integer, ChartDataRecordReaderBase>() {
			{
				put(FEATURE_RECORD_TYPE_ID, new FeatureRecordReader());
				put(POINT_RECORD_TYPE_ID, new PointRecordReader());
				put(LINE_RECORD_TYPE_ID, new LineRecordReader());
				put(SURFACE_RECORD_TYPE_ID, new SurfaceRecordReader());
				put(DRAWING_CHARACTER_RECORD_TYPE_ID, new DrawingCharacterRecordReader());
			}
		};

		double minX = Double.NaN;
		double minY = Double.NaN;
		double maxX = Double.NaN;
		double maxY = Double.NaN;
		ChartDataRecordStore recordStore = new ChartDataRecordStore();
		List<Feature> features = new ArrayList<Feature>();

		// 読み込み
		try {
			boolean isFirstLine = true;
			for (String line : Files.readAllLines(Paths.get(this.filePath))) {
				if (isFirstLine) {
					// 1行目はデータ全体の座標範囲
					String[] coordinates = line.split(RECORD_DATA_SEPARATOR);
					if (coordinates.length != 4) {
						return ChartDataReadResult.FAILURE;
					}

					minX = Double.parseDouble(coordinates[0]);
					minY = Double.parseDouble(coordinates[1]);
					maxX = Double.parseDouble(coordinates[2]);
					maxY = Double.parseDouble(coordinates[3]);

					isFirstLine = false;
					continue;
				}

				// 2行目以降
				String[] dataArray = line.split(RECORD_DATA_SEPARATOR);

				// レコードの種類に応じた読み込みオブジェクトを使ってレコードを読み込み
				int recordTypeId = Integer.parseInt(dataArray[0]);
				ChartDataRecord record = recordReaders.get(recordTypeId).read(dataArray, recordStore);
				if (record == null) {
					return ChartDataReadResult.FAILURE;
				}

				if (record instanceof Feature) {
					features.add((Feature)record);
				} else {
					if (!recordStore.addRecord(Integer.parseInt(dataArray[1]), record)) {
						return ChartDataReadResult.FAILURE;
					}
				}
			}
		} catch (IOException | NumberFormatException e) {
			return ChartDataReadResult.FAILURE;
		}

		return new ChartDataReadResult(true, minX, minY, maxX, maxY, features);
	}
}
