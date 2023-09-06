package springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService{

	String[] fortunes = {"Betreyal is the worst because its never came from enemy",
			"Hard work is a mother of succes",
			"The path is the prize",
			"Keep your friends close but enemies even closer",
			"Master have fallen more time than apprentice even tried"};
	
	private Random rnd = new Random();
	

	@Override
	public String getFortune() {
		int r = rnd.nextInt(fortunes.length);
		return fortunes[r];
	}

}
