package org.projectX.event.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.projectX.user.model.UserAccount;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Size(min=1, max=200)
    private String name;

    @Size(max=1000)
    private String description;

    @NotNull
    private Date date;

    @NotEmpty
    @Size(min=3, max=100)
    private String place;

    @NotNull
    private Date createAt;

    @NotNull
    private UserAccount author;

    public Event(){}

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }
    public void setDescription(Date date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }
    public void setPlace(String place) {
        this.place = place;
    }

    public Date getCreateAt() {
        return createAt;
    }
    public void setCreateAt(Date createAt) {
       this.createAt = createAt;
    }

    public UserAccount getAuthor() {
        return author;
    }
    public void setAuthor(UserAccount author) {
        this.author = author;
    }
}
