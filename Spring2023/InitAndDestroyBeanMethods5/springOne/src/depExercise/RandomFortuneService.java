package depExercise;

 import java.util.Random;

 public class RandomFortuneService implements FortuneService{

	private String[] localData = {
		"Betreyal is the worst because its never came from enemy",
		"Hard work is a mother of succes",
		"The path is the prize",
		"Keep your friends close but enemies even closer",
		"Master have fallen more time than apprentice even tried"
	};
	
	//random generator
	private Random rand = new Random();
	
	
	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		int random = rand.nextInt(localData.length);
		
		String fortune = localData[random];
				return fortune;
	}
	

}
