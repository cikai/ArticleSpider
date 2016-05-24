package bean;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import method.Util;

public class ArticleBean {

	String title;
	String content;

	public ArticleBean(String url) {
		title = "";
		content = "";

		String contentUrl = Util.SendGet(url);
		Pattern pattern;
		Matcher matcher;

		pattern = Pattern.compile("class=\"artTit\">(.+?)");
		matcher = pattern.matcher(contentUrl);
		if (matcher.find()) {
			title = matcher.group(1);
		}

		pattern = Pattern.compile("class=\"artText\">(.+?)");
		matcher = pattern.matcher(contentUrl);
		if (matcher.find()) {
			content = matcher.group(1);
		}
	}

	@Override
	public String toString() {
		return "title：" + title + "\n" + "content：" + content + "\n";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
