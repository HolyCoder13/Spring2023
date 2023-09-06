package depExercise;


public class MmaCoach implements Coach{
	
	private FortuneService FortuneService;
	
	public MmaCoach(FortuneService FortuneService) {
		this.FortuneService = FortuneService;
	}
	
	public String getDailyWorkout() {
		return "35 push-ups!";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "MMACoach says: "+FortuneService.getFortune();
	}

}
