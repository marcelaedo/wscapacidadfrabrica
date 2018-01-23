import javax.ws.rs.client.Client;
	import javax.ws.rs.client.ClientBuilder;
	import javax.ws.rs.core.Response;
	import javax.ws.rs.core.MediaType;
	
public class prubAER {

	
	
	
	public static void main(String[] args) {


		Client client = ClientBuilder.newClient();
		Response response = client.target("https://akzionet.easyredmine.com/time_entries.xml?key=70aec4d03acbf237207d2c30c801df55cffbb8b4&project_id=&415")
		  .request(MediaType.TEXT_PLAIN_TYPE)
		  .get();

		System.out.println("status: " + response.getStatus());
		System.out.println("headers: " + response.getHeaders());
		System.out.println("body:" + response.readEntity(String.class));


	}

}
