package springmvc.mvctest.lambda;

import java.awt.event.ActionListener;
import java.util.ArrayList;
//import java.util.function.BinaryOperator;

import com.google.common.collect.Lists;

/**
 * 函数式编程 - > 为了更好的模块化
 * 
 * add(1,2).multiply(3).subtract(4) 　merge([1,2],[3,4]).sort().search("2")
 * 
 * 
 * In mathematics, a category is an algebraic structure that comprises "objects"
 * that are linked by "arrows".范畴就是使用箭头连接的物体
 * 
 * 总之，在函数式编程中，函数就是一个管道（pipe）。这头进去一个值，那头就会出来一个新的值，没有其他作用。
 * 
 * @author WZM
 *
 *         2018年6月5日
 */
public class LambdaDemo {
	public static void main(String[] args) {
		// BinaryOperator<Long> addExplicit = (Long x, Long y) -> x + y;
		// BinaryOperator<Long> add = (x, y) -> (x + y);
		// Runnable noArguments = () -> System.out.println("Hello World");
		// ActionListener oneArgument = event ->
		// System.out.println("button clicked");
		// Runnable multiStatement = () -> {
		// System.out.println("Hello World");
		// System.out.println("Hello lambda");
		// };
//		streamTest();
	}

//	public static void streamTest() {
//		// Stream 是用函数式编程方式在集合类上进行复杂操作的工具。
//		ArrayList<Person> list = Lists.newArrayList(
//				new Person("tom1", "1", 10), new Person("tom2", "0", 11),
//				new Person("tom3", "0", 12), new Person("tom4", "1", 13));
//		long count = list.stream()
//				.filter(person -> {
//					System.out.println(person.getName());
//					return person.getGender().equals("1");
//				}).count();
//		System.out.println(count);
//	}
}
