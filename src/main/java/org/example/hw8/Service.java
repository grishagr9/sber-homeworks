package org.example.hw8;

import java.util.Date;
import java.util.List;

import static org.example.hw8.CahceType.FILE;
import static org.example.hw8.CahceType.IN_MEMORY;

interface Service {
    @Cache(cacheType = FILE, fileNamePrefix = "data", zip = true, identityBy = {String.class, double.class})
    List<String> run(String item, double value, Date date);

    @Cache(cacheType = IN_MEMORY, listList = 100_000)
    List<String> work(String item);
}