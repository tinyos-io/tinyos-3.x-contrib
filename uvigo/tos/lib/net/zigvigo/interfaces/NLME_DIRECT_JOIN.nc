/*
* Copyright (c) 2009 GTI/TC-1 Research Group.  Universidade de Vigo.
*                    Gradiant (www.gradiant.org)
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
* - Neither the name of Universidade de Vigo nor the names of its
*   contributors may be used to endorse or promote products derived
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
*
* - Revision -------------------------------------------------------------
* $Revision: 1.1 $
* $Date: 2009/11/18 12:20:38 $
* @author Daniel F. Piñeiro-Santos <danips@enigma.det.uvigo.es>
* @author Felipe Gil-Castiñeira <xil@det.uvigo.es>
* @author David Chaves-Diéguez <dchaves@gradiant.org>
* ========================================================================
*/

/**
 * NLME_DIRECT_JOIN
 * Zigbee-2007
 * Sect. 3.2.2.14, 3.2.2.15 and 3.6.1.4.3
 */
#include "Nwk.h"

interface NLME_DIRECT_JOIN {
  /**
   * This optional primitive allows the next higher layer of a ZigBee
   * coordinator or router to request to directly join another device to its
   * network.
   * @param DeviceAddress The IEEE address of the device to be directly joined.
   * @param CapabilityInformation The operating capabilities of the device
   * being directly joined.
   */
  command void request(
		       uint64_t DeviceAddress,
		       ieee154_CapabilityInformation_t CapabilityInformation
		       );

  /**
   * This primitive allows the next higher layer of a ZigBee coordinator or
   * router to be notified of the results of its request to directly join
   * another device to its network.
   * @param Status        The status of the corresponding request.
   * @param DeviceAddress The 64-bit IEEE address in the request to which this
   *                      is a confirmation.
   */
  event void confirm(
		     nwk_status_t Status,
		     uint64_t DeviceAddress
		     );
}