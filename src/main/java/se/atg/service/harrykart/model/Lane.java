package se.atg.service.harrykart.model;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for laneType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="laneType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>integer">
 *       &lt;attribute name="number" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "laneType", propOrder = {
        "value"
})
public class Lane {

    @XmlValue
    protected Integer value;
    @XmlAttribute(name = "number")
    protected Integer number;

    /**
     * Gets the value of the value property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setValue(Integer value) {
        this.value = value;
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
