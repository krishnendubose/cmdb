package cmdb.dao;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import cmdb.bean.BaseResponse;
import cmdb.bean.Build;
import cmdb.common.CommonConstants;

@Repository
public class BuildDaoImpl implements BuildDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public BaseResponse<Build> addBuild(Build request) {
		// TODO Auto-generated method stub
		int numOfRows = jdbcTemplate.update(CommonConstants.ADD_BUILD, new Object[] {
				request.getAppName(),
				request.getAppVersion(),
				request.getBuildVersion(),
				request.getBuildDate(),
				request.getBuildStatus(),
				request.getBuildBy(),
				request.getCommitId()});
		if(numOfRows>0) {
			return new BaseResponse<Build>(CommonConstants.SUCCESS_STATUS,  CommonConstants.ADD_BUILD_SUCCESS,request);
		}
		else {
			return new BaseResponse<Build>(CommonConstants.ERROR_STATUS, CommonConstants.ADD_BUILD_FAILURE,request);
		}
	}

	public BaseResponse<List<Build>> getBuild(Build request) throws IllegalArgumentException, IllegalAccessException {
		// TODO Auto-generated method stub
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
		System.out.println("Final query for Build data selection: " + query.insert(0, CommonConstants.SELECT_BUILD).toString());
		
		 @SuppressWarnings({ "unchecked", "rawtypes" })
		List<Build> customers = jdbcTemplate.query(
				 query.toString(),
	                new BeanPropertyRowMapper(Build.class));
		
		if(!Objects.isNull(customers) && customers.size() > 0 ) {
			return new BaseResponse<List<Build>>(CommonConstants.SUCCESS_STATUS,  CommonConstants.SELECT_BUILD_SUCCESS,customers);
		}
		else {
			return new BaseResponse<List<Build>>(CommonConstants.ERROR_STATUS, CommonConstants.SELECT_BUILD_FAILURE,customers);
		}

	}

}
