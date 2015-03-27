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

import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.SmackException.NotConnectedException;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smackx.sensorread.packet.SensorReadMessage;

/**
 * @author Nam Giang - kyng at ece dot ubc dot ca
 *
 */
public abstract class SensorReadCallback implements StanzaListener{
	@Override
	public void processPacket(Stanza packet) throws NotConnectedException,
			InterruptedException {
		SensorReadMessage response = (SensorReadMessage) packet;
		sensorReadHandler(response);
	}
	
	public abstract void sensorReadHandler(SensorReadMessage response);
}
