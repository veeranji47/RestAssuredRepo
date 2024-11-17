package pratice.serializationanddeserailization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;


public class DeserializationGameStatus {

	public static void main(String[] args) throws Exception  {
		FileInputStream fis = new FileInputStream("./game.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		NFSGame gameStatus = (NFSGame) ois.readObject();
		System.out.println(gameStatus.nm);
		System.out.println(gameStatus.level);
		System.out.println(gameStatus.life);
		System.out.println(gameStatus.score);
	}

}
