package cmdb.service;

import java.util.List;

import cmdb.bean.BaseResponse;
import cmdb.bean.Build;

public interface BuildService {
	
	BaseResponse<Build> addBuild(Build request);
	
	BaseResponse<List<Build>> getBuild(Build request) throws IllegalArgumentException, IllegalAccessException;
}
