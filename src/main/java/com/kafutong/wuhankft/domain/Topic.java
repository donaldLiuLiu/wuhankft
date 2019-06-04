package com.kafutong.wuhankft.domain;

/**
 * 
 * @author freshJuice
 * kft_infos
 */
public class Topic {
	
	private String id;
	private String topic_type;
	private String topic;
	private String topic_content;
	private String topic_imgpath;
	private String topic_date;
	private String topic_click;
	private String topic_url;
	private String topic_text;
	
	private int start = 0;
	private int count = 5;
	private int from;
	private int amount;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTopic_type() {
		return topic_type;
	}
	public void setTopic_type(String topic_type) {
		this.topic_type = topic_type;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getTopic_content() {
		return topic_content;
	}
	public void setTopic_content(String topic_content) {
		this.topic_content = topic_content;
	}
	public String getTopic_imgpath() {
		return topic_imgpath;
	}
	public void setTopic_imgpath(String topic_imgpath) {
		this.topic_imgpath = topic_imgpath;
	}
	public String getTopic_date() {
		return topic_date;
	}
	public void setTopic_date(String topic_date) {
		this.topic_date = topic_date;
	}
	public String getTopic_click() {
		return topic_click;
	}
	public void setTopic_click(String topic_click) {
		this.topic_click = topic_click;
	}
	public String getTopic_url() {
		return topic_url;
	}
	public void setTopic_url(String topic_url) {
		this.topic_url = topic_url;
	}
	public String getTopic_text() {
		return topic_text;
	}
	public void setTopic_text(String topic_text) {
		this.topic_text = topic_text;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getFrom() {
		setFrom(start * count);
		return from;
	}
	public void setFrom(int from) {
		this.from = from;
	}
	
}
