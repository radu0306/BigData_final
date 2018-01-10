package org.radu.bigdata.dao;

import java.util.List;

import org.radu.bigdata.dto.Event;

public interface EventDAO {

	boolean add(Event event);
	
	List<Event> list();
	Event get(int idEvent);
	
}
