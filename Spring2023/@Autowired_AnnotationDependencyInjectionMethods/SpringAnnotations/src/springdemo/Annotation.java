package springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Annotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get the bean from spring container
	TennisCoach theCoach = context.getBean("tennisCoach", TennisCoach.class);
	
		// call a method on the bean
	System.out.println(theCoach.getDailyWorkout());
	System.out.println(theCoach.getDailyFortune());
				
	// close the context
	
	Coach boxingCoachTony = context.getBean("boxingCoach",Coach.class);
	
	System.out.println(boxingCoachTony.getDailyWorkout());
	System.out.println(boxingCoachTony.getDailyFortune());
		context.close();
		
		

	}

}
