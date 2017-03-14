package cn.edu.zzia.bookstore.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

public class WebUtils {
	/**
	 * 生成全球唯一的uuid
	 * @return
	 */
	public static String makeID(){
		return UUID.randomUUID().toString();
	}

	/**
	 * 将src对象中的属性值拷贝到dest相应的属性中
	 * @param src
	 * @param dest
	 */
	public static void copyBean(Object src, Object dest){		
		//往里面转的时候，birthday的类型不一样，而beanUtils只支持8种基本数据类型的转化，所以要自己注册一个类型转换器
		//sun公司提供的String到Date的转换器有毛病，所以要自己写一个转换器
		ConvertUtils.register(new Converter() {
			public Object convert(Class type, Object value) {
				// 首先判断value的值是否为空，若是空则没必要转,否则将value转为String
				if (value == null) {
					return null;
				}
				// 转为String后判断str是否为空，防止恶意敲空格
				String str = (String) value;
				if (str.trim().equals("")) {
					return null;
				}
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd",Locale.CHINA);
				try {
					return df.parse(str);
				} catch (ParseException e) {
					throw new RuntimeException(e);
				}
			}
		}, Date.class);
		try {
			BeanUtils.copyProperties(dest, src);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
