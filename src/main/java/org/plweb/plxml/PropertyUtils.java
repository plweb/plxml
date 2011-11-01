package org.plweb.plxml;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PropertyUtils {

	private static Pattern regexp = Pattern
			.compile("(\\$\\{[0-9A-Za-z\\-\\_\\.]+\\})");

	/**
	 * ���j�B�zMap<String,String>���A���ݩʶ�
	 * 
	 * @param props
	 * @param key
	 * @return
	 */
	public static String process(Map<String, String> props, String value) {
		String result = null;
		if (value != null) {
			Matcher matcher = regexp.matcher(value);
			StringBuffer sb = new StringBuffer();
			while (matcher.find()) {
				String key2 = matcher.group().substring(2,
						matcher.group().length() - 1);

				// �@�ߥ��ˬd�O�����w�q(�L�w�qnull�h���B�z)
				String replaceTo;
				replaceTo = PropertyUtils.process(props, props.get(key2));
				if (replaceTo != null) {
					matcher.appendReplacement(sb, replaceTo);
				}
			}
			matcher.appendTail(sb);
			result = sb.toString();
		}
		return result;
	}
}
