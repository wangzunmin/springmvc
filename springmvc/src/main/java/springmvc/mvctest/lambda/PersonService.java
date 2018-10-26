package springmvc.mvctest.lambda;

import java.util.ArrayList;
import java.util.List;

public class PersonService {
	//假设这个list是通过已有接口返回的所有Person集合
    private static List<Person> list = new ArrayList<Person>();

//    public static List<Person> findByName(String name){
//    	return find((Person p)-> name.equals(p.getName())); //Lambda表达式
//    }

    public static List<Person> findByGender(final String gender){
       return find(new Criteria(){
		@Override
		public boolean matches(Person person) {
			return gender.equals(person.getGender());
		}
       });
    }
    
    public static List<Person> find(Criteria criteria){
        List<Person> people = new ArrayList<>();
        for (Person p : list){
            if(criteria.matches(p)){
                people.add(p);
            }
        }
        return people;
    }
}
