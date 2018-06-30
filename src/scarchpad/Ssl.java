import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLException;
import javax.net.ssl.TrustManagerFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

public class Ssl {
    /**
     * TEMPORARY - DISABLE SSL Checks
     * @return
     */
//    private SslContext buildSslContext() {
//        try {
//            return SslContextBuilder
//                    .forClient()
//                    .trustManager(InsecureTrustManagerFactory.INSTANCE)
//                    .build();
//        } catch (SSLException e) {
//            throw new RuntimeException(e);
//        }
//    }

//            <dependency>
//            <groupId>com.github.tomakehurst</groupId>
//            <artifactId>wiremock-standalone</artifactId>
//            <version>2.17.0</version>
//            <scope>test</scope>
//            </dependency>
//    @Rule
//    public WireMockRule wireMockRule = new WireMockRule(
//            options().dynamicPort().dynamicHttpsPort()
//                    .keystorePath("test.jks")
//                    .keystorePassword("changeit"));

//    private SslHandler t1() {
//        SSLContext ctx = null;
//        try {
//            ctx = SSLContext.getDefault();
//        } catch (NoSuchAlgorithmException e) {
//            throw new RuntimeException(e);
//        }
//        SSLEngine engine = ctx.createSSLEngine();
//        engine.setUseClientMode(true);
//        return  new SslHandler(engine);
//    }
//    /**
//     * DISABLE SSL Checks
//     * @return
//     */
//    private SslContext buildSslContext_old() {
//        try {
//            return SslContextBuilder
//                    .forClient()
//                    .trustManager(InsecureTrustManagerFactory.INSTANCE)
//                    .build();
//        } catch (SSLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private SslContext buildSslContext() {
//        try {
//            return SslContextBuilder
//                    .forClient()
//                    .trustManager(getInstance())
//                    .build();
//        } catch (SSLException e) {
//            throw new RuntimeException(e);
//        } catch (NoSuchAlgorithmException e) {
//            throw new RuntimeException(e);
//        } catch (CertificateException e) {
//            throw new RuntimeException(e);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }

    private TrustManagerFactory getInstance() throws Exception, IOException, CertificateException, KeyStoreException {
//        javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
//                new javax.net.ssl.HostnameVerifier(){
//
//                    public boolean verify(String hostname,
//                                          javax.net.ssl.SSLSession sslSession) {
//                        //    if (hostname.equals("localhost")) {
//                        return true;
//                        //   }
//                        //   return false;
//                    }
//                });

        KeyStore keystore = KeyStore.getInstance("JKS");
        InputStream jksInputStream =
                //getClass().getClassLoader().getResourceAsStream("path");
                new FileInputStream("path");
        keystore.load(jksInputStream, "replaceWithP".toCharArray());

//        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
//        keyManagerFactory.init(keystore, "replaceWithP".toCharArray());
        TrustManagerFactory factory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        factory.init(keystore);


        return factory;
    }

}
