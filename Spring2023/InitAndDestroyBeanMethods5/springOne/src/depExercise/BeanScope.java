package depExercise;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		Coach theCoach = context.getBean("myCoach",Coach.class);
		
		Coach Coach2 = context.getBean("myCoach",Coach.class);
		
		boolean check = (theCoach==Coach2);
		System.out.println(check);
		
		System.out.println("Memory location of theCoach "+theCoach);
		
		System.out.println("Memory location for Coach2 "+Coach2);
		
		context.close();

	}

}
