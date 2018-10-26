package springmvc.mvctest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
/**
 * json与object的相互转换的工具类
 * @author wc
 *
 */
public class GsonUtils {
	public static Gson gson = new GsonBuilder()
			.excludeFieldsWithoutExposeAnnotation()//不导出实体中没有用@Expose注解的属性  
			.enableComplexMapKeySerialization() //支持Map的key为复杂对象的形式  
			.serializeNulls()   //空字段的值设置为null暴露出去
			.setDateFormat("yyyy-MM-dd")//格式化日期
			.setPrettyPrinting() //对json结果格式化.  
//			.setVersion(1.0)    //有的字段不是一开始就有的,会随着版本的升级添加进来,那么在进行序列化和返序列化的时候就会根据版本号来选择是否要序列化.  
                            //@Since(版本号)能完美地实现这个功能.还的字段可能,随着版本的升级而删除,那么  
                            //@Until(版本号)也能实现这个功能,GsonBuilder.setVersion(double)方法需要调用.  
			.create();
}
