package com.kafutong.wuhankft.service;

import java.util.List;

import com.kafutong.wuhankft.domain.Topic;

public interface ITopicService {

	List<Topic> getTopics(Topic topic);
	Topic getTopicByUrl(String string);
	int countTopicsByType(Topic topic);
	List<Topic> getTopicsOfOrder(Topic topic);
	
}
