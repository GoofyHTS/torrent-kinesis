package goofyhts.torrentkinesis.test;

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
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Assert;
import org.junit.Test;

public class HttpTest {

	@Test
	public void testGet() {
		try(CloseableHttpClient client = HttpClients.createDefault()) {
			HttpClientContext context = new HttpClientContext();
			CredentialsProvider credProv = new BasicCredentialsProvider();
			credProv.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials("root","Whcinhry21#"));
			context.setCredentialsProvider(credProv);
			HttpGet httpGet = new HttpGet("http://localhost:8150/gui/token.html");
			
			CloseableHttpResponse response = client.execute(httpGet,context);
			String responseBody = IOUtils.toString(response.getEntity().getContent());
			System.out.println(responseBody);
			Document doc = Jsoup.parse(responseBody);
			System.out.println(doc.getElementById("token").text());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Assert.assertTrue(true);
	}
}
