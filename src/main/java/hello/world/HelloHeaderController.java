package hello.world;

import io.micronaut.core.io.buffer.ByteBuffer;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.MutableHttpRequest;
import io.micronaut.http.annotation.*;
import io.micronaut.http.client.RxStreamingHttpClient;
import io.reactivex.Flowable;
import io.reactivex.Single;

import javax.annotation.Nullable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

@Controller("/header")
public class HelloHeaderController {

    private final RxStreamingHttpClient rxclient;

    public HelloHeaderController() throws MalformedURLException {
        URL baseURL = new URL("http://httpbin.org");
        rxclient = RxStreamingHttpClient.create(baseURL);
    }

    @Get(value = "/getNullableHeader", produces = MediaType.TEXT_PLAIN)
    public String getNullableHeader(@Nullable @Header("Foo") final String auth) {
        return "get done";
    }


    @Put(value = "/putNullableHeader", consumes = MediaType.ALL, produces = MediaType.TEXT_PLAIN)
    public String putNullableHeader(@Body final Flowable<byte[]> contents,
                                                              @Nullable @Header("foo") final String auth) {

        return "put done";

    }

    @Put(value = "/putOptionalHeader", consumes = MediaType.ALL, produces = MediaType.TEXT_PLAIN)
    public String putOptionalHeader(@Body final Flowable<byte[]> contents,
                                                              @Header("foo") final Optional<String> auth) {


        return "put done";

    }

}