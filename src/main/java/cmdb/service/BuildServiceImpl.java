package cmdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cmdb.bean.BaseResponse;
import cmdb.bean.Build;
import cmdb.dao.BuildDao;

@Component
public class BuildServiceImpl implements BuildService {
	
	@Autowired
	BuildDao buildDao;
	
	public BaseResponse<Build> addBuild(Build request) {
		// TODO Auto-generated method stub
		return buildDao.addBuild(request);
	}

	public BaseResponse<List<Build>> getBuild(Build request) throws IllegalArgumentException, IllegalAccessException {
		// TODO Auto-generated method stub
		return buildDao.getBuild(request);
	}

}
