package org.radu.bigdata.daoimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.radu.bigdata.dao.EventDAO;
import org.radu.bigdata.dto.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class EventDAOImpl implements EventDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private static List<Event> events = new ArrayList<>();
	
	static{
		Event eve = new Event();
		Date date = new Date(2017, 12, 29, 23, 00);
		eve.setReportedTime(date);
		eve.setLocation("Pitesti");
		eve.setAlertCode(2);
		eve.setDescription("nu s-a intamplat nimic");
		eve.setTag("terrorist act");
		
		events.add(eve);
	}
	
	@Override
	public List<Event> list() {
		// TODO Auto-generated method stub
		return events;
	}

	@Override
	public Event get(int idEvent) {
		for (Event event : events)
			if(event.getIdEvent() == idEvent)
				return event;
		return null;

	}

	@Override
	@Transactional
	public boolean add(Event event) {

		try{
			//adding the event in the table
			sessionFactory.getCurrentSession().persist(event);
			return true;		
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		
	}

}
