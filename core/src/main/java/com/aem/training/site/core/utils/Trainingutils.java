package com.aem.training.site.core.utils;

import com.aem.training.site.core.constants.CommonConstants;
import com.aem.training.site.core.entity.ClientResponse;
import com.google.common.base.Charsets;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Map;

public class Trainingutils {

    public static ClientResponse getData(final String url,  final Map<String,String> header) throws IOException {
        final HttpGet httpGet = new HttpGet(url);
        String result  = StringUtils.EMPTY;

        httpGet.setHeader(CommonConstants.CONTENT_TYPE , CommonConstants.CONTENT_TYPE_JSON);
        if(!MapUtils.isEmpty(header))
        {
            for(Map.Entry<String , String> key : header.entrySet())
            {
                httpGet.setHeader(key.getKey(), key.getValue());
            }
        }
        CloseableHttpClient httpClient = HttpClients.createDefault();
        final CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
        HttpEntity httpEntity = httpResponse.getEntity();
        ClientResponse clientResponse = new ClientResponse();
        clientResponse.setStatusCode(httpResponse.getStatusLine().getStatusCode());
        if(httpEntity!=null)
        {
            result = EntityUtils.toString(httpEntity, Charsets.UTF_8);
            clientResponse.setData(result);
             EntityUtils.consume(httpEntity);
        }
        return clientResponse;
    }
}
