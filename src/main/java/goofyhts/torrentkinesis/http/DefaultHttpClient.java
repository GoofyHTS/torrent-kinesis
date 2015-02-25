/*
The MIT License (MIT)
Copyright (c) 2015 GoofyHTS
Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
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

	private CloseableHttpClient client;
	HttpClientContext context;
	private String username;
	private String password;
	
	public DefaultHttpClient(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	@Override
	public String getURL(String url) {
		System.out.println("Request="+url);
		String responseString = null;
		try {
			HttpGet httpGet = new HttpGet(url);		
			CloseableHttpResponse response = client.execute(httpGet, context);
			responseString = IOUtils.toString(response.getEntity().getContent());
		}
		catch(ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return responseString;
	}

	@Override
	public String postURL(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void open() {
		client = HttpClients.createDefault();	
		context = new HttpClientContext();
		CredentialsProvider credProv = new BasicCredentialsProvider();
		credProv.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(username, password));
		context.setCredentialsProvider(credProv);
	}

	@Override
	public void close() {
		if (client != null) {
			try {
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
