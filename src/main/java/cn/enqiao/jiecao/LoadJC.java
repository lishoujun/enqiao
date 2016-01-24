package cn.enqiao.jiecao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class LoadJC {

	private static String baseListUrl = "http://www.jiecao.fm/ls.htm";;
	private static String baseAticleUrl = "http://news.jiecao.fm/client/article/detail.htm";;
	private static String listUrl;
	private static String last_time;
	private static String version;

	public static void main(String[] args) {

		System.out.println(loadJC());
	}

	public static String loadJC() {
		last_time = new SimpleDateFormat("yyyy-MM-dd%20HH:mm:ss")
				.format(new Date());
		listUrl = baseListUrl + "?last_time=" + last_time;
		version = "2.6.2";
		return getList(listUrl);
	}

	/**
	 * 获取节操列表及内容.
	 * 
	 * @param listUrl
	 */
	private static String getList(final String listUrl) {
		// 列表
		String json = loadJson(listUrl), html = "";
		JSONObject jsonObj = JSONObject.fromObject(json);
		JSONArray array = jsonObj.getJSONArray("list");
		for (int i = 0; i < array.size(); i++) {
			JSONObject object = (JSONObject) array.get(i);
			String title = object.get("title") == null ? "" : (String) object
					.get("title");
			String id = object.get("id") == null ? "" : (String) object
					.get("id");
			// 文章正文
						String articleUrl = baseAticleUrl + "?v=" + version + "&id=" + id
								+ "&down=true";
			
						html+=("<a id=\"wa\" href=\"" + articleUrl
					+ "\" target=\"_blank\" title=\""
					+ title + "\">" + title
					+ "</a>\r<br>\r");
			
		}
		return html;
	}

	/**
	 * 抓取指定url返回的json
	 * 
	 * @param url
	 * @return String
	 * @author zhouqz
	 */

	public static String loadJson(final String url) {
		StringBuilder json = new StringBuilder();
		try {
			URL urlObject = new URL(url);
			URLConnection uc = urlObject.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(
					uc.getInputStream(), "utf-8"));
			String inputLine = null;
			while ((inputLine = in.readLine()) != null) {
				json.append(inputLine);
			}
			in.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json.toString();
	}

}