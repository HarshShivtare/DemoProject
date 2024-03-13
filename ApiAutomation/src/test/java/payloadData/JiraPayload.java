package payloadData;

public class JiraPayload {

	public static String createSession() {
		return "{ \"username\": \"Harshal\", \"password\": \"Kitty@8889\" }";
	}
	
	public static String addComment(String message) {
		return "{\r\n"
				+ "    \"body\": \""+message+"\",\r\n"
				+ "    \"visibility\": {\r\n"
				+ "        \"type\": \"role\",\r\n"
				+ "        \"value\": \"Administrators\"\r\n"
				+ "    }\r\n"
				+ "}";
	}
}
