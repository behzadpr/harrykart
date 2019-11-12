package se.atg.service.harrykart.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for loopType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="loopType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="lane" type="{}laneType" maxOccurs="unbounded" minOccurs="4"/>
 *       &lt;/sequence>
 *       &lt;attribute name="number" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "loopType", propOrder = {
        "lane"
})
public class Loop {

    @XmlElement(required = true)
    protected List<Lane> lane;
    @XmlAttribute(name = "number")
    protected Integer number;

    /**
     * Gets the value of the lane property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lane property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLane().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Lane }
     */
    public List<Lane> getLane() {
        if (lane == null) {
            lane = new ArrayList<Lane>();
        }
        return this.lane;
    }

    /**
     * Gets the value of the number property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setNumber(Integer value) {
        this.number = value;
    }

}
