
package pizza_client;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "MarioWebService", targetNamespace = "http://pizzeria.mario.com/", wsdlLocation = "http://localhost:8080/Mario_pizza/MarioWebService?wsdl")
public class MarioWebService_Service
    extends Service
{

    private final static URL MARIOWEBSERVICE_WSDL_LOCATION;
    private final static WebServiceException MARIOWEBSERVICE_EXCEPTION;
    private final static QName MARIOWEBSERVICE_QNAME = new QName("http://pizzeria.mario.com/", "MarioWebService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/Mario_pizza/MarioWebService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        MARIOWEBSERVICE_WSDL_LOCATION = url;
        MARIOWEBSERVICE_EXCEPTION = e;
    }

    public MarioWebService_Service() {
        super(__getWsdlLocation(), MARIOWEBSERVICE_QNAME);
    }

    public MarioWebService_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), MARIOWEBSERVICE_QNAME, features);
    }

    public MarioWebService_Service(URL wsdlLocation) {
        super(wsdlLocation, MARIOWEBSERVICE_QNAME);
    }

    public MarioWebService_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, MARIOWEBSERVICE_QNAME, features);
    }

    public MarioWebService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MarioWebService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns MarioWebService
     */
    @WebEndpoint(name = "MarioWebServicePort")
    public MarioWebService getMarioWebServicePort() {
        return super.getPort(new QName("http://pizzeria.mario.com/", "MarioWebServicePort"), MarioWebService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns MarioWebService
     */
    @WebEndpoint(name = "MarioWebServicePort")
    public MarioWebService getMarioWebServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://pizzeria.mario.com/", "MarioWebServicePort"), MarioWebService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (MARIOWEBSERVICE_EXCEPTION!= null) {
            throw MARIOWEBSERVICE_EXCEPTION;
        }
        return MARIOWEBSERVICE_WSDL_LOCATION;
    }

}
