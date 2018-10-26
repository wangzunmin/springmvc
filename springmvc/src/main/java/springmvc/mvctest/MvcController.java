package springmvc.mvctest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MvcController{
	
	@RequestMapping("index")
	public String index(){
		return "jsp/index";
	}
	
	@RequestMapping("uploadFile")
	@ResponseBody
	public String uploadFile(HttpServletRequest request,String id){
		String parameter = request.getParameter("id");
		System.out.println(parameter);
		String uploadFile = FileUploadUtils.uploadFile(request, 0, "abc", "12345698756");
		return uploadFile;
	}
	
	@RequestMapping("deleteFile")
	@ResponseBody
	public boolean deleteFile(HttpServletRequest request){
		boolean deleteFile = FileUploadUtils.deleteFile("0/12345698756/abc/01.pdf", request);
		return deleteFile;
	}
	
	@RequestMapping("angular")
	public String angular(){
		return "jsp/angular";
	}
	
	@RequestMapping("personList")
	@ResponseBody
	public String personList(){
		List<Person> list = new ArrayList<Person>();
		List<Phone> phones = new ArrayList<Phone>();
		Phone phone = new Phone("iphone","4.7");
		phones.add(phone);
		Person person = new Person("tom", 11);
		person.setChild(true);
		person.setBirth(new Date());
		person.setPhones(phones);
		Person person1 = new Person("jack", 15);
		list.add(person);
		list.add(person1);
		String json = GsonUtils.gson.toJson(new WarpperJson(list));// 带泛型的list转化为json  
		System.out.println(json.toString());
		return json.toString();
	}
	
	
	@RequestMapping("timeOutTest")
	@ResponseBody
	public String timeOutTest() throws InterruptedException{
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxx");
		Thread.sleep(6000);
		return "success";
	}
	
	@RequestMapping("book/{id}")
	@ResponseBody
	public String getBookById(@PathVariable("id")Integer id){
		System.out.println(id);
		return "success";
	}
	
	
	@RequestMapping(value = "setUser")
	@ResponseBody
	public String setUser(HttpSession session, HttpServletRequest hRequest) {
	    User user = new User();
	    user.setName("lyf");
	    user.setPassword("123");
	    session.setAttribute("user", user);
	    return "success";
	}
	
	
	@RequestMapping(value = "user")
	@ResponseBody
	public String getUser(HttpSession session) {
	    User user = (User) session.getAttribute("user");
	    String name = user.getName();
	    return "用户名称：" + name;
	}
	
}
