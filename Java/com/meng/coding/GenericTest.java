package com.meng.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GenericTest
{

	public static void main(String[] args)
	{
		List list = new ArrayList();
		list.add("");
		list.add(1);
		
		for (Object s : list) {
			
		}
		
		Map<Integer, Integer> map = new HashMap<>();
		BinaryOperator<Integer> mapper = (a, b) -> a + b;
		map.put(1, 1);
		map.put(2, 1);
		map.merge(1, 1, mapper);
		map.merge(3, 1, mapper);
		map.entrySet().stream().forEach(System.out::println);
		List<Number> list2 = new ArrayList<>();
		list2.add(4);
		list2.add(1.01);
		Number i = new Double(5.2);
		
		Stream<String> cats = Stream.of("leopard","lynx","ocelot","puma").parallel();
		Stream<String> bears = Stream.of("panda","grizzly","polar").parallel();
		ConcurrentMap<Boolean, List<String>> data = Stream.of(cats,bears)
				.flatMap(s -> s)
				.collect(Collectors.groupingByConcurrent(s -> !s.startsWith("p")));
		System.out.println(data.get(false).size()+" "+data.get(true).size());
		
		
	}

}
