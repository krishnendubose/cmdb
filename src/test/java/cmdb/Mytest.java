package cmdb;

import cmdb.bean.Build;

public class Mytest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Build build = new Build();
		build.setAppName("java");
		build.setAppVersion("1.8");
		build.setBuildBy("krish");
		build.setBuildDate("23/08/2019");
		build.setBuildStatus("Success");
		build.setBuildVersion("x.x");
		System.out.println(build);
	}

}
