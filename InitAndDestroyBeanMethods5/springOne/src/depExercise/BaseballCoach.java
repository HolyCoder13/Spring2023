package depExercise;

public class BaseballCoach implements Coach{
	
	//define private field for dependency
	private FortuneService fortuneService;
	//define constructor for injection
	public BaseballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	
	public String getDailyWorkout() {
		return "Spend 30 minutes on practice";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
