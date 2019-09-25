package cmdb.dao;

import java.util.List;

import cmdb.bean.BaseResponse;
import cmdb.bean.Build;

public interface BuildDao {

	BaseResponse<Build> addBuild(Build request);

	BaseResponse<List<Build>> getBuild(Build request) throws IllegalArgumentException, IllegalAccessException;
	
	String getBuildId() ;
}
