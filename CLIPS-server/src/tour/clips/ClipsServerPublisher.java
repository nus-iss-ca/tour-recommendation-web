package tour.clips;

import javax.xml.ws.Endpoint;

public class ClipsServerPublisher {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8081/WS/ClipsServer",
				new ClipsServerImpl());
	}
}
