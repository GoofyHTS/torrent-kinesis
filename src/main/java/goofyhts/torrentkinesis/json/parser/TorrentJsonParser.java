package goofyhts.torrentkinesis.json.parser;

/**
 * Defines a Json parser
 * @author GoofyHTS
 *
 */
public interface TorrentJsonParser {

	<T> T jsonToObject(String json, Class<T> classOfT);
}
