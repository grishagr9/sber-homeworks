package org.example.hw8;

import java.util.List;

public @interface Cache {
    CahceType cacheType() default CahceType.FILE;
    String fileNamePrefix() default "";
    boolean zip() default false;
    Class<?>[] identityBy() default List.class;
    long listList() default 0;
}
