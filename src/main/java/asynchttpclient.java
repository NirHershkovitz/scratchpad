import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.BoundRequestBuilder;
import org.asynchttpclient.Response;
import org.asynchttpclient.request.body.multipart.FilePart;

import java.io.File;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutionException;

import static org.asynchttpclient.Dsl.asyncHttpClient;

public class asynchttpclient {
    public static void postMultipart() throws ExecutionException, InterruptedException {
        AsyncHttpClient client = asyncHttpClient();
        BoundRequestBuilder builder = client.
                preparePost("http://URL");
        builder.addHeader("Authorization", "Basic something");
        builder.setHeader("Content-Type", "multipart/form-data");
        builder.setHeader("CallbackUrl", "http://yourcallback:port/callback");

        builder.addBodyPart(
                new FilePart("body", new File("input_no_ref.json"),
                        "application/json", Charset.forName("UTF-8"), "ignored"));
        builder.addBodyPart(
                new FilePart("attachments", new File("input.png"),
                        "*",  null, "file1.png"));

        Response response = builder.execute().get();
        System.out.println(response);
    }

    public static void main(String[] args) throws Exception {
        postMultipart();
    }
}


