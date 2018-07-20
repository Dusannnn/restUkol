package com.aspectworks.active24.api.rest.vo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
public class CommentEntity {

    private String user;
    private long commentId;
    private String content;
    private Date dateCreated;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    public CommentEntity() {
        this.dateCreated = new Date();
    }


    public CommentEntity(CommentVO commentVO) {
        this.user = commentVO.getUser();
        this.commentId = commentVO.getCommentId();
        this.content = commentVO.getContent();
        this.dateCreated = new Date();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
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
        CommentEntity commentEntity = (CommentEntity) o;
        return Objects.equals(user, commentEntity.user) &&
                Objects.equals(commentId, commentEntity.commentId) &&
                Objects.equals(content, commentEntity.content);
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
