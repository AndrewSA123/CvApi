package com.qa.constants;

public class Constant {


	public static final String created = "Name created!";

	public static final String failed = "Name invalid";

	public static final String deleted = "Name deleted!";
	
	public static final String IP = "http://localhost:";

	public static final String port = "8082";

	public static final String endpoint = "/generate/name/";

	public static final String Consume = IP + port + endpoint;

	public static final String deleteQueue = "deleteQueue";

	public static final String queued = "Addedn to queue";

	public static final String queueName = "BabyNameQueue";

	public static final String[] illegalNames = new String[] { "batman", "nutella", "rambo" };

}
