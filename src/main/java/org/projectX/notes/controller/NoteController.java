package org.projectX.notes.controller;

import org.projectX.notes.categories.model.Category;
import org.projectX.notes.categories.service.CategoryService;
import org.projectX.notes.model.NoteCore;
import org.projectX.notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by Tomek on 2017-04-19.
 */
@RestController
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<NoteCore>> getNotes() {
        List<NoteCore> notes = noteService.getAllNotes();
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NoteCore> createNote(@RequestBody NoteCore noteCore) {
        Date now = new Date();
        noteCore.setCreateDate(new Timestamp(now.getTime()));
        Category createdCategory = getCategory(noteCore.getCategory());
        noteCore.setCategory(createdCategory);
        NoteCore createdNote = noteService.createNote(noteCore);
        return new ResponseEntity<>(createdNote, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NoteCore> updateNote(@RequestBody NoteCore noteCore) {
        Date now = new Date();
        noteCore.setLastModificationDate(new Timestamp(now.getTime()));
        Category createdCategory = getCategory(noteCore.getCategory());
        noteCore.setCategory(createdCategory);
        NoteCore updatedNote = noteService.updateNote(noteCore);
        return new ResponseEntity<>(updatedNote, HttpStatus.OK);
    }
    @RequestMapping(value="/delete",method = RequestMethod.DELETE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<NoteCore>> deleteNote(@RequestBody NoteCore noteCore){
        noteService.deleteNote(noteCore);
        return getNotes();
    }

    @RequestMapping(value = "/createCategory", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    private Category getCategory(@RequestBody Category category) {
        Category foundCategory = categoryService.getCategoryByName(category.getCategoryName());
        if (foundCategory == null) {
            return categoryService.createCategory(category);
        } else
            return categoryService.updateCategory(foundCategory);
    }
    @RequestMapping(value = "/allCategories", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Category>> getCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

}
