package jp.co.nssys.shinjin_kenshu.text;

import dnl.utils.text.table.TextTable;

public class Sample {

	public static void main(String[] args) {
		String[] names = {"#", "Title", "Author", "State  " };
		Object[][] data = {
				{1,"Guernica","Picasso", "lending"},
				{1,"","", ""},
				{5,"The Tower of Babel","Bruegel", ""},
		};
		TextTable table = new TextTable(names, data);
		table.printTable();

//		List<String> nameList = Arrays.asList(names);
//		List<List<String>> rowsList = Arrays.asList(
//				Arrays.asList("1","Guernica","Picasso", "貸出中"),
//				Arrays.asList("5","The Tower of Babel","Bruegel", " ")
//				);
//		Board board = new Board(75);
//		String tableString = board.setInitialBlock(
//				new Table(board, 75, nameList, rowsList)
//					.tableToBlocks()).build().getPreview();
//		System.out.println(tableString);
	}

//	#,,,
//	2,Primavera,Botticelli,1
//	3,De Nachtwacht,Rembrandt,0
//	4,Meduse,caravaggio,0
}
