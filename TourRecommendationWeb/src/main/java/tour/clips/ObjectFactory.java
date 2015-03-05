
package tour.clips;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the tour.clips package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ClipsEngine_QNAME = new QName("http://clips.tour/", "clipsEngine");
    private final static QName _ClipsEngineResponse_QNAME = new QName("http://clips.tour/", "clipsEngineResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: tour.clips
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ClipsEngineResponse }
     * 
     */
    public ClipsEngineResponse createClipsEngineResponse() {
        return new ClipsEngineResponse();
    }

    /**
     * Create an instance of {@link ClipsEngine }
     * 
     */
    public ClipsEngine createClipsEngine() {
        return new ClipsEngine();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClipsEngine }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://clips.tour/", name = "clipsEngine")
    public JAXBElement<ClipsEngine> createClipsEngine(ClipsEngine value) {
        return new JAXBElement<ClipsEngine>(_ClipsEngine_QNAME, ClipsEngine.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClipsEngineResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://clips.tour/", name = "clipsEngineResponse")
    public JAXBElement<ClipsEngineResponse> createClipsEngineResponse(ClipsEngineResponse value) {
        return new JAXBElement<ClipsEngineResponse>(_ClipsEngineResponse_QNAME, ClipsEngineResponse.class, null, value);
    }

}
