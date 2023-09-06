package springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoxingCoach implements Coach {

	private HappyFortuneService fortuneService;
	
	@Autowired
	public BoxingCoach(HappyFortuneService HappyFortuneService) {
		fortuneService=HappyFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice your jab for 5 minutes !";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}
	

}
