package com.kafutong.wuhankft.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kafutong.wuhankft.domain.Topic;

@Mapper
public interface ITopicMapper {

	List<Topic> getTopics(Topic topic);
	Topic getTopicbyUrl(String url);
	int countTopicsByType(Topic topic);
	List<Topic> getTopicsOfOrder(Topic topic);
	
}
