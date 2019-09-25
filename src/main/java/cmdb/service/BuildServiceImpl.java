package cmdb.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cmdb.bean.BaseResponse;
import cmdb.bean.Build;
import cmdb.dao.BuildDao;

@Service
public class BuildServiceImpl implements BuildService {
	
	@Autowired
	BuildDao buildDao;
	
	private static final Logger logger = Logger.getLogger(BuildServiceImpl.class);
	
	public BaseResponse<Build> addBuild(Build request) {
		// TODO Auto-generated method stub
		
		logger.info("In addBuild()");
		return buildDao.addBuild(request);
	}

	public BaseResponse<List<Build>> getBuild(Build request) throws IllegalArgumentException, IllegalAccessException {
		// TODO Auto-generated method stub
		logger.info("In getBuild()");
		return buildDao.getBuild(request);
	}

	public String getBuildId() {
		// TODO Auto-generated method stub
		logger.info("In getBuildId()");
		return buildDao.getBuildId();
	}

}
