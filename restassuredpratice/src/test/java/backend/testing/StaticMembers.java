package backend.testing;

public class StaticMembers {
	
	public static int a = 10;
	public static void given() {
		System.out.println("executed given method : ");
	}
	public static void when() {
		System.out.println("executed when method : ");
	}
	public static void then() {
		System.out.println("executed then method : ");
	}

}
