package springmvc.mvctest.guava;

import java.util.ArrayList;

import springmvc.mvctest.Employee;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;


/**
 * google guava study
 * @author WZM
 *
 * 2018年5月28日
 */
public class Guava {

	public static void main(String[] args) {
		preconditions();
	}
	
	
	
	
	public static void test1(){
		Optional<Integer> fromNullable = Optional.fromNullable(4);
		if(fromNullable.isPresent()){
			System.out.println(fromNullable.get());
		}else{
			System.out.println("fromNullable is null");
		}
	}
	
	public static void test2(){
		Optional<Integer> fromNullable = Optional.fromNullable(null);
		if(fromNullable.isPresent()){
			System.out.println(fromNullable.get());
		}else{
			System.out.println("fromNullable is null");
		}
	}
	
	public static void test3(){
		ArrayList<Employee> list = Lists.newArrayList(new Employee("tom", 30),new Employee("tom1", 12),null,new Employee("tom2", 15));
		int sum = 0;
		for (Employee employee : list) {
			Optional<Employee> fromNullable = Optional.fromNullable(employee);
			Employee or = fromNullable.or(new Employee("tom4", 0));
			sum +=or.getAge();
//			sum += Optional.fromNullable(employee).or(new Employee("tom4", 0)).getAge();
		}
		System.out.println(sum);
		
	}
	
	
	public static void preconditions(){
		Preconditions.checkArgument(0>1, "。。。。。。。。。。。。。。。。。");
	}
}
