package cmdb.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Deployment {
	
	private String envName;
	private String appName;
	private String appVersion;
	private String deployedBy;
	private String deploymentDate;
	private String deploymentStatus;
	private String buildVersion;
}
