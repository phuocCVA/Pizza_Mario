
package pizza_client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getClientFromOrder complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getClientFromOrder">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numeroOrder" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getClientFromOrder", propOrder = {
    "numeroOrder"
})
public class GetClientFromOrder {

    protected int numeroOrder;

    /**
     * Gets the value of the numeroOrder property.
     * 
     */
    public int getNumeroOrder() {
        return numeroOrder;
    }

    /**
     * Sets the value of the numeroOrder property.
     * 
     */
    public void setNumeroOrder(int value) {
        this.numeroOrder = value;
    }

}
