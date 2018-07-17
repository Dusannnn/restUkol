package com.aspectworks.active24.api.rest;

import com.aspectworks.active24.api.rest.vo.CommentVO;

import java.util.List;


public interface CommentService {

    public void createComment(CommentVO comment);

    void deleteComment(long commentId);

    List<CommentVO> getAllComments();
}
