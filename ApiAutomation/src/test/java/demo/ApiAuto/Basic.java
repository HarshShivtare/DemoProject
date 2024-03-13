package demo.ApiAuto;

import payloadData.payload;

public class Basic {
	public static void main(String[] args) {

		payload m = new payload();
		m.createPlace();
		
		payload.updateRequest();
		
		payload.getRequest();
	}
}
