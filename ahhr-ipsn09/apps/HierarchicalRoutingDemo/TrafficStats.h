/*
 * IMPORTANT: READ BEFORE DOWNLOADING, COPYING, INSTALLING OR USING.  By
 * downloading, copying, installing or using the software you agree to
 * this license.  If you do not agree to this license, do not download,
 * install, copy or use the software.
 *
 * Copyright (c) 2006-2008 Vrije Universiteit Amsterdam and
 * Development Laboratories (DevLab), Eindhoven, the Netherlands.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * - Redistributions of source code must retain the above copyright
 *   notice, this list of conditions, the author, and the following
 *   disclaimer.
 * - Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions, the author, and the following disclaimer
 *   in the documentation and/or other materials provided with the
 *   distribution.
 * - Neither the name of the Vrije Universiteit Amsterdam, nor the name of
 *   DevLab, nor the names of their contributors may be used to endorse or
 *   promote products derived from this software without specific prior
 *   written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * ``AS IS'' AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
 * FOR A PARTICULAR PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL VRIJE
 * UNIVERSITEIT AMSTERDAM, DEVLAB, OR THEIR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * Authors: Konrad Iwanicki
 * CVS id: $Id: TrafficStats.h,v 1.1 2009/11/29 14:36:58 iwanicki Exp $
 */
#ifndef __TRAFFIC_STATS__H__
#define __TRAFFIC_STATS__H__

#include <message.h>
#include <AM.h>



/*
 * This file contains data types used for traffic statistics.
 *
 * @author Konrad Iwanicki &lt;iwanicki@few.vu.nl&gt;
 */



// *************************** Local structures ***************************
/**
 * Statistics for outgoing traffic.
 */
typedef struct {
    uint32_t      schedMessages;  // the number of messages scheduled
                                  // for transmission
    uint32_t      schedBytes;     // the number of bytes scheduled for
                                  // transmission
    uint32_t      txedMessages;   // the number of transmitted messages
    uint32_t      txedBytes;      // the number of transmitted bytes
} traffic_stats_outgoing_stats_t;



/**
 * Statistics for incoming traffic.
 */
typedef struct {
    uint32_t      rxedMessages;   // the number of received messages
    uint32_t      rxedBytes;      // the number of received bytes
} traffic_stats_incoming_stats_t;





// ************************** Message structures **************************


#endif //__TRAFFIC_STATS__H__
