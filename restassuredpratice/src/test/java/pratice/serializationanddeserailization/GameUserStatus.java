package pratice.serializationanddeserailization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class NFSGame implements Serializable{
	
	int level;
	int life;
	long score;
	String nm;
	public NFSGame(int level, int life, long score, String nm) {
		this.level = level;
		this.life = life;
		this.score = score;
		this.nm = nm;
		
	}
}




public class GameUserStatus {

	public static void main(String[] args) throws Exception {
		NFSGame game  = new NFSGame(10, 3, 70000, "Veera");
		FileOutputStream fout = new FileOutputStream("./game.txt");
		ObjectOutputStream objOut = new ObjectOutputStream(fout);
		objOut.writeObject(game);
		System.out.println("End");

	}

}
