package cmdb.common;

import java.lang.reflect.Field;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;
import cmdb.bean.Build;

public class Util {
	private static final Logger logger = Logger.getLogger(Util.class);
	
	public static String fetchGetBuildQuery(Build request) throws IllegalArgumentException, IllegalAccessException {
		logger.info("In fetchGetBuildQuery()");
		
		StringBuilder query = new StringBuilder();
		Field[] fields = Build.class.getDeclaredFields();
		for(Field field: fields) {
			field.setAccessible(true);
			if(!StringUtils.isEmpty(field.get(request))){
				String queryPart = field.getName() + "='" + field.get(request) + "'";
				queryPart = StringUtils.isEmpty(query.toString())?" WHERE " + queryPart:" AND " + queryPart;
				query.append(queryPart);
			}
		}
		
		return query.toString();
	}
	
}
