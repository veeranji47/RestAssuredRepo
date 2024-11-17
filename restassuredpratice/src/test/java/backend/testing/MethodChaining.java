package backend.testing;

import com.sample.crud.withoutbddtest.StaticMembersImported;

public class MethodChaining {
	
	public MethodChaining a() {
		System.out.println("method a");
		return new MethodChaining();
	}
	public MethodChaining b() {
		System.out.println("method b");
		return new MethodChaining();
	}
	public StaticMembersImported c() {
		System.out.println("method c");
		return new StaticMembersImported();
	}

}
