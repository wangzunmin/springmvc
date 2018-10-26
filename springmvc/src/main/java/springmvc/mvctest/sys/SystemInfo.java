package springmvc.mvctest.sys;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.StandardServletEnvironment;

/**
 * Aware 类型的接口用于向 Spring “索要”一些框架中的信息
 * @author WZM
 *
 * 2018年9月3日
 */
@Controller
@RequestMapping("/systeminfo")
public class SystemInfo implements ApplicationContextAware, EnvironmentAware {
	private ApplicationContext applicationContext;

    private Environment environment;
    
	@Override
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

	
	  @RequestMapping("/env")
	  @ResponseBody
	    public String environment() {
	        StandardServletEnvironment sse = (StandardServletEnvironment) environment;
	        Map<String, Object> envs = sse.getSystemEnvironment();
	        StringBuilder sb = new StringBuilder();
	        sb.append("-------------------------++ System Environment ++-------------------------\n");

	        List<String> list = new ArrayList<>();
	        list.addAll(envs.keySet());

	        for (int i = 0; i < 5 && i < list.size(); i++) {
	            String key = list.get(i);
	            Object val = envs.get(key);
	            sb.append(String.format("%s = %s\n", key, val.toString()));
	        }

	        Map<String, Object> props = sse.getSystemProperties();
	        sb.append("\n-------------------------++ System Properties ++-------------------------\n");
	        list.clear();
	        list.addAll(props.keySet());
	        for (int i = 0; i < 5 && i < list.size(); i++) {
	            String key = list.get(i);
	            Object val = props.get(key);
	            sb.append(String.format("%s = %s\n", key, val.toString()));
	        }

	        return sb.toString();
	    }

	    @RequestMapping("/beans")
	    @ResponseBody
	    public String listBeans() {
	        ListableBeanFactory lbf = applicationContext;
	        String[] beanNames = lbf.getBeanDefinitionNames();
	        StringBuilder sb = new StringBuilder();
	        sb.append("-------------------------++ Bean Info ++-------------------------\n");
	        for (String beanName : beanNames) {
	        	Object bean = lbf.getBean(beanName);
	            sb.append(String.format("beanName  = %s\n", beanName));
	            sb.append(String.format("beanClass = %s\n\n", bean.getClass().toString()));
			}
	        return sb.toString();
	    }
}
