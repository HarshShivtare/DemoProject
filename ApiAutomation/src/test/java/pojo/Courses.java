package pojo;

import java.util.List;

public class Courses {

	private List<WebAutomationSubclass> webAutomation;
	private List<ApiSubclass> api;
	private List<MobileSubclass> mobile;

	public List<WebAutomationSubclass> getWebAutomation() {
		return webAutomation;
	}

	public void setWebAutomation(List<WebAutomationSubclass> webAutomation) {
		this.webAutomation = webAutomation;
	}

	public List<ApiSubclass> getApi() {
		return api;
	}

	public void setApi(List<ApiSubclass> api) {
		this.api = api;
	}

	public List<MobileSubclass> getMobile() {
		return mobile;
	}

	public void setMobile(List<MobileSubclass> mobile) {
		this.mobile = mobile;
	}
}
