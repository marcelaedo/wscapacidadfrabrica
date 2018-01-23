package cl.akzio.auth.central.obtenercapacidadfabrica.provider;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;



public class clienteEasyRedmine {


Client client = ClientBuilder.newClient();
Response response = client.target("https://private-anon-bbafd78696-easyredmine.apiary-proxy.com/time_entries.xml?project_id=project_id&issue_id=issue_id&period_type=period_type&period=period&from=from&to=to&user_id=user_id&offset=offset&limit=limit&page=page")
  .request(MediaType.TEXT_PLAIN_TYPE)
  .get();


	
	
}
