package com.aspectworks.active24.api.rest;

import com.aspectworks.active24.api.rest.vo.CommentVO;
import com.aspectworks.active24.api.rest.vo.TopicVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/topics")

public class TopicController {

    @Autowired
    TopicServiceImpl topicService;


    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void creatTopic(@RequestBody TopicVO topic){
        topicService.createTopic(topic);
        System.out.println("Creating new topic: " + topic);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{topicId}")
    public void deleteTopic(@PathVariable("topicId") long topicId){
        topicService.deleteTopic(topicId);
        System.out.println("Deleting topic with id: " + topicId);
    }

    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<TopicVO> getAllTopics(@RequestParam (value = "text", required = false) String text, @RequestParam (value = "sortBy", required = false) String sortBy, @RequestParam (value = "sortType", required = false) String sortType){
        return topicService.getAllTopics(text, sortBy, sortType).stream().map(topic -> new TopicVO(topic)).collect(Collectors.toList());
    }

//query string pro razeni 2param, date,name ; desc or asc

    @RequestMapping(method = RequestMethod.POST, value = "/{topicId}/comments", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createComment(@RequestBody CommentVO comment,@PathVariable("topicId") long topicId){
        topicService.createComment(topicId, comment);
        System.out.println("Creating new comment: " + comment);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/{topicId}/comments", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<CommentVO> getAllComments(@PathVariable("topicId") long topicId){
        return topicService.getAllComments(topicId).stream().map(comment -> new CommentVO(comment)).collect(Collectors.toList());
    }



}
