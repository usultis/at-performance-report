package com.usulful.jenkins;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class RestApi {

    private final String mainUrl;

    public RestApi(String mainUrl) {
        this.mainUrl = mainUrl;
    }

    public void deleteJob() throws IOException {
        HttpPost delete = new HttpPost(mainUrl + "job/Jenkins_Acceptance_Tests/doDelete");
        HttpResponse response = new DefaultHttpClient().execute(delete);
        LoggerFactory.getLogger(this.getClass()).debug("Delete response:" + response.getStatusLine().getStatusCode());
    }
}
