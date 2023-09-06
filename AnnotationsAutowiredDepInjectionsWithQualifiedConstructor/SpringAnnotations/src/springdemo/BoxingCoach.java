package springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BoxingCoach implements Coach {
	private FileFortune fileFortune;
	
	

	//private TrainingLevel trainingLevel;
	
	//private HappyFortuneService fortuneService;
	
//	public void setTrainingLevel(TrainingLevel trainingLevel) {
//		this.trainingLevel=trainingLevel;
//	}
//	
//	public int getTrainingLevel() {
//		return trainingLevel.getLevel();
//	}
	@Autowired
	public BoxingCoach(@Qualifier("fileFortune")
	FileFortune fileFortune) {
		this.fileFortune=fileFortune;
	}
	
	

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice your jab for 5 minutes !";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fileFortune.getFortune();
	}
	

}
