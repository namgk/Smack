//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.03.25 at 02:42:22 PM PDT 
//


package org.jivesoftware.smackx.sensorread.packet;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="seqnr" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="queued" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "accepted")
public class SensorReadAccepted extends AbstractSensorReadRequest {

	public static final String ELEMENT = "accepted";
	
    public SensorReadAccepted() {
		super(ELEMENT);
	}

    @XmlAttribute(name = "queued")
    protected Boolean queued;

    /**
     * Gets the value of the queued property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isQueued() {
        if (queued == null) {
            return false;
        } else {
            return queued;
        }
    }

    /**
     * Sets the value of the queued property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setQueued(Boolean value) {
        this.queued = value;
    }

	@Override
	protected IQChildElementXmlStringBuilder getIQHoxtChildElementBuilder(
			IQChildElementXmlStringBuilder xml) {
		if (queued != null)
			xml.attribute("queued", "" + queued);
		xml.rightAngleBracket();
		return xml;
	}

}