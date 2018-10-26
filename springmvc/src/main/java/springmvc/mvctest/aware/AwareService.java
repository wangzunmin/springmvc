package springmvc.mvctest.aware;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Service;

@Service("awareService123")
public class AwareService implements BeanNameAware {
	private String beanName;

	@Override
	public void setBeanName(String name) {
		this.beanName = name;
	}

	public void outputResult() {
		System.out.println("Bean的名称为：" + beanName);
	}

}
