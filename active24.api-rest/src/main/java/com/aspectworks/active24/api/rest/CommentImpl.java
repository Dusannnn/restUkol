package com.aspectworks.active24.api.rest;

import com.aspectworks.active24.api.rest.vo.CommentVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentImpl implements CommentService {

    List<CommentVO> comments = new ArrayList<>();

    @Override
    public void createComment(CommentVO comment) {
        comments.add(comment);
    }

    @Override
    public void deleteComment(long commentId) {
        for (CommentVO cmnt : comments){
            if (cmnt.getCommentId() == commentId){
                comments.remove(cmnt);
            }
        }

    }

    @Override
    public List<CommentVO> getAllComments() {
        return comments;
    }
}
