package com.aspectworks.active24.api.rest.vo;

import java.util.Objects;

public class CommentVO {

    private UserVO user;
    private long commentId;
    private String content;

    public UserVO getUser() {
        return user;
    }

    public void setUser(UserVO user) {
        this.user = user;
    }

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentVO commentVO = (CommentVO) o;
        return Objects.equals(user, commentVO.user) &&
                Objects.equals(commentId, commentVO.commentId) &&
                Objects.equals(content, commentVO.content);
    }

    @Override
    public int hashCode() {

        return Objects.hash(user, commentId, content);
    }

    @Override
    public String toString() {
        return "CommentVO{" +
                "user=" + user +
                ", commentName='" + commentId + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
