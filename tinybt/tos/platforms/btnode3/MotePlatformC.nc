/* $Id: MotePlatformC.nc,v 1.1 2011/12/09 19:51:18 sengg Exp $
 * Copyright (c) 2006 ETH Zurich.
 * Copyright (c) 2005 Intel Corporation
 * All rights reserved.
 *
 * This file is distributed under the terms in the attached INTEL-LICENSE     
 * file. If you do not find these files, copies can be found by writing to
 * Intel Research Berkeley, 2150 Shattuck Avenue, Suite 1300, Berkeley, CA, 
 * 94704.  Attention:  Intel License Inquiry.
 */
/**
 * The porttion of a mica-family initialisation that is btnode3-specific.
 * 
 * @author David Gay
 * @author Jan Beutel
 */
configuration MotePlatformC
{
  provides {  
  interface Init as PlatformInit;
  }
  uses interface Init as SubInit;
}
implementation {
  components MotePlatformP, HplCC1000InitP;

  PlatformInit = MotePlatformP;
  PlatformInit = HplCC1000InitP;
  //MotePlatformP.SerialIdPin -> IO.PortA4; //TODO: btnode3 does not support this
  SubInit = MotePlatformP.SubInit;
  
}
