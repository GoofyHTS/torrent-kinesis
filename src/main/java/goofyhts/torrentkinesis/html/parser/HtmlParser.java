package goofyhts.torrentkinesis.html.parser;

import org.jsoup.Jsoup;

public final class HtmlParser {

	private HtmlParser() {		
	}
	
	public static String getElementTextById(String html, String id) {
		return Jsoup.parse(html).getElementById(id).text();
	}
}
