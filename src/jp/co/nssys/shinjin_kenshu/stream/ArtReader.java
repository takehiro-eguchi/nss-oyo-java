package jp.co.nssys.shinjin_kenshu.stream;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ArtReader implements AutoCloseable {

	private final BufferedReader reader;

	public ArtReader(String filename) throws FileNotFoundException {
		this.reader = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(filename)));
	}

	public String read() {
		try {
			return this.reader.readLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void forEach(Consumer<String> consumer) {
		stream().forEach(consumer);
	}

	public Stream<String> stream() {
		Iterator<String> iterator = new Iterator<String>() {
			private String line;

			@Override
			public String next() { return this.line; }

			@Override
			public boolean hasNext() {
				this.line = read();
				return line != null;
			}
		};
		Spliterator<String> spliterator = Spliterators.spliteratorUnknownSize(
				iterator, Spliterator.NONNULL);
		Stream<String> stream = StreamSupport.stream(spliterator, false);
		return stream;
	}

	@Override
	public void close() throws Exception {
		try (BufferedReader tmp = this.reader) {
			// 何もしない
		}
	}

	public static void main(String[] args) {
		try (ArtReader reader = new ArtReader("art_collection.csv")) {
			reader.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
