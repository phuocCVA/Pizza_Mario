
package pizza_client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pizza_client package. 
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

    private final static QName _AddCommande_QNAME = new QName("http://pizzeria.mario.com/", "addCommande");
    private final static QName _GetClientFromOrder_QNAME = new QName("http://pizzeria.mario.com/", "getClientFromOrder");
    private final static QName _Transformer_QNAME = new QName("http://pizzeria.mario.com/", "Transformer");
    private final static QName _GetClientFromOrderResponse_QNAME = new QName("http://pizzeria.mario.com/", "getClientFromOrderResponse");
    private final static QName _AddCommandeResponse_QNAME = new QName("http://pizzeria.mario.com/", "addCommandeResponse");
    private final static QName _TransformerResponse_QNAME = new QName("http://pizzeria.mario.com/", "TransformerResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pizza_client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddCommandeResponse }
     * 
     */
    public AddCommandeResponse createAddCommandeResponse() {
        return new AddCommandeResponse();
    }

    /**
     * Create an instance of {@link TransformerResponse }
     * 
     */
    public TransformerResponse createTransformerResponse() {
        return new TransformerResponse();
    }

    /**
     * Create an instance of {@link GetClientFromOrder }
     * 
     */
    public GetClientFromOrder createGetClientFromOrder() {
        return new GetClientFromOrder();
    }

    /**
     * Create an instance of {@link AddCommande }
     * 
     */
    public AddCommande createAddCommande() {
        return new AddCommande();
    }

    /**
     * Create an instance of {@link GetClientFromOrderResponse }
     * 
     */
    public GetClientFromOrderResponse createGetClientFromOrderResponse() {
        return new GetClientFromOrderResponse();
    }

    /**
     * Create an instance of {@link Transformer }
     * 
     */
    public Transformer createTransformer() {
        return new Transformer();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCommande }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pizzeria.mario.com/", name = "addCommande")
    public JAXBElement<AddCommande> createAddCommande(AddCommande value) {
        return new JAXBElement<AddCommande>(_AddCommande_QNAME, AddCommande.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClientFromOrder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pizzeria.mario.com/", name = "getClientFromOrder")
    public JAXBElement<GetClientFromOrder> createGetClientFromOrder(GetClientFromOrder value) {
        return new JAXBElement<GetClientFromOrder>(_GetClientFromOrder_QNAME, GetClientFromOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Transformer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pizzeria.mario.com/", name = "Transformer")
    public JAXBElement<Transformer> createTransformer(Transformer value) {
        return new JAXBElement<Transformer>(_Transformer_QNAME, Transformer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClientFromOrderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pizzeria.mario.com/", name = "getClientFromOrderResponse")
    public JAXBElement<GetClientFromOrderResponse> createGetClientFromOrderResponse(GetClientFromOrderResponse value) {
        return new JAXBElement<GetClientFromOrderResponse>(_GetClientFromOrderResponse_QNAME, GetClientFromOrderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCommandeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pizzeria.mario.com/", name = "addCommandeResponse")
    public JAXBElement<AddCommandeResponse> createAddCommandeResponse(AddCommandeResponse value) {
        return new JAXBElement<AddCommandeResponse>(_AddCommandeResponse_QNAME, AddCommandeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransformerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pizzeria.mario.com/", name = "TransformerResponse")
    public JAXBElement<TransformerResponse> createTransformerResponse(TransformerResponse value) {
        return new JAXBElement<TransformerResponse>(_TransformerResponse_QNAME, TransformerResponse.class, null, value);
    }

}
