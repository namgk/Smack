/**
 *
 * Copyright 2003-2006 Jive Software.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jivesoftware.smackx.sensorread.packet;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.util.XmlStringBuilder;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="node">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="nodeId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="sourceId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="cacheType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="field">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/choice>
 *       &lt;attGroup ref="{urn:xmpp:iot:sensordata}fieldTypes"/>
 *       &lt;attribute name="seqnr" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="all" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="historical" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="from" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="to" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="when" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="serviceToken" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="deviceToken" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="userToken" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * Auto generated by JAXB framework from XEP 323 schema (http://xmpp.org/extensions/xep-0323.html#schema)
 * This class represents an element type of 'req'
 * 
 * @author Nam Giang - kyng at ece dot ubc dot ca
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "nodeOrField"
})
@XmlRootElement(name = "req", namespace = "urn:xmpp:iot:sensordata")
public class SensorReadRequest extends AbstractSensorReadRequest {

	public static final String ELEMENT = "req";
	
    public SensorReadRequest() {
		super(ELEMENT);
	}

	@XmlElements({
        @XmlElement(name = "node", namespace = "urn:xmpp:iot:sensordata", type = SensorReadRequest.Node.class),
        @XmlElement(name = "field", namespace = "urn:xmpp:iot:sensordata", type = SensorReadRequest.Field.class)
    })
	
    protected List<Field> fields = new ArrayList<SensorReadRequest.Field>();
	protected List<Node> nodes = new ArrayList<SensorReadRequest.Node>();
    @XmlAttribute(name = "all")
    protected Boolean all;
    @XmlAttribute(name = "historical")
    protected Boolean historical;
    @XmlAttribute(name = "from")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fromTime;
    @XmlAttribute(name = "to")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar toTime;
    @XmlAttribute(name = "when")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar when;
    @XmlAttribute(name = "serviceToken")
    protected String serviceToken;
    @XmlAttribute(name = "deviceToken")
    protected String deviceToken;
    @XmlAttribute(name = "userToken")
    protected String userToken;
    @XmlAttribute(name = "momentary")
    protected Boolean momentary;
    @XmlAttribute(name = "peak")
    protected Boolean peak;
    @XmlAttribute(name = "status")
    protected Boolean status;
    @XmlAttribute(name = "computed")
    protected Boolean computed;
    @XmlAttribute(name = "identity")
    protected Boolean identity;
    @XmlAttribute(name = "historicalSecond")
    protected Boolean historicalSecond;
    @XmlAttribute(name = "historicalMinute")
    protected Boolean historicalMinute;
    @XmlAttribute(name = "historicalHour")
    protected Boolean historicalHour;
    @XmlAttribute(name = "historicalDay")
    protected Boolean historicalDay;
    @XmlAttribute(name = "historicalWeek")
    protected Boolean historicalWeek;
    @XmlAttribute(name = "historicalMonth")
    protected Boolean historicalMonth;
    @XmlAttribute(name = "historicalQuarter")
    protected Boolean historicalQuarter;
    @XmlAttribute(name = "historicalYear")
    protected Boolean historicalYear;
    @XmlAttribute(name = "historicalOther")
    protected Boolean historicalOther;

    /**
     * Gets the value of the nodeOrField property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nodeOrField property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNodeOrField().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SensorReadRequest.Node }
     * {@link SensorReadRequest.Field }
     * 
     * 
     */
    public List<Node> getNodes() {
        if (nodes == null) {
            nodes = new ArrayList<Node>();
        }
        return this.nodes;
    }
    
    public void addNode(Node n){
    	getNodes().add(n);
    }
    
    public List<Field> getFields() {
        if (fields == null) {
        	fields = new ArrayList<Field>();
        }
        return this.fields;
    }
    
    public void addField(Field f){
    	getFields().add(f);
    }

//    /**
//     * Gets the value of the seqnr property.
//     * 
//     */
//    public int getSeqnr() {
//        return seqnr;
//    }
//
//    /**
//     * Sets the value of the seqnr property.
//     * 
//     */
//    public void setSeqnr(int value) {
//        this.seqnr = value;
//    }

    /**
     * Gets the value of the all property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isAll() {
        if (all == null) {
            return false;
        } else {
            return all;
        }
    }

    /**
     * Sets the value of the all property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAll(Boolean value) {
        this.all = value;
    }

    /**
     * Gets the value of the historical property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isHistorical() {
        if (historical == null) {
            return false;
        } else {
            return historical;
        }
    }

    /**
     * Sets the value of the historical property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHistorical(Boolean value) {
        this.historical = value;
    }

    /**
     * Gets the value of the from property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFromTime() {
        return fromTime;
    }

    /**
     * Sets the value of the from property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFromTime(XMLGregorianCalendar value) {
        this.fromTime = value;
    }

    /**
     * Gets the value of the to property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getToTime() {
        return toTime;
    }

    /**
     * Sets the value of the to property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTo(XMLGregorianCalendar value) {
        this.toTime = value;
    }

    /**
     * Gets the value of the when property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getWhen() {
        return when;
    }

    /**
     * Sets the value of the when property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setWhen(XMLGregorianCalendar value) {
        this.when = value;
    }

    /**
     * Gets the value of the serviceToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceToken() {
        return serviceToken;
    }

    /**
     * Sets the value of the serviceToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceToken(String value) {
        this.serviceToken = value;
    }

    /**
     * Gets the value of the deviceToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviceToken() {
        return deviceToken;
    }

    /**
     * Sets the value of the deviceToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceToken(String value) {
        this.deviceToken = value;
    }

    /**
     * Gets the value of the userToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserToken() {
        return userToken;
    }

    /**
     * Sets the value of the userToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserToken(String value) {
        this.userToken = value;
    }

    /**
     * Gets the value of the momentary property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isMomentary() {
        if (momentary == null) {
            return false;
        } else {
            return momentary;
        }
    }

    /**
     * Sets the value of the momentary property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMomentary(Boolean value) {
        this.momentary = value;
    }

    /**
     * Gets the value of the peak property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isPeak() {
        if (peak == null) {
            return false;
        } else {
            return peak;
        }
    }

    /**
     * Sets the value of the peak property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPeak(Boolean value) {
        this.peak = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isStatus() {
        if (status == null) {
            return false;
        } else {
            return status;
        }
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setStatus(Boolean value) {
        this.status = value;
    }

    /**
     * Gets the value of the computed property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isComputed() {
        if (computed == null) {
            return false;
        } else {
            return computed;
        }
    }

    /**
     * Sets the value of the computed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setComputed(Boolean value) {
        this.computed = value;
    }

    /**
     * Gets the value of the identity property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isIdentity() {
        if (identity == null) {
            return false;
        } else {
            return identity;
        }
    }

    /**
     * Sets the value of the identity property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIdentity(Boolean value) {
        this.identity = value;
    }

    /**
     * Gets the value of the historicalSecond property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isHistoricalSecond() {
        if (historicalSecond == null) {
            return false;
        } else {
            return historicalSecond;
        }
    }

    /**
     * Sets the value of the historicalSecond property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHistoricalSecond(Boolean value) {
        this.historicalSecond = value;
    }

    /**
     * Gets the value of the historicalMinute property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isHistoricalMinute() {
        if (historicalMinute == null) {
            return false;
        } else {
            return historicalMinute;
        }
    }

    /**
     * Sets the value of the historicalMinute property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHistoricalMinute(Boolean value) {
        this.historicalMinute = value;
    }

    /**
     * Gets the value of the historicalHour property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isHistoricalHour() {
        if (historicalHour == null) {
            return false;
        } else {
            return historicalHour;
        }
    }

    /**
     * Sets the value of the historicalHour property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHistoricalHour(Boolean value) {
        this.historicalHour = value;
    }

    /**
     * Gets the value of the historicalDay property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isHistoricalDay() {
        if (historicalDay == null) {
            return false;
        } else {
            return historicalDay;
        }
    }

    /**
     * Sets the value of the historicalDay property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHistoricalDay(Boolean value) {
        this.historicalDay = value;
    }

    /**
     * Gets the value of the historicalWeek property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isHistoricalWeek() {
        if (historicalWeek == null) {
            return false;
        } else {
            return historicalWeek;
        }
    }

    /**
     * Sets the value of the historicalWeek property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHistoricalWeek(Boolean value) {
        this.historicalWeek = value;
    }

    /**
     * Gets the value of the historicalMonth property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isHistoricalMonth() {
        if (historicalMonth == null) {
            return false;
        } else {
            return historicalMonth;
        }
    }

    /**
     * Sets the value of the historicalMonth property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHistoricalMonth(Boolean value) {
        this.historicalMonth = value;
    }

    /**
     * Gets the value of the historicalQuarter property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isHistoricalQuarter() {
        if (historicalQuarter == null) {
            return false;
        } else {
            return historicalQuarter;
        }
    }

    /**
     * Sets the value of the historicalQuarter property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHistoricalQuarter(Boolean value) {
        this.historicalQuarter = value;
    }

    /**
     * Gets the value of the historicalYear property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isHistoricalYear() {
        if (historicalYear == null) {
            return false;
        } else {
            return historicalYear;
        }
    }

    /**
     * Sets the value of the historicalYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHistoricalYear(Boolean value) {
        this.historicalYear = value;
    }

    /**
     * Gets the value of the historicalOther property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isHistoricalOther() {
        if (historicalOther == null) {
            return false;
        } else {
            return historicalOther;
        }
    }

    /**
     * Sets the value of the historicalOther property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHistoricalOther(Boolean value) {
        this.historicalOther = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Field implements NamedElement {

    	public static final String ELEMENT = "field";
    	
        @XmlAttribute(name = "name", required = true)
        protected String name;

        public Field(String name){
        	this.name = name;
        }
        /**
         * Gets the value of the name property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }
		@Override
		public CharSequence toXML() {
			XmlStringBuilder xml = new XmlStringBuilder(this);
			xml.attribute("name", name);
            xml.rightAngleBracket();
            xml.closeElement(this);
            return xml;
		}
		@Override
		public String getElementName() {
			return ELEMENT;
		}

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="nodeId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="sourceId" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="cacheType" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Node implements NamedElement {

    	public static final String ELEMENT = "node";
    	
        @XmlAttribute(name = "nodeId", required = true)
        protected String nodeId;
        @XmlAttribute(name = "sourceId")
        protected String sourceId;
        @XmlAttribute(name = "cacheType")
        protected String cacheType;

        public Node(String nodeId){
        	this.nodeId = nodeId;
        }
        /**
         * Gets the value of the nodeId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNodeId() {
            return nodeId;
        }

        /**
         * Sets the value of the nodeId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNodeId(String value) {
            this.nodeId = value;
        }

        /**
         * Gets the value of the sourceId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSourceId() {
            return sourceId;
        }

        /**
         * Sets the value of the sourceId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSourceId(String value) {
            this.sourceId = value;
        }

        /**
         * Gets the value of the cacheType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCacheType() {
            return cacheType;
        }

        /**
         * Sets the value of the cacheType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCacheType(String value) {
            this.cacheType = value;
        }

		@Override
		public CharSequence toXML() {
			XmlStringBuilder xml = new XmlStringBuilder(this);
			xml.attribute("nodeId", nodeId);
			if (sourceId != null)
				xml.attribute("sourceId", sourceId);
			if (cacheType != null)
				xml.attribute("cacheType", cacheType);
            xml.rightAngleBracket();
            xml.closeElement(this);
            return xml;
		}

		@Override
		public String getElementName() {
			return ELEMENT;
		}

    }


	@Override
	protected IQChildElementXmlStringBuilder getIQHoxtChildElementBuilder(
			IQChildElementXmlStringBuilder xml) {
		xml.attribute("momentary", "" + momentary);
		xml.rightAngleBracket();
		xml.append(nodes);
		xml.append(fields);
		return xml;
	}

}