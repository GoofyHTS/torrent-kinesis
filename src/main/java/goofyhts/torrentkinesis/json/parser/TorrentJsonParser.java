package goofyhts.torrentkinesis.json.parser;

public interface TorrentJsonParser {

	<T> T jsonToObject(String json, Class<T> classOfT);
}
