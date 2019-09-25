package cmdb.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Build {
	
	private String buildId;
	private String appName;
	private String appVersion;
	private String buildVersion;
	private String buildDate;
	private String buildStatus;
	private String buildBy;
	private String commitId;
	
}
