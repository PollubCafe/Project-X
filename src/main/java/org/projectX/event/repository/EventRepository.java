package org.projectX.event.repository;

import org.projectX.event.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jrwoj on 19.04.2017.
 */
@Repository
public interface EventRepository extends JpaRepository<Event, Integer>{
}
