package org.plweb.plxml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XTask {
	private String id;

	private String title;

	private List<XCommand> commands = new ArrayList<XCommand>();

	private Map<String, String> properties = new HashMap<String, String>();

	/**
	 * Temp Attributes 用於Editor Runtime時暫存資料之用<br/>
	 * 例(1)：Task使用期間的KeyStroke<br/>
	 * 例(2)：Task使用期間的TimeCost<br/>
	 */
	private Map<String, Object> tempAttributes = new HashMap<String, Object>();

	public Object getTempAttribute(String key) {
		return tempAttributes.get(key);
	}

	public void setTempAttribute(String key, Object value) {
		tempAttributes.put(key, value);
	}

	public Map<String, Object> getTempAttributes() {
		return tempAttributes;
	}

	public void setTempAttributes(Map<String, Object> tempAttributes) {
		this.tempAttributes = tempAttributes;
	}

	public void addCommand(XCommand command) {
		commands.add(command);
	}

	public List<XCommand> getCommands() {
		return commands;
	}

	public void setCommands(List<XCommand> commands) {
		this.commands = commands;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setProperty(String key, String value) {
		properties.put(key, value);
	}

	/**
	 * 傳入文字進行參數代換處理
	 * 
	 * @param text
	 * @return
	 */
	public String getStringEx(String text) {
		return PropertyUtils.process(properties, text);
	}

	/**
	 * 取得參數替換處理後的屬性
	 * 
	 * @param key
	 * @return
	 */
	public String getPropertyEx(String key) {
		return PropertyUtils.process(properties, properties.get(key));
	}

	/**
	 * 取得屬性
	 * 
	 * @param key
	 * @return
	 */
	public String getProperty(String key) {
		return properties.get(key);
	}

	/**
	 * 取得屬性的鍵值(keys)
	 * 
	 * @return
	 */
	public List<String> getPropertyKeys() {
		List<String> result = new ArrayList<String>();
		for (String key : properties.keySet()) {
			result.add(key);
		}
		return result;
	}

	/**
	 * 取得屬性的鍵值(keys)
	 * 
	 * @param prefix
	 * @return
	 */
	public List<String> getPropertyKeys(String prefix) {
		List<String> result = new ArrayList<String>();
		for (String key : properties.keySet()) {
			if (key.startsWith(prefix)) {
				result.add(key);
			}
		}
		return result;
	}

	public Map<String, String> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}
}
