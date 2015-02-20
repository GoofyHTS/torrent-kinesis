package goofyhts.torrentkinesis.http;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import goofyhts.torrentkinesis.TorrentHttpClient;

public class DefaultHttpClient implements TorrentHttpClient {

	private String username;
	private String password;
	
	public DefaultHttpClient(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	@Override
	public String getURL(String url) {
		try(CloseableHttpClient client = HttpClients.createDefault()) {
			HttpClientContext context = new HttpClientContext();
			CredentialsProvider credProv = new BasicCredentialsProvider();
			credProv.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(username, password));
			context.setCredentialsProvider(credProv);
			HttpGet httpGet = new HttpGet(url);
			
			CloseableHttpResponse response = client.execute(httpGet,context);
			return IOUtils.toString(response.getEntity().getContent());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String postURL(String url) {
		// TODO Auto-generated method stub
		return null;
	}

}
