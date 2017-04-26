package org.projectX.notes.service;

import org.projectX.notes.model.NoteCore;

import javax.persistence.NoResultException;
import java.util.List;

/**
 * Created by Tomek on 2017-04-19.
 */
public interface NoteService {
    NoteCore createNote(NoteCore noteCore);
    List<NoteCore> getAllNotes();
    NoteCore updateNote(NoteCore noteCore)throws NoResultException;
    void deleteNote(NoteCore noteCore) throws NoResultException;
}
