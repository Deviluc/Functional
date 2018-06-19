package com.deviluc.functional.utils;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.testng.annotations.Test;

public class StreamUtilTest {
	
	@Test
	public void testGenerate() {
		final AtomicInteger c = new AtomicInteger(0);
		final List<Integer> l = StreamUtil.generate(i -> i < 10, c::getAndIncrement).collect(Collectors.toList());
		for (int i = 0; i < 10; i++) {
			assert i == l.get(i);
		}
		
		assert l.size() == 10;
	}
	
	@Test (enabled = false)
	public void testGenerateParallel() {
		final AtomicInteger c = new AtomicInteger(0);
		final List<Integer> l = StreamUtil.generate(i -> i < 10, c::getAndIncrement).parallel().collect(Collectors.toList());
		for (int i = 0; i < 10; i++) {
			assert i == l.get(i);
		}
		
		assert l.size() == 10;
	}

}
