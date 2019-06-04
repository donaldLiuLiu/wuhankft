package com.kafutong.wuhankft.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.kafutong.wuhankft.GlobalString;
import com.kafutong.wuhankft.domain.Topic;
import com.kafutong.wuhankft.service.ITopicService;

@Controller
public class TopicController {
	
	private Logger logger = LoggerFactory.getLogger(TopicController.class);
	@Autowired
	private ITopicService topicService;
	
	@RequestMapping(path="/topics", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getTopics(@RequestBody Topic topic) {
		Map<String, Object> ret = new HashMap<String, Object>();
		List<Topic> topics = topicService.getTopics(topic);
		ret.put("code", true);
		ret.put("start", topic.getStart());
		ret.put("count", topic.getCount());
		int mount = topicService.countTopicsByType(topic);
		ret.put("page", mount/topic.getCount());
		ret.put("mount", mount);
		ret.put("root", topics);
		return ret;
	}
	
	@RequestMapping(path="/topicOrder", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getTopicOfOrder(@RequestBody Topic topic) {
		Map<String, Object> ret = new HashMap<String, Object>();
		List<Topic> topics = topicService.getTopicsOfOrder(topic);
		ret.put("code", true);
		ret.put("root", topics);
		return ret;
	}
	
	@RequestMapping(path="/topic/{type}/{noUseful}", method=RequestMethod.GET)
	public ModelAndView toTopic(@PathVariable("type") String type, 
			@PathVariable("noUseful") String noUseful) {
		String dispPath = "infos/" + type;
		ModelAndView modelAndView = new ModelAndView(dispPath);
		Topic topic = topicService.getTopicByUrl("/topic/" + type + "/" + noUseful);
		modelAndView.addObject("topic", topic);
		return modelAndView;
	}
	
}
