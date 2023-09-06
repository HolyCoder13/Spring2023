package springdemo;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class TennisCoach implements Coach {
	
	//direct injection even if its private
	@Autowired
	private FortuneService fortuneService;
	
	public TennisCoach() {
		System.out.println("Inside def constr");
	};
	
	
	//custom dependency autowired method
//	@Autowired
//	public void someAutowiredMethod(FortuneService fortuneService) {
//	System.out.println("tennis coach inisde set method : ");
//	this.fortuneService = fortuneService; 
//}
	
	//setter dependency autowired method
//	@Autowired
//	public void setFortuneService(FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//	}

		//constructor dependency autowired method
//	@Autowired
//	public TennisCoach(FortuneService theFortuneService) {
//		fortuneService = theFortuneService;
//	}

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return "tennis coach said: "+fortuneService.getFortune();
	}

}
