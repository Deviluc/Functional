package com.deviluc.functional.model;

@FunctionalInterface
public interface TriFunction<A,B,C,R> {
	
	public R apply(final A a, final B b, final C c);
	
}
