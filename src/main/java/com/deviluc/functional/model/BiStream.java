package com.deviluc.functional.model;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Optional;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.stream.Collector;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class BiStream<A,B> {
	
	private Stream<Pair<A,B>> stream;
	
	public BiStream(final Stream<Pair<A,B>> stream) {
		this.stream = stream;
	}

	public Iterator<Pair<A,B>> iterator() {
		return stream.iterator();
	}

	public Spliterator<Pair<A,B>>  spliterator() {
		return stream.spliterator();
	}

	public boolean isParallel() {
		return stream.isParallel();
	}

	
	public BiStream<A, B> sequential() {
		stream = stream.sequential();
		return this;
	}

	
	public BiStream<A, B> parallel() {
		stream = stream.parallel();
		return this;
	}

	
	public BiStream<A, B> unordered() {
		stream = stream.unordered();
		return this;
	}

	
	public BiStream<A, B> onClose(Runnable closeHandler) {
		stream = stream.onClose(closeHandler);
		return this;
	}

	
	public void close() {
		stream.close();
	}

	
	public BiStream<A,B> filter(BiPredicate<A,B> predicate) {
		stream = stream.filter(p -> predicate.test(p.first(), p.second()));
		return this;
	}

	
	public <R> BiStream<R,B> mapFirst(Function<A, R> mapper) {
		return new BiStream<R,B>(stream.map(p -> Pair.of(mapper.apply(p.first()), p.second())));
	}
	
	public <R> BiStream<A,R> mapSecond(Function<B,R> mapper) {
		return new BiStream<A,R>(stream.map(p -> Pair.of(p.first(), mapper.apply(p.second()))));
	}
	
	public <R,S> BiStream<R,S> map(Function<A, R> firstMapper, Function<B, S> secondMapper) {
		return new BiStream<R,S>(stream.map(p -> Pair.of(firstMapper.apply(p.first()), secondMapper.apply(p.second()))));
	}
	
	public <R,S> BiStream<R,S> map(BiFunction<A, B, Pair<R,S>> mapper) {
		return new BiStream<R,S>(stream.map(p -> mapper.apply(p.first(), p.second())));
	}

	
	public IntStream mapToInt(BiFunction<A, B, Integer> mapper) {
		return stream.mapToInt(p -> mapper.apply(p.first(), p.second()));
	}

	
	public LongStream mapToLong(BiFunction<A, B, Long> mapper) {
		return stream.mapToLong(p -> mapper.apply(p.first(), p.second()));
	}

	
	public DoubleStream mapToDouble(ToDoubleFunction<? super A,B> mapper) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public <R> BiStream<R> flatMap(Function<? super A,B, ? extends BiStream<? extends R>> mapper) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public IntStream flatMapToInt(Function<? super A,B, ? extends IntStream> mapper) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public LongStream flatMapToLong(Function<? super A,B, ? extends LongStream> mapper) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public DoubleStream flatMapToDouble(Function<? super A,B, ? extends DoubleStream> mapper) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public BiStream<A,B> distinct() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public BiStream<A,B> sorted() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public BiStream<A,B> sorted(Comparator<? super A,B> comparator) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public BiStream<A,B> peek(Consumer<? super A,B> action) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public BiStream<A,B> limit(long maxSize) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public BiStream<A,B> skip(long n) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void forEach(Consumer<? super A,B> action) {
		// TODO Auto-generated method stub
		
	}

	
	public void forEachOrdered(Consumer<? super A,B> action) {
		// TODO Auto-generated method stub
		
	}

	
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public <A> A[] toArray(IntFunction<A[]> generator) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public A,B reduce(A,B identity, BinaryOperator<A,B> accumulator) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Optional<A,B> reduce(BinaryOperator<A,B> accumulator) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public <U> U reduce(U identity, BiFunction<U, ? super A,B, U> accumulator, BinaryOperator<U> combiner) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super A,B> accumulator,
			BiConsumer<R, R> combiner) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public <R, A> R collect(Collector<? super A,B, A, R> collector) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Optional<A,B> min(Comparator<? super A,B> comparator) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Optional<A,B> max(Comparator<? super A,B> comparator) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public boolean anyMatch(Predicate<? super A,B> predicate) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean allMatch(Predicate<? super A,B> predicate) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean noneMatch(Predicate<? super A,B> predicate) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public Optional<A,B> findFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Optional<A,B> findAny() {
		// TODO Auto-generated method stub
		return null;
	}

}
