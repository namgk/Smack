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

import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.IQ;

/**
 *
 * Core of Sensor Read IQ stanzas in the form of
 * 		<<element_type> xmlns='urn:xmpp:iot:sensordata' seqnr='0' <element_type_specific_attr>>[possible_sub_elements]</element_type>
 * For example with element_type of 'req':
 * 		<req xmlns='urn:xmpp:iot:sensordata' seqnr='0' momentary='true'></req></iq>
 * 		or
 * 		<req xmlns='urn:xmpp:iot:sensordata' seqnr='1' momentary='true'><node nodeId='Device01'></node></req>
 * 
 * Extend this class for specific element type
 * 
 * @author Nam Giang - kyng at ece dot ubc dot ca
 *
 */
public abstract class AbstractSensorReadRequest extends IQ {
	
	public static final String NAMESPACE = "urn:xmpp:iot:sensordata";

	/* Request sequence number */
    private int seqnr;
    
    /* Possible sub elements */
    private List<Element> subelements = new ArrayList<Element>();

	protected AbstractSensorReadRequest(String childElementName) {
		super(childElementName, NAMESPACE);
	}

	@Override
	protected IQChildElementXmlStringBuilder getIQChildElementBuilder(
			IQChildElementXmlStringBuilder xml) {
		// building the core parts of the element
		xml.attribute("seqnr", seqnr);
		
		// let the downstream implementations do their parts
		IQChildElementXmlStringBuilder builder = getIQHoxtChildElementBuilder(xml);
		return builder;
	}
	
    /**
     * Returns start tag.
     *
     * @return start tag
     */
    protected abstract IQChildElementXmlStringBuilder getIQHoxtChildElementBuilder(IQChildElementXmlStringBuilder xml);

	public List<Element> getSubelements() {
		return subelements;
	}

	public void setSubelements(List<Element> subelements) {
		this.subelements = subelements;
	}
	
	public void addSubElement(Element e){
		this.subelements.add(e);
	}

	public int getSeqnr() {
		return seqnr;
	}

	public AbstractSensorReadRequest setSeqnr(int seqnr) {
		this.seqnr = seqnr;
		return this;
	}
}
