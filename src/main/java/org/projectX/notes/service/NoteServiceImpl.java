package org.projectX.notes.service;

import org.hibernate.SessionFactory;
import org.projectX.notes.model.NoteCore;
import org.projectX.notes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;

/**
 * Created by Tomek on 2017-04-19.
 */
@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public NoteCore createNote(NoteCore noteCore) {
        noteRepository.save(noteCore);
        return noteCore;
    }

    @Override
    public List<NoteCore> getAllNotes() {
        List<NoteCore> notes = noteRepository.findAll();
        return notes;
    }

    @Override
    public NoteCore updateNote(NoteCore noteCore) throws NoResultException {
        NoteCore foundNote = noteRepository.findOne(noteCore.getId());
        if(foundNote == null) {
            throw new NoResultException("Cannot update note. Note doesn't exist");
        }
        noteCore.setCreateDate(foundNote.getCreateDate());
        noteRepository.save(noteCore);
        return noteCore;
    }

    @Override
    public void deleteNote(NoteCore noteCore) throws NoResultException {
        NoteCore note = noteRepository.findOne(noteCore.getId());
        if(note == null) {
            throw new NoResultException("No such note");
        }
        noteRepository.delete(note);

    }

}
