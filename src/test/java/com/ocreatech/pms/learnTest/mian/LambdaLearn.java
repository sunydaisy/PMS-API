package com.ocreatech.pms.learnTest.mian;

import com.ocreatech.pms.learnTest.inter.FunctionInterface;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LambdaLearn {
	
	public static void main(String[] args) {
		/**
		 * lambda 表达式学习
		 */
		// 1、lambda表达式的构成：参数列表(a,b)、 —> 、 函数体组成；如果参数列表只有一个参数可以省略括号，使用()表示没有参数
		// 2、lambda表达式实现了一个函数式接口，lambda表达式中的函数体就是该接口抽象方法的实现
		FunctionInterface function = (x,y)->x+y;
		log.info(String.valueOf(function.plusNum(2, 3)));
		log.info(function.getDefaultMessage("----哈哈"));
		log.info(FunctionInterface.getStaticMessage("--hehe"));
		// 3、lambda表达式函数体访问外部成员
		// 4、方法体内引用的外部变量，在Lambda表达式所在方法内对变量再次赋值时，编译器会报同样的错误。也就是意味着，换句话说，Lambda表达式引用的是值，而不是变量
		int a = 10;
		FunctionInterface function1 = (x,y)->{
			// 改变a的值,Local variable a defined in an enclosing scope must be final or effectively final
//			a = 11;
			x=x+a;
			y=y+a;
			return x+y;
		};
		log.info(String.valueOf(function1.plusNum(3, 4)));
		// 5、函数式接口(Functional Interface)是Java 8对一类特殊类型的接口的称呼。这类接口只定义了唯一的抽象方法的接口（除了隐含的Object对象的公共方法），用作Lambda表达式的类型。
		// 6、如FunctionInterface所示，函数式接口的特性： 
		//   只具有一个抽象方法的接口（可以包含default、static声明的方法）
		//   其可以被隐式转换为lambda表达式
		//   现有静态方法可以支持lambda表达式
		//   每个用作函数接口的接口都应添加 @FunctionalInterface注释
		
	      /*@FunctionalInterface
			public interface FunctionInterface {
	
				int plusNum(int x,int y);
				
				default String getDefaultMessage(String msg) {
					return "我是接口中的默认方法"+msg;
				}
				
				public static String getStaticMessage(String msg) {
					return "我是接口中的静态方法"+msg;
				}
			}*/
	}

}
