package jp.co.nssys.shinjin_kenshu.lombok;

import lombok.Builder;
import lombok.Cleanup;
import lombok.Data;

public class LombokSample {

//	@ToString
//	@EqualsAndHashCode
	@Data
	@Builder
	public static class Art {
		private int id;
		private String title;
		private String author;
		private int state;
		public void close() {
			System.out.println("Close!!");
		}
	}

	public static void main(String[] args) {
//		Art art = new Art();
//		art.setId(0);
//		art.setTitle("Guernica");
//		art.setAuthor("Picasso");
//		art.setState(1);
//		System.out.println(art);
		@Cleanup Art art = Art.builder()
			.id(0).title("Guernica").author("Picasso").state(1)
			.build();
	}
}
