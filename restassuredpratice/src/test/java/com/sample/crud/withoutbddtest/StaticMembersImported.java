package com.sample.crud.withoutbddtest;

import org.testng.annotations.Test;

import backend.testing.MethodChaining;

import static backend.testing.StaticMembers.*;


public class StaticMembersImported {
	
	@Test
	public void sampleTest() {
		System.out.println(a);
		given();
		when();
		then();
		MethodChaining m = new MethodChaining();
		m.a().b().c();
		
	}

}
