package com.rafgj.easypoi;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class HttpClientUtils {
    // 静态常量和变量声明
    private static final int MAX_TOTAL_CONN = 600;
    private static final int MAX_CONN_PER_HOST = 300;
    private static final int SOCKET_TIMEOUT = 5000;
    private static final int CONNECTION_TIMEOUT = 200;
    private static final int CONNECTION_MANAGER_TIMEOUT = 100;

    private static CloseableHttpClient httpclient;
    private static PoolingHttpClientConnectionManager connMrg;
    private static String encoding = StandardCharsets.UTF_8.name();
    private static final ScheduledExecutorService scheduledService = Executors.newScheduledThreadPool(2);
    private static final String header = "\n" +
            "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhNmYzNjU3OS0yYzZhLTQyYTYtOGVjMi1kNzc2ODU2ZjhjMzEiLCJpYXQiOjE3MjM3OTk4OTUsImV4cCI6MTcyMzgwMzQ5NX0.TzY_uNpFHv7D-sI0u01aESpvkacpl6oQOkE1-pO9Zici9TyIAtCE7tPYIh6tKLd0TjJhtoNZoq_kCNF_FDyFmw";

    // 静态代码块，用于初始化 HttpClient 和连接管理器，并设置 JVM 退出时关闭 HttpClient
    static {
        init();
        destroyByJvmExit();
    }

    // 初始化连接管理器和 HttpClient
    private static void init() {
        connMrg = new PoolingHttpClientConnectionManager();
        connMrg.setMaxTotal(MAX_TOTAL_CONN);
        connMrg.setDefaultMaxPerRoute(MAX_CONN_PER_HOST);
        CookieStore cookieStore = new BasicCookieStore();
//        cookieStore.addCookie(new BasicClientCookie("Stoken", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJmODMyMDkyMi1lMjRkLTRiMjEtOWYyOC03MWQ4ZjNiMGIzODEiLCJpYXQiOjE3MjI0ODU4MTgsImV4cCI6MTcyMjQ4OTQxOH0.InerLEHHMw77ovqjp7fLmRAyJlGDv0O-3e2ztq-s12eqlTdv4hH33iNOcPkDIAH8lMt12LIL8IDaoG3yTN5i9g"));
        httpclient = HttpClients.custom()
                .setConnectionManager(connMrg)
                .setDefaultCookieStore(cookieStore)
                .setDefaultRequestConfig(HttpClientUtils.defaultRequestConfig())
                .build();

        // 定时任务，定期清理过期和空闲连接
        scheduledService.scheduleAtFixedRate(() -> {
            connMrg.closeExpiredConnections();
            connMrg.closeIdleConnections(CONNECTION_MANAGER_TIMEOUT, TimeUnit.MILLISECONDS);
        }, 0, CONNECTION_MANAGER_TIMEOUT, TimeUnit.MILLISECONDS);
    }

    // JVM 退出时关闭 HttpClient
    private static void destroyByJvmExit() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                httpclient.close();
            } catch (IOException e) {
            }
        }));
    }

    // 创建 HttpClientContext
    private static HttpClientContext createContext() {
        return HttpClientContext.create();
    }

    // 创建默认的 RequestConfig
    private static RequestConfig defaultRequestConfig() {
        return RequestConfig.custom()
                .setConnectTimeout(CONNECTION_TIMEOUT)
                .setSocketTimeout(SOCKET_TIMEOUT)
                .setConnectionRequestTimeout(CONNECTION_MANAGER_TIMEOUT)
                .build();
    }

    // 发起带参数的 POST 表单请求，返回字符串结果
    public static String postWithParamsForString(String url, List<NameValuePair> params) {
        HttpPost httpPost = new HttpPost();
        try {
            URI uri = new URIBuilder(url).build();
            httpPost.setURI(uri);
//            httpPost.setHeader("Token", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkNjZmY2ZjZS04ODFiLTQzNGItYjc3NC1hYTQzYzk5ZTQyOTUiLCJpYXQiOjE3MjI0ODE4ODEsImV4cCI6MTcyMjQ4NTQ4MX0.D4nmS1FwPNyKZiCgI6laB9XwU3K_ERVNK4zdyefxPROqFZilJg-OsWvs1ZJErHDcnW1L-bCjRhbjhGNr2utGCg");
            httpPost.setHeader("Stoken", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJmODMyMDkyMi1lMjRkLTRiMjEtOWYyOC03MWQ4ZjNiMGIzODEiLCJpYXQiOjE3MjI0ODU4MTgsImV4cCI6MTcyMjQ4OTQxOH0.InerLEHHMw77ovqjp7fLmRAyJlGDv0O-3e2ztq-s12eqlTdv4hH33iNOcPkDIAH8lMt12LIL8IDaoG3yTN5i9g");
            httpPost.setEntity(new UrlEncodedFormEntity(params, StandardCharsets.UTF_8));

            return executeRequest(httpPost);
        } catch (URISyntaxException | IOException e) {
        } finally {
            httpPost.releaseConnection();
        }
        return null;
    }
    
    // 发起 GET 请求，返回字符串结果
    public static String get(String url, List<NameValuePair> params) {
        HttpGet httpGet = new HttpGet();
        try {
            URI uri = new URIBuilder(url).build();
            httpGet.setURI(uri);
            httpGet.setHeader("Stoken", header);
            return executeRequest(httpGet);
        } catch (URISyntaxException | IOException e) {
        } finally {
            httpGet.releaseConnection();
        }
        return null;
    }

    // 发起 Post 请求，返回字符串结果
    public static String post(String url, List<NameValuePair> params) {
        HttpPost httpPost = new HttpPost();
        try {
            httpPost.setURI(new URI(url));
            httpPost.setEntity(new UrlEncodedFormEntity(params));
            httpPost.setHeader("Stoken", header);
            return executeRequest(httpPost);
        } catch (URISyntaxException | IOException e) {
        } finally {
            httpPost.releaseConnection();
        }
        return null;
    }

    // 执行 HTTP 请求并处理响应
    private static String executeRequest(HttpUriRequest request) throws IOException {
        try (CloseableHttpResponse response = httpclient.execute(request, createContext())) {
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    return EntityUtils.toString(entity, encoding);
                } else {
                }
            } else {
            }
        } catch (IOException e) {
            throw e;
        }
        return null;
    }
}
