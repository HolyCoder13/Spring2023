package depExercise;

public class ITCoach implements Coach {
	
	private FortuneService fortuneService;
	public ITCoach() {
		System.out.println("No-Parameter ITCoach constructor invoked! ");
	}
	
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Pratice coding for 30minutes";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "IT coach says: Code and I almost forgot, "+fortuneService.getFortune()+" !";
	}
	
	public void startupStuff() {
		System.out.println("IT coach startup stufff");
		
	}
	
	public void cleanUpStuff() {
		System.out.println("IT coach cleanup stufff");
		
	}

}
