package hello.world;


import io.micronaut.core.io.buffer.ByteBuffer;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.MutableHttpRequest;
import io.micronaut.http.client.RxStreamingHttpClient;
import io.reactivex.Flowable;
import org.junit.jupiter.api.Test;

import java.net.URL;


public class HelloWorldHeaderTest {

    @Test
    public void testGetNullableHeaderNotSet() throws Exception {
        URL baseURL = new URL("http://localhost:8080");
        RxStreamingHttpClient rxclient = RxStreamingHttpClient.create(baseURL);

        MutableHttpRequest<?> request = HttpRequest.GET("/header/getNullableHeader").
                accept(MediaType.TEXT_PLAIN_TYPE);

        Flowable<String> responses = rxclient.retrieve(request);
        for (String content : responses.blockingIterable()) {
            System.out.println(content);
        }
    }

    //Fails with io.micronaut.http.client.exceptions.HttpClientResponseException: Invalid JSON
    @Test
    public void testPutNullableHeaderNotSet() throws Exception {
        URL baseURL = new URL("http://localhost:8080");
        RxStreamingHttpClient rxclient = RxStreamingHttpClient.create(baseURL);

        MutableHttpRequest<?> request = HttpRequest.PUT("/header/putNullableHeader", "body".getBytes()).
                accept(MediaType.TEXT_PLAIN_TYPE);

        Flowable<String> responses = rxclient.retrieve(request);
        for (String content : responses.blockingIterable()) {
            System.out.println(content);
        }
    }

    @Test
    public void testPutNullableHeaderSet() throws Exception {
        URL baseURL = new URL("http://localhost:8080");
        RxStreamingHttpClient rxclient = RxStreamingHttpClient.create(baseURL);

        MutableHttpRequest<?> request = HttpRequest.PUT("/header/putNullableHeader", "body".getBytes()).
                header("foo", "bar").
                accept(MediaType.TEXT_PLAIN_TYPE);

        Flowable<String> responses = rxclient.retrieve(request);
        for (String content : responses.blockingIterable()) {
            System.out.println(content);
        }
    }

    @Test
    public void testPutOptionalHeaderNotSet() throws Exception {
        URL baseURL = new URL("http://localhost:8080");
        RxStreamingHttpClient rxclient = RxStreamingHttpClient.create(baseURL);

        MutableHttpRequest<?> request = HttpRequest.PUT("/header/putOptionalHeader", "body".getBytes()).
                accept(MediaType.TEXT_PLAIN_TYPE);

        Flowable<String> responses = rxclient.retrieve(request);
        for (String content : responses.blockingIterable()) {
            System.out.println(content);
        }
    }

    @Test
    public void testPutOptionalHeaderSet() throws Exception {
        URL baseURL = new URL("http://localhost:8080");
        RxStreamingHttpClient rxclient = RxStreamingHttpClient.create(baseURL);

        MutableHttpRequest<?> request = HttpRequest.PUT("/header/putOptionalHeader", "body".getBytes()).
                header("foo", "bar").
                accept(MediaType.TEXT_PLAIN_TYPE);

        Flowable<String> responses = rxclient.retrieve(request);
        for (String content : responses.blockingIterable()) {
            System.out.println(content);
        }
    }
}
