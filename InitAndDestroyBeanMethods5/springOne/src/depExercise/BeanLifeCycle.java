package depExercise;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("beanLifeCycle.xml");
		
		TrackCoach trackCoach = context.getBean("myTrackCoach",TrackCoach.class);
		
		System.out.println(trackCoach.getDailyWorkout());
		
		context.close();

	}

}
