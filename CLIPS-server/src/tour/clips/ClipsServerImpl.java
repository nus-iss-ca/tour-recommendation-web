package tour.clips;

import javax.jws.WebService;

import CLIPSJNI.Environment;
import CLIPSJNI.PrimitiveValue;

@WebService(endpointInterface = "tour.clips.ClipsServer")
public class ClipsServerImpl implements ClipsServer {

	Environment clips;

	public ClipsServerImpl() {
		super();
		initClipsEngine();
	}

	private void initClipsEngine() {
		System.out.println("Initialising clips engine...");
		clips = new Environment();
		clips.load("TourInferenceEngine.clp");
		clips.run();
		clips.reset();
	}

	public String[] clipsEngine(String country, String travel_with,
			int budgetRange, String preferences) {

		clips.assertString("(country " + country + ")");

		clips.assertString("(companion " + travel_with.toLowerCase() + ")");

		clips.assertString("(budget " + budgetRange + ")");

		clips.assertString("(activity " + preferences.toLowerCase() + ")");

		clips.run();
		String[] attraction_codes = null;
		// (recommend_goal (goal ?a ?b ?c ?d)(cf ?a1 ?b1 ?c1 ?d1)(rank ?r1
		// ?r2 ?r3 ?r4))
		String evaluate = "(find-all-facts ((?p recommend_goal)) TRUE)";
		PrimitiveValue value = clips.eval(evaluate);
		try {
			attraction_codes = value.get(0).getFactSlot("goal").toString()
					.replaceAll("\\p{P}", "").split("\\s+");
			System.out
					.println("*********Resetting the clips engine***********");
			clips.reset();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return attraction_codes;
	}
}
