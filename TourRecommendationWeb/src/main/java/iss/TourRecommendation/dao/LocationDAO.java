package iss.TourRecommendation.dao;

import iss.TourRecommendation.model.Location;

import java.util.HashMap;

public class LocationDAO {

	static HashMap<String, Location> locations;

	static {
		locations = new HashMap<String, Location>();

		locations
				.put("SAM",
						new Location(
								1,
								"Singapore Arts Museum",
								"The Singapore Art Museum focuses on international contemporary art practices, specialising in Singapore and Southeast Asia. Since the Singapore Art Museum (SAM) opened its doors in January 1996, the museum has amassed one of the world's largest public collections of modern and contemporary Southeast Asian artworks, with a growing component in international contemporary art. SAM, which now focuses on contemporary art, is housed in a restored 19th century mission school. SAM draws from its collection and collaborates with international contemporary art museums to curate and present contemporary art exhibitions. Contemporary art of the region is also given international exposure through SAM's travelling exhibition programme and collection loans.",
								"http://www.singaporeartmuseum.sg/about/",
								"1000 - 1815", "/Pics/Sentosa.PNG"));
		locations
				.put("ASM",
						new Location(
								2,
								"ArtsScience Museum",
								"The world's first ArtScience Museum™ at Marina Bay Sands is the Museum of Creativity, where the creative processes at the heart of art and science and their role in shaping society are explored.As a study of the creative processes that underlie the human experience, ArtScience seeks to understand what drives creative people, how they acquire their skills and how they work. ArtScience Museum presents exhibitions and programmes to deliver these stories using a combination of beautiful design, intriguing content and intellectual discussion, in order to inspire the creativity in all of us.",
								"https://m.facebook.com/ArtScienceMuseum/about?expand_all=1",
								"1000-1800 daily", "/Pics/Sentosa.PNG"));
		locations
				.put("ORC",
						new Location(
								3,
								"Orchard Road",
								"Spanning almost 2.2km, Orchard Road is a swanky, one-way boulevard flanked by distinctive and iconic shopping malls, restaurants and hotels.  The shopping belt offers nearly 800,000 sq m of retail, dining and entertainment options to please any taste or budget - from opulent brands to high street fashion, and exclusive restaurants to fast food joints.Outside of the malls, the main thoroughfare is immaculately landscaped with flowers and greenery, creating pockets of cool, natural calm amidst the hectic urban sprawl.  Explore the avenue by walking down the ample pedestrian mall, and take a well-deserved rest under the shade of the historic angsana trees that grace the sidewalks..Orchard Road is a shopper's haven and cosmopolitan playground set among a lush, tropical landscape that is ubiquitous in this Garden City. It is truly A Great Street!",
								"http://www.orchardroad.org/information/",
								"1100-2200", "/Pics/Sentosa.PNG"));
		locations
				.put("BUG",
						new Location(
								4,
								"Bugis Street",
								"In the 1950s, Bugis Street was renowned internationally for its notorious night activities, where flamboyantly dressed transvestites would gather and parade themselves, attracting sailors and military personnel from overseas. In the evening, the entire street would come alive as push carts gather to offer a wide selection of cheap goods and hawker food, hence earning its night market or “Pasar Malam” namesake.Today, Bugis Street has become a unique retail shopping destination. After undergoing a major facelift, Bugis Street now houses almost 800 shops, making it the largest street shopping location in Singapore. With a unique blend of retail concepts ranging from chic and fashionable clothing and accessories, to beauty services like manicure parlors and hair salons, you will be constantly enticed by the ever changing shopping landscape and its buzzing activities.",
								"http://www.yoursingapore.com/content/traveller/en/browse/shopping/shop-by-category/curios-and-knick-knacks/bugis-street.html",
								"1100-2200 daily", "/Pics/Sentosa.PNG"));
		locations
				.put("MUS",
						new Location(
								5,
								"Mustafa",
								"Rarely seen without a bustling crowd of customers, Mustafa Centre is set in the Little India district. A cult favourite in the Singaporean shopping scene, it’s the best place to go if you’re after a bargain or enjoy shopping late into the twilight hours. Mustafa may not be as fancy as some of Singapore’s other malls, but it has a great range of items, and good prices to match. Here, you’ll get a bargain on just about everything, from clothes, perfume, souvenirs, electronics, makeup, confectionery and even food and groceries. There is also a large selection of Indian apparel and accessories available here, which is not surprising, considering its location. Offering even travel, hotel reservation and visa assistance services, Mustafa Centre is a shopping experience unlike any other that shouldn’t be missed.",
								"http://www.yoursingapore.com/content/traveller/en/browse/shopping/shopping-malls/mustafa-centre.html",
								"0000-2400 daily", "/Pics/Sentosa.PNG"));
		locations
				.put("SEN",
						new Location(
								6,
								"Sentosa",
								"Located just 15 minutes from the city, Sentosa, Asia’s Favourite Playground, is home to an exciting array of themed attractions, award-winning spa retreats, lush rainforests, golden sandy beaches, resort accommodations, world-renowned golf courses, a deep-water yachting marina and luxurious residences. Spread over 500 hectares, the vibrant island resort is ideal for both business and leisure.In 2010, Sentosa welcomed Singapore’s first integrated resort, Resorts World™ Sentosa, which operates South East Asia’s first Universal Studios theme park.Located on the tranquil eastern end of the island sits Sentosa Cove, Singapore’s first and most exclusive marina residential community. This exclusive and unrivalled enclave offers tropical resort living, just minutes away from Singapore's city centre. With an already bustling residential community, Sentosa Cove will see over 2,000 homes nestled here by 2014. Together with romantic quayside restaurants, retail and specialty shops, Singapore’s only truly oceanfront residences, Sentosa Cove is quickly becoming the world’s most desirable address.",
								"http://www.sentosa.com.sg/en/about-us/sentosa-island/",
								"0000-2400 daily", "/Pics/Sentosa.PNG"));
		locations
				.put("SEN",
						new Location(
								6,
								"Sentosa",
								"Located just 15 minutes from the city, Sentosa, Asia’s Favourite Playground, is home to an exciting array of themed attractions, award-winning spa retreats, lush rainforests, golden sandy beaches, resort accommodations, world-renowned golf courses, a deep-water yachting marina and luxurious residences. Spread over 500 hectares, the vibrant island resort is ideal for both business and leisure.In 2010, Sentosa welcomed Singapore’s first integrated resort, Resorts World™ Sentosa, which operates South East Asia’s first Universal Studios theme park.Located on the tranquil eastern end of the island sits Sentosa Cove, Singapore’s first and most exclusive marina residential community. This exclusive and unrivalled enclave offers tropical resort living, just minutes away from Singapore's city centre. With an already bustling residential community, Sentosa Cove will see over 2,000 homes nestled here by 2014. Together with romantic quayside restaurants, retail and specialty shops, Singapore’s only truly oceanfront residences, Sentosa Cove is quickly becoming the world’s most desirable address.",
								"http://www.sentosa.com.sg/en/about-us/sentosa-island/",
								"0000-2400 daily", "/Pics/Sentosa.PNG"));
		locations
				.put("URA",
						new Location(
								7,
								"URA Gallery",
								"First opened in 1999, the Singapore City Gallery tells the story of Singapore's physical transformation over the past 50 years. Make time for highlights like the panoramic sights and sound show, A Day in Singapore and the Central Area Model Light and Sound Show. Or be awed by the architectural models or the various interactive and experiential exhibits in the gallery.",
								"www.ura.gov.sg/gallery/",
								"0900-1700 Mon-Sat, Sunday closed",
								"/Pics/Sentosa.PNG"));
		locations
				.put("GBB",
						new Location(
								8,
								"Gardens by the Bay",
								"Visit Gardens by the Bay, one of the Top 10 Indoor Gardens of the World, arguably the nation’s most beautiful masterpiece. Moreover, it was recently awarded the 2014 International Thea Awards for Outstanding Achievement - Botanical Garden, by the Themed Entertainment Association. Featuring the best of horticultural, sustainability and architectural design, Gardens by the Bay is filled with wonders from every continent except Antarctica. Explore diverse plant life from around the world displayed in its spectacular Cooled Conservatories or marvel at the Supertrees - towering vertical gardens that extend into the sky. Be inspired by nature and let your wonder bloom and experiences flourish.",
								"http://www.yoursingapore.com/content/traveller/en/browse/see-and-do/nature-and-wildlife/stroll-among-trees/gardens-by-the-bay.html",
								"0900-2100 daily", "/Pics/Sentosa.PNG"));
		locations
				.put("SGF",
						new Location(
								9,
								"Singapore Flyer",
								"The Singapore Flyer, a giant observation wheel that features brilliant engineering breakthroughs a world apart from the traditional ferris wheel, is set to be Asia's most visible iconic visitor attraction. It provides breathtaking, panoramic views of Singapore and beyond. The Singapore Flyer will transform the visual landscape of the surrounding Marina Bay area. Located at Marina Bay, it sits astride a three-storey Retail Terminal with an exciting array of retail and F&B choices. A central atrium opens out to a lush tropical rainforest, while an open-air theatre hosts live performances. Adding to the buzz of sights, sounds and activities will be a 210-metre long waterfront dining promenade. Standing at a stunning 165 metres, you will be able to experience remarkable scenes of the Singapore skyline: the magnificent Marina Bay, towering skyscrapers, tropical greenery, and the bright lights and non-stop action against the beautiful skies.Experience the breathtaking, panoramic views of Singapore and beyond in 37 minutes: the magnificent Marina Bay, towering skyscrapers, tropical greenery and the bright lights against the beautiful skies.",
								"http://www.singaporeflyer.com/", "0830-2215",
								"/Pics/Sentosa.PNG"));
		locations
				.put("MER",
						new Location(
								10,
								"Merlion Park",
								"You’ve probably seen images of Singapore’s national icon, the mythical Merlion with the head of a lion and the body of a fish. The body symbolises Singapore's humble beginnings as a fishing village when it was called Temasek, meaning 'sea town' in Old Javanese. Its head represents Singapore’s original name, Singapura, or ‘lion city’ in Malay. Today, you can glimpse this legend at Merlion Park. Spouting water from its mouth, the Merlion statue stands tall at 8.6 metres and weighs 70 tonnes. This icon is a ‘must-see’ for tourists visiting Singapore, similar to other significant landmarks around the world.",
								"http://www.yoursingapore.com/see-do-singapore/recreation-leisure/viewpoints/merlion-park.html",
								"0000-2400 (daily)", "/Pics/Sentosa.PNG"));
		locations
				.put("ZOO",
						new Location(
								11,
								"Zoo",
								"Since 1973, Singapore Zoo has been known for having among the most beautiful wildlife park settings in the world, where animals roam freely in open and naturalistic habitats. Nine-time winner of the coveted Best Leisure Attraction Experience award by the Singapore Tourism Board, our 26-hectare wildlife park is nestled within the lush Mandai rainforest that stretches into the magnificent Upper Seletar Reservoir. More than 2,800 animals representing over 300 species of mammals, birds and reptiles call Singapore Zoo home. Many of our animal habitats incorporate special viewing features such as elevated platforms to view our giraffe exhibit, underwater galleries to see the watery worlds of our otters, pygmy hippos and giant estuarine crocodiles, as well as glass observatories to see animals such as the predatory cheetahs and lions. On top of the fascinating perspective of the animals, you get to view them in environments that have been thoughtfully built and landscaped after their habitats in the wild.",
								"http://www.zoo.com.sg/visitor-info/park-experience.html",
								"0830-1800", "/Pics/Sentosa.PNG"));
		locations
				.put("SGB",
						new Location(
								12,
								"Sungei Buloh",
								"In 1986, a group of avid birdwatchers from the then Malayan Nature Society (Singapore Branch) stumbled upon this ecological jewel, and subsequently wrote a proposal to the government for its conservation. The 87 ha wetland site was consequently designated as a nature park in 1989. The then Parks & Recreation Department, a precursor to the National Parks Board, undertook the development of Sungei Buloh, in consultation with experts in the field, notably, the Wildfowl & Wetlands Trust from the United Kingdom and Worldwide Fund for Nature. On 6 Dec 1993, Prime Minister Goh Chok Tong officially opened the Nature Park. Over the years, the unique place that is Sungei Buloh charmed people from all strata of society to support its cause. It welcomed its 100,000th visitor in 1994. In 1997, the Park found its corporate sponsor in HSBC, which set up the Sungei Buloh Education Fund in support of its nature outreach programmes. In 1999, Woodlands Secondary School became the first school to adopt the park. It was followed by Commonwealth Secondary School in 2001 and Hillgrove Secondary in 2002.",
								"https://www.sbwr.org.sg/", "0700-1900",
								"/Pics/Sentosa.PNG"));
		locations
				.put("BOT",
						new Location(
								13,
								"Botanic Garden",
								"You’ll never guess, but a big part of why Singapore is nicknamed the Garden City can be found here at these sprawling grounds where the locals are fond of spending weekends, jogging, eating or just lazing about. Established in 1859 by the Agri-Horticultural Society, 60 acres of land were transformed from a disused plantation into the popular recreational garden you see today. Today, as well as being a favourite destination for recreation, the green space is also a leading centre for botanical and horticultural research.",
								"http://www.yoursingapore.com/see-do-singapore/nature-wildlife/parks-gardens/singapore-botanic-gardens.html",
								"0500-2400", "/Pics/Sentosa.PNG"));
		locations
				.put("STJ",
						new Location(
								14,
								"St James Power Station",
								"Singapore's Largest One-Stop Nightlife Destination, wheres theres something for everyone! Check-in @ the OFFICIAL SJPS page! There is now NO DOOR CHARGE at all* St James Power Station outlets from Sundays to Thursdays! (*except Powerhouse) Events & Functions enquires: 82885660",
								"www.stjamespowerstation.com/",
								"1800-2400,0000-0400 Wed - Fri, 2100-2400,0000-0400 Sat, 2200-2400,0000-0400 Sunday",
								"/Pics/Sentosa.PNG"));
		locations
				.put("ZOK",
						new Location(
								15,
								"Zouk",
								"Launched in March 1991, Zouk has grown into a club like none other in Asia. It has managed to retain its #5 ranking in the DJ Mag Top 100 Clubs global poll (generally considered to be the industry authority for this particular ranking) the past 2 years, no small feat given that Zouk is the only club from the Asia-Pacific region to regularly place in the top 10. With the central aim of propelling Asia's dance music culture forward and leading Singapore to the forefront of global clubbing by continuously pushing boundaries, Zouk has managed to not only put Singapore on the world dance map, it has evolved into a subculture of its own. This phenomenon has been reflected by many international publications, past and present, such as Rolling Stone (US), The Face (UK), Arena (UK), Time Out (UK), Wired (UK), Time (US), Newsweek (Asia), British Airways' Highlife (UK), The South China Morning Post (Hong Kong), Elle (Germany), Vogue (France) and Wallpaper just to name a few. It has also been covered extensively by the main dance culture magazines, namely Mixmag, Muzik, DJ and IDJ magazine.",
								"http://www.zoukclub.com.sg/", "0500-2400",
								"/Pics/Sentosa.PNG"));
		locations
				.put("CKQ",
						new Location(
								16,
								"Clarke Quay",
								"Launched in March 1991, Zouk has grown into a club like none other in Asia. It has managed to retain its #5 ranking in the DJ Mag Top 100 Clubs global poll (generally considered to be the industry authority for this particular ranking) the past 2 years, no small feat given that Zouk is the only club from the Asia-Pacific region to regularly place in the top 10. With the central aim of propelling Asia's dance music culture forward and leading Singapore to the forefront of global clubbing by continuously pushing boundaries, Zouk has managed to not only put Singapore on the world dance map, it has evolved into a subculture of its own. This phenomenon has been reflected by many international publications, past and present, such as Rolling Stone (US), The Face (UK), Arena (UK), Time Out (UK), Wired (UK), Time (US), Newsweek (Asia), British Airways' Highlife (UK), The South China Morning Post (Hong Kong), Elle (Germany), Vogue (France) and Wallpaper just to name a few. It has also been covered extensively by the main dance culture magazines, namely Mixmag, Muzik, DJ and IDJ magazine.",
								"http://www.zoukclub.com.sg/", "0500-2400",
								"/Pics/Sentosa.PNG"));
		locations
				.put("TOA",
						new Location(
								17,
								"Toa Payoh",
								"Toa Payoh is HDB’s second satellite town. Formerly a swampland, initial resistance from squatters to clearance works delayed development for the town by two years. Squatters began moving out in 1962 with actual site preparation in 1964, and in time for HDB's second five-year building programme in 1965.The town was developed based on the ‘Neighbourhood Principle’, which groups several neighbourhoods around a Town Centre. The town centre acts as a focal point for the entertainment and shopping needs of residents. ",
								"http://www.hdb.gov.sg/fi10/fi10320p.nsf/w/AboutUsTownToaPayoh",
								"0500-2400", "/Pics/Sentosa.PNG"));
		locations
				.put("TBR",
						new Location(
								18,
								"Tiong Bahru",
								"Toa Payoh is HDB’s second satellite town. Formerly a swampland, initial resistance from squatters to clearance works delayed development for the town by two years. Squatters began moving out in 1962 with actual site preparation in 1964, and in time for HDB's second five-year building programme in 1965.The town was developed based on the ‘Neighbourhood Principle’, which groups several neighbourhoods around a Town Centre. The town centre acts as a focal point for the entertainment and shopping needs of residents. ",
								"http://www.hdb.gov.sg/fi10/fi10320p.nsf/w/AboutUsTownToaPayoh",
								"0500-2400", "/Pics/Sentosa.PNG"));
		locations
				.put("KPG",
						new Location(
								19,
								"Kampong Glam",
								"Kampong Glam is a neighbourhood in Singapore. It is located north of the Singapore River, in the urban planning areas of Kallang and Rochor. The name of the area is thought to be derived from the cajeput tree, called 'gelam' in Malay. 'Kampong' (modern spelling 'kampung') simply means 'village'. Today, Kampong Glam still retains strong ties to the Native-Malay and Muslim community, and has sometimes been termed the 'Muslim Quarter' due to its history. The Muslim population still remains a significant presence in Kampong Glam, especially in Bussorah Street. The area remains a centre for Muslim activities and the Sultan Mosque remains a major landmark and congregation point for Singapore Muslims.",
								"http://www.kampongglam.org.sg/aboutUs_PlacesOfInterest.htm",
								"0500-2400", "/Pics/Sentosa.PNG"));
		locations
				.put("CHT",
						new Location(
								20,
								"Chinatown",
								"Singapore's Chinatown is an ethnic neighbourhood featuring distinctly Chinese cultural elements and a historically concentrated ethnic Chinese population. Chinatown is located within the larger district of Outram. As the largest ethnic group in Singapore is Chinese, Chinatown is considerably less of an enclave than it once was. (Note: The name Chinatown is given by the British and today usually used by non-Chinese Singaporeans, whereas Chinese Singaporeans usually use the term Niu Che Shui as the term Chinatown usually refers to enclaves of Chinese people in regions where Chinese people are the majority ethnic group.) However, the district does retain significant historical and cultural significance. Large sections of it have been declared national heritage sites officially designated for conservation by the Urban Redevelopment Authority.",
								"http://www.chinatown.sg/", "0500-2400",
								"/Pics/Sentosa.PNG"));
		locations
				.put("LTI",
						new Location(
								21,
								"Little India",
								"Little India is Singaporean neighbourhood east of the Singapore River—across from Chinatown, located west of the river—and north of Kampong Glam. Both areas are part of the urban planning area of Rochor. Little India is commonly known as Tekka in the local Tamil community. Rich in culture and deeply rooted in tradition, Singapore's Little India invites you to excite your senses. With a surge of flavours, sights, sounds, fragrances and an ethereal feel, Little India is a melting pot of all things Indian. Temples and heritage sites that talk of a culture of the years gone by adorn the streets of Little India depicting an aspect of devotion that that is engrained in every Indian.",
								"http://littleindia.com.sg/index.php",
								"0500-2400", "/Pics/Sentosa.PNG"));
		locations
				.put("CGM",
						new Location(
								22,
								"Changi Museum",
								"The Changi Museum was relocated to its new home on 15 February 2001 and was officially opened by our Trade and Industry Minister BG George Yeo. This date was also chosen to coincide with the 59th Anniversary of the fall of Singapore to the Japanese in 1942. The new Changi Museum replaces the Old Changi Prison Chapel and Museum (built in 1988) that was relocated to its current site to make way for the expansion of Changi Prison. In honouring the spirit and commitment of those who rose from the depths of adversity, the Museum inspires future generations to come and deepen their appreciation of the heroic and inspirational stories that unfolded in Changi during the war. The Changi Museum is dedicated to all those who lived and died in Singapore, in particular the Changi area, during the dark years of World War II. Through documentation of significant events of the Japanese Occupation, the Museum also serves as an important educational institution and resource centre. As for the Prisoners-of-War (POWs) and their families, it is a site that allows for closure of the many emotional scars inflicted by the war years.",
								"http://www.changimuseum.sg/", "0930-1700",
								"/Pics/Sentosa.PNG"));
		locations
				.put("SCC",
						new Location(
								23,
								"Science Center",
								"The Science Centre Singapore, a leading regional Science Centre, celebrates 37 years of promoting interest and creative learning in science and technology. It prides itself on making science an inspiring and exciting experience for people of all ages. Over the past 37 years, the Centre has been a custodian of creativity and innovation, capturing the evolution of scientific developments through unique and relevant exhibitions and shows and continues to ignite young minds and foster new generations of scientifically savvy Singaporeans. Our many interactive exhibits, housed in 14 galleries, cover a wide range of topics related to science, technology and mathematics. There is an additional 20,000m2 of outdoor exhibition space showcasing the Waterworks exhibition, Kinetic Garden and Ecogarden. We also offer a wide range of enrichment programmes for students aimed at complementing the school's formal science education as well as enriching and fun events, competitions and outreach activities for everyone.",
								"http://www.science.edu.sg/", "1000-1800",
								"/Pics/Sentosa.PNG"));
		locations
				.put("WWW",
						new Location(
								24,
								"Wild Wild Wet",
								"Opened in 2004, Wild Wild Wet is one of Singapore’s largest water parks. We promise you a day of thrills and spills for the whole family. Situated at Downtown East, it remains one of the most popular family attractions in Singapore by NTUC Club. From adrenalin-pumping rides to relaxing and gentle ones, visitors are guaranteed a fun-filled day while they beat the heat. Amidst the fun, our guests' safety remains our top priority. Various inflatable floats customised for different rides ensure adventures come with safety in mind as well. To enhance safety, life jackets are available for free usage for adults and children. Baby water carriers are also available for free to allow parents to have a splashing good time with their infants. Our lifeguards are specially trained in stringent international standards for lifeguarding at water-based attractions. Wild Wild Wet was awarded the Pro-Family Business Mark for providing numerous family-friendly facilities such as lifejackets, baby carriers, nursing rooms and children's shower cubicles.",
								"http://www.wildwildwet.com/",
								"closed on Tuesday, 1300-1900, Mon, Wed-Fri, 1000-1900, Sat-Sun",
								"/Pics/Sentosa.PNG"));
		locations
				.put("LPS",
						new Location(
								25,
								"Lau Pat Sat",
								"The grande dame of markets in Singapore, Lau Pa Sat blends history, striking architecture and scrumptious local food into one heady experience. Built in the 19th century, Lau Pa Sat or Telok Ayer Market has long dominated the local landscape with its striking presence. A true Singapore landmark, it was gazetted as a national monument in 1973.",
								"http://www.yoursingapore.com/see-do-singapore/architecture/historical/lau-pa-sat.html",
								"N/A", "/Pics/Sentosa.PNG"));
		locations
				.put("ECP",
						new Location(
								26,
								"East Coast Park",
								"If there’s one place in Singapore that’s synonymous with outdoor revelry, it’s East Coast Park, where some seven million locals and tourists flock to for the variety of sporting, entertainment and dining attractions. Along this 15-kiliometre stretch of beach, you’ll find hordes of cyclists and roller bladers enjoying the sun and sea breeze, while cable skiing and water sports are on offer for those who prefer wetter pursuits. The action goes up several notches at the world-class Xtreme SkatePark, a place where adrenaline junkies can get their fix. It’s a great place to just sit back and relax too, with no shortage of restaurants, bars and cafes along the beaches to sip on a cocktail or grab a bite. Keep it simple and have a picnic with family and friends by the beach under the swaying coconut palms and Casuarinas.",
								"http://www.yoursingapore.com/see-do-singapore/nature-wildlife/parks-gardens/east-coast-park.html",
								"N/A", "/Pics/Sentosa.PNG"));
	}

	public static Location getLocation(String code) {
		System.out.println("LocationDAO.getLocation()" + code);
		return locations.get(code);
	}

}
