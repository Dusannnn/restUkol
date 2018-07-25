package com.aspectworks.active24.api.rest;

import ch.qos.logback.classic.Logger;
import com.aspectworks.active24.api.rest.vo.CommentVO;
import com.aspectworks.active24.api.rest.vo.TopicVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/topics")
@Api(value = "/topics")
public class TopicController {

    @Autowired
    TopicServiceImpl topicService;

    final Logger logger = (Logger) LoggerFactory.getLogger(TopicController.class);

    @Autowired
    RequestLimitImpl requestLimit;

    @ApiOperation(value = "Creating new topic")
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createTopic(@RequestBody TopicVO topic){
        requestLimit.assertUserRequestLimit("a");
        topicService.createTopic(topic);
        logger.debug("Creating new topic: " + topic);
    }

    @ApiOperation(value = "Deleting specific topic based on TopicID")
    @RequestMapping(method = RequestMethod.DELETE, value = "/{topicId}")
    public void deleteTopic(@PathVariable("topicId") long topicId){
        requestLimit.assertUserRequestLimit("a");
        topicService.deleteTopic(topicId);
        logger.debug("Deleting topic with id: " + topicId);
    }

    @ApiOperation(value = "Returning list of topics")
    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<TopicVO> getAllTopics(@RequestParam (value = "text", required = false) String text, @RequestParam (value = "sortBy", required = false) String sortBy, @RequestParam (value = "sortType", required = false) String sortType){
        requestLimit.assertUserRequestLimit("a");
        return topicService.getAllTopics(text, sortBy, sortType).stream().map(topic -> new TopicVO(topic)).collect(Collectors.toList());

    }


//query string pro razeni 2param, date,name ; desc or asc

    @ApiOperation(value = "creating new comment for specific topic based on TopicID")
    @RequestMapping(method = RequestMethod.POST, value = "/{topicId}/comments", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createComment(@RequestBody CommentVO comment,@PathVariable("topicId") long topicId){
        topicService.createComment(topicId, comment);
        logger.info("Creating new comment: " + comment);
    }

    @ApiOperation(value = "Returning list of commnets")
    @RequestMapping(method = RequestMethod.GET, value = "/{topicId}/comments", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<CommentVO> getAllComments(@PathVariable("topicId") long topicId){
        return topicService.getAllComments(topicId).stream().map(comment -> new CommentVO(comment)).collect(Collectors.toList());
    }







}
