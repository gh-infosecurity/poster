import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: artur
 * Date: 27.10.15
 * Time: 23:09
 * To change this template use File | Settings | File Templates.
 */
public class ApachePoster {
    public String post() throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://www.mkyong.com/webservices/jax-rs/restfull-java-client-with-java-net-url/");

        StringEntity input = new StringEntity("" +
                "{" +
                "\"key\": \"$1$12309856$euBrWcjT767K2sP9MHcVS/\"," +
                "\"echo\": \"test\"" +
                "}");
        input.setContentType("application/json");
        httpPost.setEntity(input);

        CloseableHttpResponse response = httpclient.execute(httpPost);
        HttpEntity entity = response.getEntity();
        InputStream content = entity.getContent();


        return IOUtils.toString(content, getEncoding(entity));
    }

    private String getEncoding(HttpEntity entity) {
        String[] contentTypElements = entity.getContentType().getValue().split(" ");
        String[] encoding = contentTypElements[1].split("\\=");
        return encoding[1];
    }
}
