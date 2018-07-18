package com.aspectworks.active24.api.rest.vo;

import java.util.Date;
import java.util.Objects;

public class TopicVO {
    private long topicId;
    private String topicName;
    private String content;
    private Date dateCreated = new Date();

    public TopicVO() {
    }

    public TopicVO(TopicEntity topic) {
        this.topicId = topic.getTopicId();
        this.topicName = topic.getTopicName();
        this.content = topic.getContent();
        this.dateCreated = topic.getDateCreated();
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TopicVO topicVO = (TopicVO) o;
        return topicId == topicVO.topicId &&
                Objects.equals(topicName, topicVO.topicName) &&
                Objects.equals(content, topicVO.content) &&
                Objects.equals(dateCreated, topicVO.dateCreated);
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
