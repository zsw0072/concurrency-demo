package com.concurrency.concurrencydemo.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 课程里用来标记线程"不推荐"的"安全的类或者写法"
 */
@Target(ElementType.TYPE) //注解的类型
@Retention(RetentionPolicy.SOURCE)  //注解存在的范围
public @interface NotRecommend {
    String value() default "";
}
