package depExercise;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	 private String emailAddress;
	 private String team;
	 
	 
	 public void setEmailAddress(String emailAddress) {
		 this.emailAddress=emailAddress;
	 }
	
	 public void setTeam(String team) {
		 this.team=team;
	 }
	 
	 public String getEmailAddress() {
		 return this.emailAddress;
	 }
	 
	 public String getTeam() {
		 return this.team;
	 }
	public CricketCoach() {
		System.out.println("no paremeters constructor has been invoked! ");
	};
	
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("setter injection invoked!");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "practice fast bowling for 1minutes";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "CrciketCoach says: "+fortuneService.getFortune();
	}

}
