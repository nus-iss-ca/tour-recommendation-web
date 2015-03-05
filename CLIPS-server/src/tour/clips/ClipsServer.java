package tour.clips;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface ClipsServer {
	@WebMethod
	public String[] clipsEngine(String country, String travel_with,
			int budgetRange, String preferences);
}
