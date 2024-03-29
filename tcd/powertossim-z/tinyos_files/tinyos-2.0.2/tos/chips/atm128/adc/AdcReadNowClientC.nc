/* $Id: AdcReadNowClientC.nc,v 1.1 2014/11/26 19:31:33 carbajor Exp $
 * Copyright (c) 2005 Intel Corporation
 * All rights reserved.
 *
 * This file is distributed under the terms in the attached INTEL-LICENSE     
 * file. If you do not find these files, copies can be found by writing to
 * Intel Research Berkeley, 2150 Shattuck Avenue, Suite 1300, Berkeley, CA, 
 * 94704.  Attention:  Intel License Inquiry.
 */
/**
 * Provide, as per TEP101, Resource-based access to the Atmega128 ADC via a
 * ReadNow interface.  Users of this component must link it to an
 * implementation of Atm128AdcConfig which provides the ADC parameters
 * (channel, etc).
 * 
 * @author David Gay
 */

#include "Adc.h"

generic configuration AdcReadNowClientC() {
  provides {
    interface Resource;
    interface ReadNow<uint16_t>;
  }
  uses {
    interface Atm128AdcConfig;
    interface ResourceConfigure;
  }
}
implementation {
  components WireAdcP, Atm128AdcC;

  enum {
    ID = unique(UQ_ADC_READNOW),
    HAL_ID = unique(UQ_ATM128ADC_RESOURCE)
  };

  ReadNow = WireAdcP.ReadNow[ID];
  Atm128AdcConfig = WireAdcP.Atm128AdcConfig[ID];
  Resource = Atm128AdcC.Resource[HAL_ID];
  ResourceConfigure = Atm128AdcC.ResourceConfigure[HAL_ID];
}
