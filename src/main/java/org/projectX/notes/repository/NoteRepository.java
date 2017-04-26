package org.projectX.notes.repository;

import org.projectX.notes.model.NoteCore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Tomek on 2017-04-19.
 */
@Repository
public interface NoteRepository extends JpaRepository<NoteCore, Long> {
    List<NoteCore> findAllByOrderByCreateDateAsc();
}
