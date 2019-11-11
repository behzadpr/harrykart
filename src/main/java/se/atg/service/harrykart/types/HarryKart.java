package se.atg.service.harrykart.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigInteger;


/**
 * <p>Java class for harryKartType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="harryKartType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numberOfLoops" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="startList" type="{}startListType"/>
 *         &lt;element name="powerUps" type="{}powerUpsType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "harryKartType", propOrder = {
        "numberOfLoops",
        "startList",
        "powerUps"
})
public class HarryKart {

    @XmlElement(required = true)
    protected Integer numberOfLoops;
    @XmlElement(required = true)
    protected StartList startList;
    @XmlElement(required = true)
    protected PowerUps powerUps;

    /**
     * Gets the value of the numberOfLoops property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getNumberOfLoops() {
        return numberOfLoops;
    }

    /**
     * Sets the value of the numberOfLoops property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setNumberOfLoops(Integer value) {
        this.numberOfLoops = value;
    }

    /**
     * Gets the value of the startList property.
     *
     * @return possible object is
     * {@link StartList }
     */
    public StartList getStartList() {
        return startList;
    }

    /**
     * Sets the value of the startList property.
     *
     * @param value allowed object is
     *              {@link StartList }
     */
    public void setStartList(StartList value) {
        this.startList = value;
    }

    /**
     * Gets the value of the powerUps property.
     *
     * @return possible object is
     * {@link PowerUps }
     */
    public PowerUps getPowerUps() {
        return powerUps;
    }

    /**
     * Sets the value of the powerUps property.
     *
     * @param value allowed object is
     *              {@link PowerUps }
     */
    public void setPowerUps(PowerUps value) {
        this.powerUps = value;
    }

}
