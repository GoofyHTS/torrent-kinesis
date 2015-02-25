package goofyhts.torrentkinesis.json.parser.gson;

import com.google.gson.Gson;

import goofyhts.torrentkinesis.exception.FailureParsingJsonException;
import goofyhts.torrentkinesis.json.parser.TorrentJsonParser;

public class GsonTorrentParser implements TorrentJsonParser {

	@Override
	public <T> T jsonToObject(String json, Class<T> classOfT) {
		T obj = null;
		try {
			obj = new Gson().fromJson(json, classOfT);
		}
		catch(Exception e) {
			throw new FailureParsingJsonException(json);
		}
		return obj;
	}	
}
