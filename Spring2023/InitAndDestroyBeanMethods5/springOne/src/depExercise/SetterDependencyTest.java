package depExercise;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDependencyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach CCoach = context.getBean("myCricketCoach",Coach.class);
		
		System.out.println("Cricket coach says: "+CCoach.getDailyFortune());
		
		Coach ITCoach = context.getBean("myITCoach",Coach.class);
		
		System.out.println(ITCoach.getDailyFortune());
		
		CricketCoach CricketCoach = context.getBean("myCricketCoach",CricketCoach.class);
		
		System.out.println(CricketCoach.getDailyFortune());
		System.out.println(CricketCoach.getEmailAddress());
		System.out.println(CricketCoach.getTeam());
		context.close();

	}

}
