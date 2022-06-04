package com.sw.data;

import java.util.List;

public interface SwRepository<T> {

    public List<T> all();

    public T search(String name);


}
