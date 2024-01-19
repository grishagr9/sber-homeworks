package org.example.hw8;

import java.util.List;

public @interface Cache {
    CacheType cacheType() default CacheType.FILE;
    String fileNamePrefix() default "";
    boolean zip() default false;
    Class<?>[] identityBy() default List.class;
    long listList() default 0;
}
