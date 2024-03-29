/*
 * Copyright (c) 2007, Technische Universitaet Berlin
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * - Redistributions of source code must retain the above copyright notice,
 *   this list of conditions and the following disclaimer.
 * - Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 * - Neither the name of the Technische Universitaet Berlin nor the names
 *   of its contributors may be used to endorse or promote products derived
 *   from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED
 * TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA,
 * OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY
 * OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE
 * USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * - Revision -------------------------------------------------------------
 * $Revision: 1.1 $
 * $Date: 2008/02/15 13:58:59 $ @author: Jan Hauer
 * @author: Jan Hauer <hauer@tkn.tu-berlin.de>
 * ========================================================================
 */


/**
  * This interface signals the arrival of a subscription to
  * a publisher. The subscription is represented by a handle
  * that can be used to access the subscription content via
  * the <code>PSMessageAccess</code> interface.
  */

#include "TinyCOPS.h" 
interface SubscriptionListener 
{

  /** 
   * A new subscription has arrived; any previous subscription 
   * (signalled through this interface instance) was overwritten and 
   * is now invalid. The <code>PSMessageAccess</code> interface can 
   * be used to access the subscription content.
   * 
   * @param handle  a handle to the subscription (a given interface
   * instance always returns the same handle)
   */
  event void subscriptionReceived(subscription_handle_t handle);

  /** 
   * A registered subscription was unsubscribed.
   * 
   * @param handle a handle to the subscription (it only
   * contains the "FALSE"-attribute)
   */
  event void unsubscribed(subscription_handle_t handle);

  /** 
   * Obtain the handle to the current subscription.
   *
   * @param handle pointer to where the handle should be stored.
   * 
   * @return SUCCESS if the handle is valid, FAIL if no subscription was
   * ever received.
   */
  command error_t getRegisteredSubscription(subscription_handle_t *handle); 
}

