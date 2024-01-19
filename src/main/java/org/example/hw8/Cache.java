package org.example.hw8;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Cache {
    CacheType cacheType() default CacheType.FILE;
    String fileNamePrefix() default "";
    boolean zip() default false;
    Class<?>[] identityBy() default List.class;
    long listList() default 0;
}
