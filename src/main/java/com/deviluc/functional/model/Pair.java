package com.deviluc.functional.model;

import java.util.Map.Entry;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Pair<A,B> {
	
	public static <A,B> Pair<A,B> of(final A a, final B b) {
		return new Pair<A, B>(a, b);
	}
	
	public static <A,B> Pair<A,B> of(final Entry<A, B> entry) {
		return new Pair<A,B>(entry.getKey(), entry.getValue());
	}
	
	public static <A,B,R> Function<Pair<A,B>,R> map(final BiFunction<A, B, R> mapFunc) {
		return p -> mapFunc.apply(p.a, p.b);
	}
	
	public static<A,B,R> Function<Pair<A,B>,Pair<R,B>> mapFirst(final Function<A,R> mapFunc) {
		return p -> new Pair<R,B>(mapFunc.apply(p.a), p.b);
	}
	
	public static<A,B,R> Function<Pair<A,B>,Pair<A,R>> mapSecond(final Function<B,R> mapFunc) {
		return p -> new Pair<A,R>(p.a, mapFunc.apply(p.b));
	}
	
	private final A a;
	private final B b;
	
	public Pair(final A a, final B b) {
		this.a = a;
		this.b = b;
	}

	public A getA() {
		return a;
	}
	
	public A first() {
		return a;
	}

	public B getB() {
		return b;
	}
	
	public B second() {
		return b;
	}

}
