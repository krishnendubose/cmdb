package cmdb.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cmdb.bean.BaseResponse;
import cmdb.bean.Build;
import cmdb.common.CommonConstants;
import cmdb.service.BuildService;

@RestController
@RequestMapping("/build")
public class BuildController {
	
	@Autowired
	BuildService buildService;
	
	private static final Logger logger = Logger.getLogger(BuildController.class);

	@RequestMapping(value = "/add", 
			method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public BaseResponse<Build> addBuild(@RequestBody Build request) {
		request.setBuildId(buildService.getBuildId());
		logger.info("Req is - " + request);		
		return buildService.addBuild(request);
	}

	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public BaseResponse<List<Build>> getBuild(@RequestBody Build request) throws IllegalArgumentException, IllegalAccessException {
		logger.info("Req is - " + request);		
		return buildService.getBuild(request);
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public BaseResponse<String> test() {
		logger.info("Build webservice test successful!!!");
		return new BaseResponse<String>(CommonConstants.SUCCESS_STATUS, "Build webservice test successful!!!", null);
	}


}
