// $Id: AbstractSource.java,v 1.13 2004/11/10 22:08:24 gtolle Exp $

/*									tab:4
 * "Copyright (c) 2000-2003 The Regents of the University  of California.  
 * All rights reserved.
 *
 * Permission to use, copy, modify, and distribute this software and its
 * documentation for any purpose, without fee, and without written agreement is
 * hereby granted, provided that the above copyright notice, the following
 * two paragraphs and the author appear in all copies of this software.
 * 
 * IN NO EVENT SHALL THE UNIVERSITY OF CALIFORNIA BE LIABLE TO ANY PARTY FOR
 * DIRECT, INDIRECT, SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES ARISING OUT
 * OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN IF THE UNIVERSITY OF
 * CALIFORNIA HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 * THE UNIVERSITY OF CALIFORNIA SPECIFICALLY DISCLAIMS ANY WARRANTIES,
 * INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY
 * AND FITNESS FOR A PARTICULAR PURPOSE.  THE SOFTWARE PROVIDED HEREUNDER IS
 * ON AN "AS IS" BASIS, AND THE UNIVERSITY OF CALIFORNIA HAS NO OBLIGATION TO
 * PROVIDE MAINTENANCE, SUPPORT, UPDATES, ENHANCEMENTS, OR MODIFICATIONS."
 *
 * Copyright (c) 2002-2003 Intel Corporation
 * All rights reserved.
 *
 * This file is distributed under the terms in the attached INTEL-LICENSE     
 * file. If you do not find these files, copies can be found by writing to
 * Intel Research Berkeley, 2150 Shattuck Avenue, Suite 1300, Berkeley, CA, 
 * 94704.  Attention:  Intel License Inquiry.
 */


package rpc.packet;

import java.io.*;

import rpc.message.Dump;
import rpc.util.Messenger;

/**
 * Provide a standard, generic implementation of PacketSource. Subclasses
 * need only implement low-level open and close operations, and packet
 * reading and writing. This class provides the automatic close-on-error
 * functionality, general error checking, and standard messages.
 */
abstract public class AbstractSource implements PacketSource
{
    protected String name;
    protected int platform = Platform.defaultPlatform;
    protected boolean opened = false;
    protected Messenger messages;

    public int lengthOffset = 4;
    public int dataOffset = 5;

    protected void message(String s) {
	if (messages != null)
	    messages.message(s);
    }

    protected AbstractSource(String name) {
	this.name = name;
    }

    public String getName() {
	return name;
    }

    public int getPlatform() {
	return platform;
    }

    synchronized public void open(Messenger messages) throws IOException {
	if (opened)
	    throw new IOException("already open");
	this.messages = messages;
	openSource();
	// At this point we actually know the plaftorm that we're running on.
	// Fixup the offsets
	
	//lengthOffset = OasisConstants.offset_length;
	//dataOffset = OasisConstants.offset_data;
   	lengthOffset = 10;
	dataOffset = 20;
	opened = true;

    }

    synchronized public void close() throws IOException {
	if (opened) {
	    opened = false;
	    closeSource();
	}
    }

    protected void failIfClosed() throws IOException {
	if (!opened)
	    throw new IOException("closed");
    }

    public byte[] readPacket() throws IOException {
    	//System.out.println("AbstractSource: readPacket");
	failIfClosed();

	try {
	    return check(readSourcePacket());
	}
	catch (IOException e) {
	    close();
	    throw e;
	}
    }

    synchronized public boolean writePacket(byte[] packet) throws IOException {
	failIfClosed();

	try {
	    return writeSourcePacket(check(packet));
	}
	catch (IOException e) {
	    close();
	    throw e;
	}
    }

    protected byte[] check(byte[] packet) throws IOException {
	// Check packet length
//	if (false) {
//	    System.err.println("Length offset " + lengthOffset +"\n"+
//			       "Packet Length " + packet.length +"\n" +
//			       "Data offset " + dataOffset+"\n"+
//			       "Estimated payload "+ ((packet[lengthOffset] & 0xff) + dataOffset) +"\n");
//	    for (int i = 0; i< packet.length; i++) {
//		System.err.print(Integer.toHexString(packet[i] & 0xff)+" ");
//	    }
//	    System.err.print("\n");
//	}
//
//	if (lengthOffset >= packet.length)
//	    throw new IOException("short packet");
//
//	int realBytes = (packet[lengthOffset] & 0xff) + dataOffset;
//
//	if (realBytes != packet.length) {
//	    System.err.println("TOS_Msg length is invalid: header_length=" + realBytes + ",real_length=" + packet.length + " ... modifying msg to fit");
//
//	    Dump.dump("Received message", packet);
//
//	    if (realBytes < packet.length) {
//	      byte[] newPacket = new byte[realBytes];
//	      System.arraycopy(packet, 0, newPacket, 0, realBytes);
//	      packet = newPacket;
//	    } else if (realBytes > packet.length) {
//	      packet[lengthOffset] = (byte) ((packet.length - dataOffset) & 0xff);
//	    }
//	}
	
	return packet;
    }

    // Implementation interfaces
    abstract protected void openSource() throws IOException;
    abstract protected void closeSource() throws IOException;
    abstract protected byte[] readSourcePacket() throws IOException;
    protected boolean writeSourcePacket(byte[] packet) throws IOException {
	// Default writer swallows packets
	return true;
    }
}
