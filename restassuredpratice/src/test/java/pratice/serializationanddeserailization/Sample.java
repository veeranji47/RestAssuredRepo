package pratice.serializationanddeserailization;

import java.util.ArrayList;

public class Sample {
	public static void main(String[] args) {
		ArrayList<Object> a = new ArrayList<Object>();
		a.add("Hello");
		a.add('R');
		a.add(20);
		a.add(null);
		
		for(Object b : a) {
			System.out.println(b);
		}
	}

}
