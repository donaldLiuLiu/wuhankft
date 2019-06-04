package com.kafutong.wuhankft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kafutong.wuhankft.GlobalString;
import com.kafutong.wuhankft.dao.ITopicMapper;
import com.kafutong.wuhankft.domain.Topic;


@Service
public class TopicServiceImpl implements ITopicService {
	
	@Autowired
	private ITopicMapper topicMapper;

	@Override
	public List<Topic> getTopics(Topic topic) {
		return topicMapper.getTopics(topic);
	}
	
	@Override
	public Topic getTopicByUrl(String url) {
		if(url == null) return null;
		return topicMapper.getTopicbyUrl(url);
	}

	@Override
	public int countTopicsByType(Topic topic) {
		return topicMapper.countTopicsByType(topic);
	}

	@Override
	public List<Topic> getTopicsOfOrder(Topic topic) {
		return topicMapper.getTopicsOfOrder(topic);
	}
	
	
	
	
}
