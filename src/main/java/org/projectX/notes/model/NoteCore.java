package org.projectX.notes.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.projectX.notes.categories.model.Category;


/**
 * Created by Tomek on 2017-04-14.
 */
@Entity(name = "notes")
public class NoteCore {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "category_id")
    @JsonBackReference
    private Category category;

    @NotNull
    @Size(min = 1, max = 30)
    private String topic;

    private String content;

    @NotNull
    private java.sql.Timestamp createDate;

    private java.sql.Timestamp lastModificationDate;

    @NotNull
    @Min(1)
    @Max(5)
    private int priority;


    public NoteCore() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Timestamp getLastModificationDate() {
        return lastModificationDate;
    }

    public void setLastModificationDate(Timestamp lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }
}