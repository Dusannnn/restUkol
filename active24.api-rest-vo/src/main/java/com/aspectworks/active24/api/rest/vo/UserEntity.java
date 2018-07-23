package com.aspectworks.active24.api.rest.vo;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PreDestroy;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserEntity {

    private String username;
    private String firstName;
    private String surname;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    public UserEntity() {
    }

    public UserEntity(UserVO usrVO) {
        this.username = usrVO.getUsername();
        this.firstName = usrVO.getFirstName();
        this.surname = usrVO.getSurname();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity userVO = (UserEntity) o;

        if (username != null ? !username.equals(userVO.username) : userVO.username != null) return false;
        if (firstName != null ? !firstName.equals(userVO.firstName) : userVO.firstName != null) return false;
        return surname != null ? surname.equals(userVO.surname) : userVO.surname == null;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}