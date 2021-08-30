package com.spring.grpc.server.commons;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public interface Mapper<S,D> {
	D to(S source);
	
	default List<D> collections(Iterator<S> iterator){
		Iterable<S> iterable = () -> iterator;
		return StreamSupport.stream(iterable.spliterator(), true).map(source -> to(source)).collect(Collectors.toList());
	}
}
