package org.example;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.ssl.TrustStrategy;
import org.junit.Test;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

public class RestTemplateTest
{
  @Test
  public void testRESTCall() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException
  {
    RestTemplate restTemplate = getRestTemplate();
    String url = "https://api.stubhubsandbox.com/search/catalog/events/v3";
    Map<String, String> mvm = new HashMap<>();
    mvm.put("Authorization", "Bearer TOKEN");

    Object object = restTemplate.postForObject(url, null, Object.class, mvm);

    assertNotNull(object);
  }

  private RestTemplate getRestTemplate() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException
  {
    TrustStrategy acceptingTrustStrategy = new TrustSelfSignedStrategy();
    SSLContext sslContext = SSLContexts.custom()
        .loadTrustMaterial(null, acceptingTrustStrategy)
        .build();

    SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);

    CloseableHttpClient httpClient = HttpClients.custom()
        .setSSLSocketFactory(csf)
        .build();

    HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
    requestFactory.setHttpClient(httpClient);

    return new RestTemplate(requestFactory);
  }
}
