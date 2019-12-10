/* $Id: M16c62pAdcConfig.nc,v 1.4 2006/12/12 18:23:03 vlahan Exp $
 * Copyright (c) 2005 Intel Corporation
 * All rights reserved.
 *
 * This file is distributed under the terms in the attached INTEL-LICENSE     
 * file. If you do not find these files, copies can be found by writing to
 * Intel Research Berkeley, 2150 Shattuck Avenue, Suite 1300, Berkeley, CA, 
 * 94704.  Attention:  Intel License Inquiry.
 */

#include "M16c62pAdc.h"

/**
 * Clients of higher level must provide this interface to
 * specify which channel to sample, and with what parameters.
 *
 * @author Fan Zang <fanzha@ltu.se>
 */
interface M16c62pAdcConfig {
  /**
   * Obtain channel.
   * @return The A/D channel to use. Must be one of the M16c62p_ADC_CHL_xxx
   *    values from M16c62pAdc.h.
   */
  async command uint8_t getChannel();

  /**
   * Obtain precision setting
   * @return The reference voltage to use. Must be one of the 
   *   M16c62p_ADC_CHL_ANxx values from M16c62pAdc.h.
   */
  async command uint8_t getPrecision();

  /**
   * Obtain prescaler value.
   * @return The prescaler value to use. Must be one of the 
   *   M16c62p_ADC_PRESCALE_xxx values from M16c62pAdc.h.
   */
  async command uint8_t getPrescaler();
  
  
}
