package org.radu.bigdata.test;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.radu.bigdata.dao.EventDAO;
import org.radu.bigdata.dto.Event;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.junit.Assert.assertEquals;

public class EventTestCase {

	private static AnnotationConfigApplicationContext context;
	private static EventDAO eventDAO;
	private Event event;
	
	@BeforeClass
	public static void init(){
		
		context = new AnnotationConfigApplicationContext();
		context.scan("org.radu.bigdata");
		context.refresh();
		eventDAO = (EventDAO)context.getBean("eventDAO");
	}
	
	@Test
	public void testAddEvent(){
		
		event = new Event();
		Date date = new Date(2017, 12, 29, 23, 00);
		event.setReportedTime(date);
		event.setLocation("Pitesti");
		event.setAlertCode(2);
		event.setDescription("nu s-a intamplat nimic");
		event.setTag("terrorist act");
		
		assertEqals("succesfuly added an event in the table",true,eventDAO.add(event));
	}
}
