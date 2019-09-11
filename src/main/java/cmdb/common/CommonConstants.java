package cmdb.common;

public interface CommonConstants {
	String SUCCESS_STATUS = "success";
	String ERROR_STATUS = "error";
	
	
	/**
	 * Build related constants
	 */
	String ADD_BUILD = "INSERT INTO CMDB.BUILD "
			+ "(appName, "
			+ "appVersion, "
			+ "buildVersion,"
			+ "buildDate,"
			+ "buildStatus,"
			+ "buildBy,"
			+ "commitId) "
			+ "VALUES (?, ?, ?, ? , ?, ? , ? )";
	
	String ADD_BUILD_SUCCESS = "Build details added successfully.";
	String ADD_BUILD_FAILURE = "Build details add failed.";
	String TEST_MSG = "Build webservice test successful!!!";
	String SELECT_BUILD = "SELECT * FROM CMDB.BUILD ";
	String SELECT_BUILD_SUCCESS = "Build details fetched successfully.";
	String SELECT_BUILD_FAILURE = "Build details fetch failed, no data exists.";
}
