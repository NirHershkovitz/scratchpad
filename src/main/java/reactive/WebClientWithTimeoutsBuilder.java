package reactive;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.Nonnull;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

/**
 * Builder to {@link WebClient}, that allows setting connection and read timeouts
 * <p>
 * @author Nir Hershkovitz
 */
@Component
public class WebClientWithTimeoutsBuilder {

    public WebClient build(@Nonnull String baseUrl, int connectionTimeout, int readTimeout) {
        return WebClient.
                builder().
                clientConnector(buildClientConnectorAndSetTimeouts(connectionTimeout, readTimeout)).
                baseUrl(baseUrl).
                build();
    }

    private ReactorClientHttpConnector buildClientConnectorAndSetTimeouts(int connectionTimeout, int readTimeout) {
        return new ReactorClientHttpConnector(options ->
                options.
                        option(ChannelOption.CONNECT_TIMEOUT_MILLIS, connectionTimeout).
                        onChannelInit(channel -> {
                            channel.pipeline().addLast(new ReadTimeoutHandler(readTimeout, MILLISECONDS));
                            return false;
                        }));
    }
}
