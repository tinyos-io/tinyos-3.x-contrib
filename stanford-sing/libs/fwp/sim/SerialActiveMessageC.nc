// $Id: SerialActiveMessageC.nc,v 1.1 2007/05/21 19:20:27 jichoi Exp $
/*
 * "Copyright (c) 2005 Stanford University. All rights reserved.
 *
 * Permission to use, copy, modify, and distribute this software and
 * its documentation for any purpose, without fee, and without written
 * agreement is hereby granted, provided that the above copyright
 * notice, the following two paragraphs and the author appear in all
 * copies of this software.
 * 
 * IN NO EVENT SHALL STANFORD UNIVERSITY BE LIABLE TO ANY PARTY FOR
 * DIRECT, INDIRECT, SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES
 * ARISING OUT OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN
 * IF STANFORD UNIVERSITY HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH
 * DAMAGE.
 * 
 * STANFORD UNIVERSITY SPECIFICALLY DISCLAIMS ANY WARRANTIES,
 * INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE.  THE SOFTWARE
 * PROVIDED HEREUNDER IS ON AN "AS IS" BASIS, AND STANFORD UNIVERSITY
 * HAS NO OBLIGATION TO PROVIDE MAINTENANCE, SUPPORT, UPDATES,
 * ENHANCEMENTS, OR MODIFICATIONS."
 */

/*
* Copyright (c) 2006 Stanford University.
* All rights reserved.
*
* Redistribution and use in source and binary forms, with or without
* modification, are permitted provided that the following conditions
* are met:
* - Redistributions of source code must retain the above copyright
*   notice, this list of conditions and the following disclaimer.
* - Redistributions in binary form must reproduce the above copyright
*   notice, this list of conditions and the following disclaimer in the
*   documentation and/or other materials provided with the
*   distribution.
* - Neither the name of the Stanford University nor the names of
*   its contributors may be used to endorse or promote products derived
*   from this software without specific prior written permission.
*
* THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
* ``AS IS'' AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
* LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
* FOR A PARTICULAR PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL STANFORD
* UNIVERSITY OR ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
* INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
* (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
* SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
* HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
* STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
* ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
* OF THE POSSIBILITY OF SUCH DAMAGE.
*/

/**
 *
 * FWP changed AMPacket. Two commands are added for compatibility.
 *
 * @author Jung Il Choi <jungilchoi@stanford.edu>
 * @date May 21 2007
 */


#include <AM.h>
#include <Serial.h>

module SerialActiveMessageC {
  provides {
    interface SplitControl;
    
    interface AMSend[am_id_t id];
    interface Receive[am_id_t id];
    interface Receive as Snoop[am_id_t id];

    interface Packet;
    interface AMPacket;
    interface PacketAcknowledgements as Acks;
  }
  uses {
    command am_addr_t amAddress();
  }
}
implementation {

  serial_header_t* getHeader(message_t* amsg) {
    return (serial_header_t*)(amsg->data - sizeof(serial_header_t));
  }

  task void startDone() { signal SplitControl.startDone(SUCCESS); }
  task void stopDone() { signal SplitControl.stopDone(SUCCESS); }

  command error_t SplitControl.start() {
    post startDone();
    return SUCCESS;
  }

  command error_t SplitControl.stop() {
    post stopDone();
    return SUCCESS;
  }

  command error_t AMSend.send[am_id_t id](am_addr_t addr,
					  message_t* amsg,
					  uint8_t len) {
    return FAIL;
  }

  command error_t AMSend.cancel[am_id_t id](message_t* msg) {
    return FAIL;
  }
  
  command uint8_t AMSend.maxPayloadLength[am_id_t id]() {
    return call Packet.maxPayloadLength();
  }

  command void* AMSend.getPayload[am_id_t id](message_t* m) {
    return call Packet.getPayload(m, NULL);
  }

  command void* Receive.getPayload[am_id_t id](message_t* m, uint8_t* len) {
    return call Packet.getPayload(m, len);
  }

  command uint8_t Receive.payloadLength[am_id_t id](message_t* m) {
    return call Packet.payloadLength(m);
  }
  
  command void* Snoop.getPayload[am_id_t id](message_t* m, uint8_t* len) {
    return call Packet.getPayload(m, len);
  }

  command uint8_t Snoop.payloadLength[am_id_t id](message_t* m) {
    return call Packet.payloadLength(m);
  }
  
  command am_addr_t AMPacket.address() {
    return call amAddress();
  }
 
  command am_addr_t AMPacket.destination(message_t* amsg) {
    serial_header_t* header = getHeader(amsg);
    return header->dest;
  }

  command void AMPacket.setDestination(message_t* amsg, am_addr_t addr) {
    serial_header_t* header = getHeader(amsg);
    header->dest = addr;
  }

  command am_addr_t AMPacket.source(message_t* amsg) {
    serial_header_t* header = getHeader(amsg);
    return header->src;
  }

  command void AMPacket.setSource(message_t* amsg, am_addr_t addr) {
    serial_header_t* header = getHeader(amsg);
    header->src = addr;
  }

  command bool AMPacket.isForMe(message_t* amsg) {
    return (call AMPacket.destination(amsg) == call AMPacket.address() ||
	    call AMPacket.destination(amsg) == AM_BROADCAST_ADDR);
  }

  command am_id_t AMPacket.type(message_t* amsg) {
    serial_header_t* header = getHeader(amsg);
    return header->type;
  }

  command void AMPacket.setType(message_t* amsg, am_id_t t) {
    serial_header_t* header = getHeader(amsg);
    header->type = t;
  }
 
  command uint8_t AMPacket.getQuiet(message_t* amsg) {
  	return 0;
  }
  command void AMPacket.setQuiet(message_t* amsg, uint8_t quiet) {
  	return;
  }

  command void Packet.clear(message_t* msg) {}
  
  command uint8_t Packet.payloadLength(message_t* msg) {
    return getHeader(msg)->length;
  }
  
  command void Packet.setPayloadLength(message_t* msg, uint8_t len) {
    getHeader(msg)->length = len;
  }
  
  command uint8_t Packet.maxPayloadLength() {
    return TOSH_DATA_LENGTH;
  }
  
  command void* Packet.getPayload(message_t* msg, uint8_t* len) {
    if (len != NULL) {
      *len = call Packet.payloadLength(msg);
    }
    return msg->data;
  }

  async command error_t Acks.requestAck(message_t* msg) {
    return FAIL;
  }

  async command error_t Acks.noAck(message_t* msg) {
    return SUCCESS;
  }

  async command bool Acks.wasAcked(message_t* msg) {
    return FALSE;
  }
 default event message_t* Receive.receive[am_id_t id](message_t* msg, void* payload, uint8_t len) {
    return msg;
  }
  
  default event message_t* Snoop.receive[am_id_t id](message_t* msg, void* payload, uint8_t len) {
    return msg;
  }

 default event void AMSend.sendDone[uint8_t id](message_t* msg, error_t err) {
   return;
 }

 default command am_addr_t amAddress() {
   return 0;
 }
 
}
