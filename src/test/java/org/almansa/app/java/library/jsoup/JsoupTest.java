package org.almansa.app.java.library.jsoup;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;

public class JsoupTest {
	@Test
	public void jsoup_url로_문서가져오기() throws IOException {
		try {
			Document document = Jsoup.connect("https://jsoup.org/").get();
			String title = document.title();
		} catch (IOException e) {
			throw e;
		}
	}

	@Test
	public void jsoup_파싱하기() {
		String html = "<html><head><title>First parse</title></head>"
				+ "<body><p id='hello'>HelloWorld</p></body></html>";
		Document doc = Jsoup.parse(html);

		assertEquals("First parse", doc.title());
	}

	@Test
	public void jsoup_id로_가져온후_텍스트변경하기() {
		String html = "<html><head><title>First parse</title></head>"
				+ "<body><p id='hello'>HelloWorld</p></body></html>";
		Document doc = Jsoup.parse(html);
		Element element = doc.getElementById("hello");
		
		assertEquals("hello", element.id());
		
		element.text("Hello Universe");
		
		Element element2 = doc.getElementById("hello");
		assertEquals("Hello Universe", element2.text());
	}
}
