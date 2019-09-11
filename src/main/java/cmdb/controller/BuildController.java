package cmdb.controller;

import java.util.List;

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

	@RequestMapping(value = "/add", 
			method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public BaseResponse<Build> addBuild(@RequestBody Build request) {

		System.out.println("Req is - " + request);		
		return buildService.addBuild(request);
	}

	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public BaseResponse<List<Build>> getBuild(@RequestBody Build request) throws IllegalArgumentException, IllegalAccessException {
		System.out.println("Req is - " + request);		
		return buildService.getBuild(request);
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public BaseResponse<String> test() {

		return new BaseResponse<String>(CommonConstants.SUCCESS_STATUS, "Build webservice test successful!!!", null);
	}


}
