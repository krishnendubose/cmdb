package cmdb.dao;

import java.util.List;
import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import cmdb.bean.BaseResponse;
import cmdb.bean.Build;
import cmdb.common.CommonConstants;
import cmdb.common.Util;

@Repository
public class BuildDaoImpl implements BuildDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private static final Logger logger = Logger.getLogger(BuildDaoImpl.class);

	public BaseResponse<Build> addBuild(Build request) {
		logger.info("In addBuild()");
		
		int numOfRows = jdbcTemplate.update(CommonConstants.ADD_BUILD, new Object[] {
				request.getBuildId(),
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
		logger.info("In getBuild()");
		
		StringBuilder query = new StringBuilder()
				.append(Util.fetchGetBuildQuery(request))
				.insert(0, CommonConstants.SELECT_BUILD);		
		logger.info("Final query for Build data selection: " + query.toString());
		
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

	public String getBuildId() {
		// TODO Auto-generated method stub
		
		logger.info("In getBuildId()");
		return jdbcTemplate.queryForObject(CommonConstants.GET_BUILD_ID, String.class);
	}
	
	
	

}
