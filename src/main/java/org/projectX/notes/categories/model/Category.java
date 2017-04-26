package org.projectX.notes.categories.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.projectX.notes.model.NoteCore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tomek on 2017-04-19.
 */
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<NoteCore> notes = new ArrayList<NoteCore>();

    private String categoryName;

    public Category(){
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public List<NoteCore> getNotes() {
        return notes;
    }

    public void setNotes(List<NoteCore> notes) {
        this.notes = notes;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
