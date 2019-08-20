package jp.co.nssys.shinjin2019.tsubasa.arai.jr011.draw;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import jp.co.nssys.shinjin2019.tsubasa.arai.jr011.model.Feature;
import jp.co.nssys.shinjin2019.tsubasa.arai.jr011.model.Point;
import jp.co.nssys.shinjin2019.tsubasa.arai.jr011.read.ChartDataReadResult;
import lombok.Getter;
import lombok.Setter;

public class ChartDataDrawer implements IChartDataDrawer {

	private String fileName;
	@Setter
	@Getter
	private List<ChartCell> chartCellList;

	public ChartDataDrawer(String fileName) {
		this.fileName = fileName;
		this.chartCellList = new ArrayList<>();
	}

	@Override
	public void 海図データを描画(ChartDataReadResult chartDataReadResult) throws IOException {
		Set<ChartCell> chartCellSet = new LinkedHashSet<>();
		for (Integer key : chartDataReadResult.getFeatureMap().keySet()) {
			Feature feature = chartDataReadResult.getFeatureMap().get(key);

			for (Point point : feature.getGeometry().形状が含む全ての点を取得()) {
				ChartCell cell = new ChartCell(point);
				cell.描画文字を設定(feature.getDrawingCharacter().get描画文字());
				chartCellSet.add(cell);
			}
		}
		for (ChartCell chartCell : chartCellSet) {
			chartCellList.add(chartCell);
		}
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));) {
			bw.write(format(chartDataReadResult));
			bw.flush();
		} catch (FileNotFoundException e) {
		}

	}

	public String format(ChartDataReadResult chartDataReadResult) {
		Collections.sort(chartCellList);
		StringBuffer sb = new StringBuffer();
		int n = 0;
		int maxY = (int) Math.round(chartDataReadResult.get描画範囲の最大y座標() * 10);
		int minY = (int) Math.round(chartDataReadResult.get描画範囲の最小y座標() * 10);
		int maxX = (int) Math.round(chartDataReadResult.get描画範囲の最大x座標() * 10);
		int minX = (int) Math.round(chartDataReadResult.get描画範囲の最小x座標() * 10);
		System.out.println(minX);
		System.out.println(minY);
		System.out.println(maxX);
		System.out.println(maxY);
//		for (int i = minX; i < maxX; i++) {
//			sb.append("＿");
//		}
//		sb.append(System.lineSeparator());

		chartCellList.forEach(cell -> {
			System.out.println(cell.get描画文字());
		});

		for (int i = maxY; i > minY; i--) {
//			sb.append("|");
			for (int j = minX; j < maxX; j++) {
				ChartCell cell = chartCellList.get(n);
				double x = cell.getX座標();
				double y = cell.getY座標();
				String drawString = cell.get描画文字();
				if ((int) (x * 10) == j && (int) (y * 10) == i) {
					sb.append(drawString);
					n++;
				} else {
					sb.append("　");
				}
			}
//			sb.append("｜");
			sb.append(System.lineSeparator());
		}
//		for (int i = minX; i < maxX; i++) {
//			sb.append("＿");
//		}
		System.out.println(sb.toString());
		System.out.println(n);
		return sb.toString();
	}

}
