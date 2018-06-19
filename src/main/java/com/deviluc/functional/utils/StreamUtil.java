package com.deviluc.functional.utils;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StreamUtil {
	
	private static final class GeneratorSplitterator<T> implements Spliterator<T> {
		
		private final Predicate<T> condition;
		private final Supplier<T> generator;
		
		public GeneratorSplitterator(final Predicate<T> condition, final Supplier<T> generator) {
			this.condition = condition;
			this.generator = generator;
		}

		@Override
		public boolean tryAdvance(Consumer<? super T> action) {
			final T t = generator.get();
			if (condition.test(t)) {
				action.accept(t);
				return true;
			}
			
			return false;
		}

		@Override
		public Spliterator<T> trySplit() {
			return new GeneratorSplitterator<>(condition, generator);
		}

		@Override
		public long estimateSize() {
			return Long.MAX_VALUE;
		}

		@Override
		public int characteristics() {
			return 0;
		}
		
	}
	
	/**
	 * Generates a {@link Stream} of elements until the condition doesn't evaluate to true on the generated object
	 * @param condition {@link Predicate}
	 * @param generator {@link Supplier}
	 * @return {@link Stream}
	 */
	public static <A> Stream<A> generate(final Predicate<A> condition, final Supplier<A> generator) {
		return StreamSupport.stream(new GeneratorSplitterator<A>(condition, generator), false);
	}
	
	/**
	 * Generates a {@link Stream} of elements until the generated element is null
	 * @param generator {@link Supplier}
	 * @return {@link Stream}
	 */
	public static <A> Stream<A> generate(final Supplier<A> generator) {
		return StreamSupport.stream(new GeneratorSplitterator<>(a -> a != null, generator), false);
	}
	
	public static <A>

}
