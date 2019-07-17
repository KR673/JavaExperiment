import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MarkerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 
 * 使用HttpComponents组件发起http请求。
 * @author jiaweicheng
 */
public class HttpClientUtils {

	private static Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);

	/**
	 * 默认采用UTF-8编码
	 */
	public static String DEF_CHARSET = "utf-8";

	/**
	 * 发起get请求
	 */
	public static String get(String url, Map<String, String> header, Map<String, String> urlParam) {
		CloseableHttpClient httpclient = null;
		CloseableHttpResponse response = null;
		HttpGet get = null;
		HttpEntity respEntity = null;
		String result = null;
		try {
			//将param转换为字符串并放在?的后面
			if (urlParam != null && !urlParam.isEmpty()) {
				StringBuffer buffer = new StringBuffer();
				for (Map.Entry<String, String> entry : urlParam.entrySet()) {
					buffer.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue(), DEF_CHARSET))
							.append("&");
				}
				buffer.deleteCharAt(buffer.length() - 1);
				url += "?" + buffer.toString();
			}
			httpclient = HttpClients.createDefault();
			get = new HttpGet(url);
			if (null != header && !header.isEmpty()) {
				Header[] headers = new BasicHeader[header.size()];
				int index = 0;
				for (Map.Entry<String, String> entry : header.entrySet()) {
					headers[index] = new BasicHeader(entry.getKey(), entry.getValue());
					index++;
				}
				get.setHeaders(headers);
			}
			response = httpclient.execute(get);
			int code = response.getStatusLine().getStatusCode();
			if (HttpStatus.SC_OK != code) {
				logger.error("Http get fail. status code {}", code);
			}
			respEntity = response.getEntity();
			result = null != respEntity ? EntityUtils.toString(respEntity, DEF_CHARSET) : null;
			logger.info("HTTP url={},header={}, param={}, response =  {}", url, header, urlParam, result);
		} catch (IOException e) {
			logger.error("HttpClientUtils post url = {}, param ={}, header = {}, exception:", url, header, urlParam, e);
		} finally {
			try {
				httpclient.close();
				response.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * http post xml请求
	 */
	public static String post(String url, Map<String, String> header, Map<String, String> urlParam, String body) {
		CloseableHttpClient httpclient = null;
		CloseableHttpResponse response = null;
		HttpPost post = null;
		HttpEntity reqEntity = null;
		HttpEntity respEntity = null;
		String result = null;
		try {
			//将param转换为字符串并放在?的后面
			httpclient = HttpClients.createDefault();
			StringBuffer buffer = new StringBuffer();
			if (urlParam != null && !urlParam.isEmpty()) {
				for (Map.Entry<String, String> entry : urlParam.entrySet()) {
					buffer.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue(), DEF_CHARSET))
							.append("&");
				}
				buffer.deleteCharAt(buffer.length() - 1);
				url += "?" + buffer.toString();
			}
			post = new HttpPost(url);
			if (null != header && !header.isEmpty()) {
				Header[] headers = new BasicHeader[header.size()];
				int index = 0;
				for (Map.Entry<String, String> entry : header.entrySet()) {
					headers[index] = new BasicHeader(entry.getKey(), entry.getValue());
					index++;
				}
				post.setHeaders(headers);
			}
			reqEntity = new StringEntity(body, DEF_CHARSET);
			post.setEntity(reqEntity);
			response = httpclient.execute(post);
			int code = response.getStatusLine().getStatusCode();
			if (HttpStatus.SC_OK != code) {
				logger.error("Http post fail. status code {}", code);
			}
			respEntity = response.getEntity();
			result = null != respEntity ? EntityUtils.toString(respEntity, DEF_CHARSET) : null;
			logger.info("HTTP post url = {}, header = {}, param={}, body = {}, response = {}", url, header, urlParam, body,
					result);
			logger.info(MarkerFactory.getMarker("addDB"),"http Post url={}, date={},body= {},result={}", url, new Date(), body, result);
		} catch (IOException e) {
			logger.error("HttpClientUtils post url = {},header = {}, body = {}, param = {} , exception:", url, header,
					body, urlParam, e);
		} finally {
			try {
				httpclient.close();
				response.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public static String doGet(String url, Map<String, String> param) {

		// 创建Httpclient对象
		CloseableHttpClient httpclient = HttpClients.createDefault();

		String resultString = "";
		CloseableHttpResponse response = null;
		try {
			// 创建uri
			URIBuilder builder = new URIBuilder(url);
			if (param != null) {
				for (String key : param.keySet()) {
					builder.addParameter(key, param.get(key));
				}
			}
			URI uri = builder.build();

			// 创建http GET请求
			HttpGet httpGet = new HttpGet(uri);

			// 执行请求
			response = httpclient.execute(httpGet);
			// 判断返回状态是否为200
			if (response.getStatusLine().getStatusCode() == 200) {
				resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (response != null) {
					response.close();
				}
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultString;
	}

	public static String doGet(String url) {
		return doGet(url, null);
	}

	public static String doPost(String url, Map<String, String> param) {
		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		String resultString = "";
		try {
			// 创建Http Post请求
			HttpPost httpPost = new HttpPost(url);

			// 创建参数列表
			if (param != null) {
				List<NameValuePair> paramList = new ArrayList<>();
				for (String key : param.keySet()) {
					paramList.add(new BasicNameValuePair(key, param.get(key)));
				}
				// 模拟表单
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList);
				entity.setContentType("application/json; charset=UTF-8");
				httpPost.setEntity(entity);
			}
			// 执行http请求
			response = httpClient.execute(httpPost);
			resultString = EntityUtils.toString(response.getEntity(), "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				response.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return resultString;
	}

	public static String doPost(String url) {
		return doPost(url, null);
	}

	public static String doPostJson(String url, String json) {
		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		String resultString = "";
		try {
			// 创建Http Post请求
			HttpPost httpPost = new HttpPost(url);
			// 创建请求内容
			StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
			httpPost.setEntity(entity);
			// 执行http请求
			response = httpClient.execute(httpPost);
			resultString = EntityUtils.toString(response.getEntity(), "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				response.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return resultString;
	}
}
