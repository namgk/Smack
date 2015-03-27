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
package org.jivesoftware.smackx.sensorread;

import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException.NotConnectedException;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.filter.StanzaTypeFilter;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smackx.sensorread.packet.AbstractSensorReadRequest;
import org.jivesoftware.smackx.sensorread.packet.SensorReadAccepted;
import org.jivesoftware.smackx.sensorread.packet.SensorReadMessage;
import org.jivesoftware.smackx.sensorread.packet.SensorReadRequest;
import org.jxmpp.jid.FullJid;
import org.jxmpp.jid.impl.JidCreate;
import org.jxmpp.stringprep.XmppStringprepException;

/**
 * The sensor read manager class handles the sensor read requests as described
 * in XEP 323. Every new received read request will have the manager to create a
 * new instance of SensorRead that corresponds to the remote party.
 * 
 * Sensor Read responses are already handled by registered StanzaListener
 * callbacks
 * 
 * @author Nam Giang - kyng at ece dot ubc dot ca
 * 
 */
public class SensorManager extends Manager {

	private static final Map<XMPPConnection, SensorManager> INSTANCES = new WeakHashMap<XMPPConnection, SensorManager>();

	// mapping between remote party and a SensorRead session.
	private static final Map<String, SensorRead> READ_SESSIONS = new WeakHashMap<String, SensorRead>();

	private Set<SensorManagerListener> sensorManagerListeners = new CopyOnWriteArraySet<SensorManagerListener>();

	int testSeqnr = 0; // test purpose, for mocking the requests

	public static synchronized SensorManager getInstanceFor (
			XMPPConnection connection) {
		SensorManager sensorReadManager = INSTANCES.get(connection);
		if (sensorReadManager == null) {
			sensorReadManager = new SensorManager(connection);
			INSTANCES.put(connection, sensorReadManager);
		}
		return sensorReadManager;
	}

	private StanzaFilter packetFilter = new StanzaTypeFilter(Stanza.class);// FIXME: change to SensorReadRequest.class in prod.

	private SensorManager(XMPPConnection connection) {
		super(connection);
		// Add a listener for all SensorRead packets
		connection.addAsyncStanzaListener(new StanzaListener() {
			public void processPacket(Stanza packet) {
				SensorRead sr;
				if (packet instanceof SensorReadRequest) {
					// process incoming req
					SensorReadRequest request = (SensorReadRequest) packet;
					// create a new SensorRead thread?
					// retrieve seqnr from the session store
					try {
						sr = READ_SESSIONS.get(request.getFrom().toString());
						sr.process(request);
					} catch (NullPointerException e) {
						// doesn't exist yet
						sr = createSensorRead(request);
						READ_SESSIONS.put(request.getFrom().toString(), sr);
						// notify listeners about the creation
						for (SensorManagerListener l : sensorManagerListeners) {
							l.onSensorManagerEvent(sr);
						}
					}

				} else if (packet instanceof SensorReadMessage) {
					// process response message
					// SensorReadMessage response = (SensorReadMessage) packet;
					// TODO: process response: already handled by registered
					// StanzaListener callbacks?
				} else {
					// Mock test:
					System.out.println("receive a packet");
					SensorReadRequest mockRequest = new SensorReadRequest();
					try {
						mockRequest.setTo(JidCreate
								.from("nhongk@is-a-furry.org"));
						mockRequest.setFrom(JidCreate
								.from("nhong@is-a-furry.org"));
					} catch (XmppStringprepException e1) {
						e1.printStackTrace();
					}
					mockRequest.setMomentary(true);
					mockRequest.setSeqnr(testSeqnr++);
					SensorReadRequest.Node n = new SensorReadRequest.Node(
							"Device01");
					mockRequest.addNode(n);
					SensorReadRequest.Field f = new SensorReadRequest.Field(
							"field");
					mockRequest.addField(f);

					System.out.println("mocking request: " + mockRequest);
					// process incoming req
					// create a new SensorRead thread?
					// retrieve seqnr from the session store
					try {
						sr = READ_SESSIONS
								.get(mockRequest.getFrom().toString());
						sr.process(mockRequest);
					} catch (NullPointerException e) {
						// doesn't exist yet
						sr = createSensorRead(mockRequest);
						READ_SESSIONS.put(mockRequest.getFrom().toString(), sr);
						// notify listeners about the creation
						for (SensorManagerListener l : sensorManagerListeners) {
							l.onSensorManagerEvent(sr);
						}
					}
				}
			}
		}, packetFilter);
		INSTANCES.put(connection, this);
	}

	protected SensorRead createSensorRead(SensorReadRequest request) {
		SensorRead sr = new SensorRead(this, request);
		READ_SESSIONS.put(request.getFrom().toString(), sr);
		return sr;
	}

	public SensorRead createSensorRead(String to)
			throws XmppStringprepException {
		FullJid jid = JidCreate.fullFrom(to);
		SensorRead sr = new SensorRead(this, jid);
		return sr;
	}

	public void sendRequest(SensorReadRequest request,
			SensorReadCallback callback) throws NotConnectedException,
			InterruptedException {
		request.setFrom(connection().getUser());
		System.out.println("sending request: " + request.toString());
		// connection().sendIqWithResponseCallback(srm, callback);
	}

	public void sendResponse(SensorReadMessage response)
			throws NotConnectedException, InterruptedException {
		response.setFrom(connection().getUser());
		System.out.println("sending response: " + response.toString());
		// connection().sendStanza(response);
	}

	public void accept(AbstractSensorReadRequest request, SensorReadAccepted sra) throws NotConnectedException, InterruptedException {
		// TODO: send accept iq
		System.out.println("sending accept: " + sra.toString());
		connection().sendStanza(sra);
	}

	public void addSensorManagerListener(
			SensorManagerListener sensorManagerListener) {
		sensorManagerListeners.add(sensorManagerListener);
	}

}
