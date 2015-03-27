package org.jivesoftware.smackx.sensorread.packet;

import java.io.StringWriter;
import java.util.Locale;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.util.TypedCloneable;
import org.jivesoftware.smack.util.XmlStringBuilder;

public class SensorReadMessage  extends Stanza implements TypedCloneable<SensorReadMessage> {

	public static final String ELEMENT = "message";
	
	private Type type;
	private AbstractSensorReadResponse content;
	
	public SensorReadMessage(){}
	
	public SensorReadMessage(SensorReadMessage other) {
        super(other);
        this.type = other.type;
    }
	@Override
	public CharSequence toXML() {
		// TODO build message object here
		XmlStringBuilder xml = new XmlStringBuilder();
        xml.halfOpenElement(ELEMENT);
        xml.attribute("from", this.getFrom());
        xml.attribute("to", this.getTo());
        xml.rightAngleBracket();
        
		String theXML = null;
		try {
			JAXBContext context = JAXBContext.newInstance("org.jivesoftware.smackx.sensorread.packet.generatedmodels");
			StringWriter writer = new StringWriter();
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);

			m.marshal(content, writer);

			// output string to console
			theXML = writer.toString();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		xml.append(theXML);
		xml.closeElement(ELEMENT);
		return xml;
	}

	@Override
	public SensorReadMessage clone() {
		return new SensorReadMessage(this);
	}
	
	

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public AbstractSensorReadResponse getSensorReadResponse() {
		return content;
	}

	public void setSensorReadResponse(AbstractSensorReadResponse content) {
		this.content = content;
	}



	/**
     * Represents the type of a message.
     */
    public enum Type {

        /**
         * (Default) a normal text message used in email like interface.
         */
        normal,

        /**
         * Typically short text message used in line-by-line chat interfaces.
         */
        chat,

        /**
         * Chat message sent to a groupchat server for group chats.
         */
        groupchat,

        /**
         * Text message to be displayed in scrolling marquee displays.
         */
        headline,

        /**
         * indicates a messaging error.
         */
        error;

        /**
         * Converts a String into the corresponding types. Valid String values that can be converted
         * to types are: "normal", "chat", "groupchat", "headline" and "error".
         * 
         * @param string the String value to covert.
         * @return the corresponding Type.
         * @throws IllegalArgumentException when not able to parse the string parameter
         * @throws NullPointerException if the string is null
         */
        public static Type fromString(String string) {
            return Type.valueOf(string.toLowerCase(Locale.US));
        }

    }
}
