package com.aspectworks.active24.api.rest.vo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class TopicEntity {
    private long topicId;
    private String topicName;
    private String content;
    private Date dateCreated = new Date();
    @OneToMany
    private List<CommentVO> comments = new ArrayList<>();

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    public TopicEntity(){}

    public TopicEntity(TopicVO topicVO) {
        this.topicId = topicVO.getTopicId();
        this.topicName = topicVO.getTopicName();
        this.content = topicVO.getContent();
        this.dateCreated = new Date();
    }

    public long getTopicId() {
        return topicId;
    }

    public void setTopicId(long topicId) {
        this.topicId = topicId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public List<CommentVO> getComments() {
        return comments;
    }

    public void setComments(List<CommentVO> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TopicEntity that = (TopicEntity) o;
        return topicId == that.topicId &&
                Objects.equals(topicName, that.topicName) &&
                Objects.equals(content, that.content) &&
                Objects.equals(dateCreated, that.dateCreated) &&
                Objects.equals(comments, that.comments);
    }

    @Override
    public int hashCode() {

        return Objects.hash(topicId, topicName, content, dateCreated);
    }

    @Override
    public String toString() {
        return "TopicVO{" +
                "topicId=" + topicId +
                ", topicName='" + topicName + '\'' +
                ", content='" + content + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
