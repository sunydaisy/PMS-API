package com.ocreatech.pms.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 记录操作日志
 * @author yanyaqin
 *
 */
@Retention(RUNTIME)
@Target({ TYPE, METHOD })
public @interface OperationLog {
	
	public String name() default "";

}
