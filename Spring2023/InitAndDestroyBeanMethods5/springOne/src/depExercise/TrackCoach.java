package depExercise;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	public TrackCoach() {};
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Run a hard 5";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "done!" +fortuneService.getFortune();
	}
	
	public void startupStuff() {
		System.out.println("Trackckoach startup stufff");
		
	}
	
	public void cleanUpStuff() {
		System.out.println("Trackckoach cleanup stufff");
		
	}

}
