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

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.jivesoftware.smack.SmackException.NotConnectedException;
import org.jivesoftware.smack.packet.IQ.Type;
import org.jivesoftware.smackx.sensorread.packet.AbstractSensorReadRequest;
import org.jivesoftware.smackx.sensorread.packet.SensorReadAccepted;
import org.jivesoftware.smackx.sensorread.packet.SensorReadMessage;
import org.jivesoftware.smackx.sensorread.packet.SensorReadRequest;
import org.jxmpp.jid.FullJid;
import org.jxmpp.jid.Jid;

/**
 * Maintains Sensor Read sessions. 
 * 
 * @author Nam Giang - kyng at ece dot ubc dot ca
 *
 */
public class SensorRead {

	private SensorManager sensorManager;
	private final Set<SensorReadReqHandler> reqHandlers = new CopyOnWriteArraySet<SensorReadReqHandler>();
	// either a req request originator or a destination of a newly created req
	private Jid remoteParty;
	// used when initiating a request
	private int seqnr = 0;
	// the original received request
	private SensorReadRequest initialReq;

	// should only be called by the SensorManager to create a SensorRead when received a new read request
	protected SensorRead(SensorManager sensorMgr, SensorReadRequest request) {
		this.sensorManager = sensorMgr;
		this.initialReq = request;
		this.remoteParty = request.getFrom();
	}

	// created by client app to initiate a read request to a remote device
	public SensorRead(SensorManager sensorMgr, Jid to) {
		this.sensorManager = sensorMgr;
		this.remoteParty = to;
	}

	public void sendResponse(SensorReadMessage response, SensorReadRequest req) throws NotConnectedException, InterruptedException {
		response.setTo(remoteParty);
		response.getSensorReadResponse().seq(req.getSeqnr());
		sensorManager.sendResponse(response);
	}
	
	public void sendRequest(SensorReadCallback callback) throws NotConnectedException,
			InterruptedException {
		sendRequest(null, null, callback);
	}

	public void sendRequest(String subNode, String field, SensorReadCallback callback) throws NotConnectedException, InterruptedException {
		SensorReadRequest srm = new SensorReadRequest();
		srm.setTo(remoteParty);
		srm.setMomentary(true);
		srm.setSeqnr(seqnr++);
		if (subNode != null) {
			SensorReadRequest.Node n = new SensorReadRequest.Node(subNode);
			srm.addNode(n);
		}
		if (field != null) {
			SensorReadRequest.Field f = new SensorReadRequest.Field(field);
			srm.addField(f);
		}

		sensorManager.sendRequest(srm, callback);
	}
	
	public void accept(AbstractSensorReadRequest request) throws NotConnectedException, InterruptedException{
		SensorReadAccepted sra = new SensorReadAccepted();
		sra.setQueued(false);
		sra.setSeqnr(request.getSeqnr());
		sra.setType(Type.result);
		sensorManager.accept(request, sra);
	}

	public void addSensorReadHandler(SensorReadReqHandler sensorReadHandler) {
		reqHandlers.add(sensorReadHandler);
		
	}

	public void process(SensorReadRequest request) {
		for (SensorReadReqHandler hl : reqHandlers){
			hl.handleReadRequest(this, request);
		}
	}

	public Jid getRemoteParty() {
		return remoteParty;
	}

	public void setRemoteParty(FullJid remoteParty) {
		this.remoteParty = remoteParty;
	}

	public SensorReadRequest getRequest() {
		return initialReq;
	}
	
	public void accept() throws NotConnectedException, InterruptedException {
		if (this.initialReq != null)
			this.accept(this.initialReq);
	}

	public void response(SensorReadMessage response) throws NotConnectedException, InterruptedException {
		if (this.initialReq != null)
			this.sendResponse(response, initialReq);
	}

}
