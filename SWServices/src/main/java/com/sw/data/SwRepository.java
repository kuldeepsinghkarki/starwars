package com.sw.data;

import java.util.List;

/**
 * Repository interface for SW repository types
 * @param <T>
 */
public interface SwRepository<T> {

    public List<T> all();

    public T search(String name);


}
