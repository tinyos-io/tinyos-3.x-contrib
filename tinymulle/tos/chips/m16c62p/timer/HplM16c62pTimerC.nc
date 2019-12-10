/**
 * Interfaces to all the M16c/62p timers and controls.
 *
 * @author Henrik Makitaavola
 */
configuration HplM16c62pTimerC
{
  provides
  {
    interface HplM16c62pTimer as TimerA0;
    interface HplM16c62pTimer as TimerA1;
    interface HplM16c62pTimer as TimerA2;
    interface HplM16c62pTimer as TimerA3;
    interface HplM16c62pTimer as TimerA4;

    interface HplM16c62pTimerACtrl as TimerA0Ctrl;
    interface HplM16c62pTimerACtrl as TimerA1Ctrl;
    interface HplM16c62pTimerACtrl as TimerA2Ctrl;
    interface HplM16c62pTimerACtrl as TimerA3Ctrl;
    interface HplM16c62pTimerACtrl as TimerA4Ctrl; 

    interface HplM16c62pTimer as TimerB0;
    interface HplM16c62pTimer as TimerB1;
    interface HplM16c62pTimer as TimerB2;
    interface HplM16c62pTimer as TimerB3;
    interface HplM16c62pTimer as TimerB4;
    interface HplM16c62pTimer as TimerB5;

    interface HplM16c62pTimerBCtrl as TimerB0Ctrl;
    interface HplM16c62pTimerBCtrl as TimerB1Ctrl;
    interface HplM16c62pTimerBCtrl as TimerB2Ctrl;
    interface HplM16c62pTimerBCtrl as TimerB3Ctrl;
    interface HplM16c62pTimerBCtrl as TimerB4Ctrl;
    interface HplM16c62pTimerBCtrl as TimerB5Ctrl;
  }
}
implementation 
{
  components
    HplM16c62pTimerInterruptP as IrqVector,
    new HplM16c62pTimerP((uint16_t)&TA0, (uint16_t)&TA0IC, (uint16_t)&TABSR, 0) as TimerA0_,
    new HplM16c62pTimerP((uint16_t)&TA1, (uint16_t)&TA1IC, (uint16_t)&TABSR, 1) as TimerA1_,
    new HplM16c62pTimerP((uint16_t)&TA2, (uint16_t)&TA2IC, (uint16_t)&TABSR, 2) as TimerA2_,
    new HplM16c62pTimerP((uint16_t)&TA3, (uint16_t)&TA3IC, (uint16_t)&TABSR, 3) as TimerA3_,
    new HplM16c62pTimerP((uint16_t)&TA4, (uint16_t)&TA4IC, (uint16_t)&TABSR, 4) as TimerA4_,

    new HplM16c62pTimerACtrlP(0, (uint16_t)&TA0MR, (uint16_t)&ONSF,  6) as TimerA0Ctrl_,
    new HplM16c62pTimerACtrlP(1, (uint16_t)&TA1MR, (uint16_t)&TRGSR, 0) as TimerA1Ctrl_,
    new HplM16c62pTimerACtrlP(2, (uint16_t)&TA2MR, (uint16_t)&TRGSR, 2) as TimerA2Ctrl_,
    new HplM16c62pTimerACtrlP(3, (uint16_t)&TA3MR, (uint16_t)&TRGSR, 4) as TimerA3Ctrl_,
    new HplM16c62pTimerACtrlP(4, (uint16_t)&TA4MR, (uint16_t)&TRGSR, 6) as TimerA4Ctrl_,

    new HplM16c62pTimerP((uint16_t)&TB0, (uint16_t)&TB0IC, (uint16_t)&TABSR, 5) as TimerB0_,
    new HplM16c62pTimerP((uint16_t)&TB1, (uint16_t)&TB1IC, (uint16_t)&TABSR, 6) as TimerB1_,
    new HplM16c62pTimerP((uint16_t)&TB2, (uint16_t)&TB2IC, (uint16_t)&TABSR, 7) as TimerB2_,
    new HplM16c62pTimerP((uint16_t)&TB3, (uint16_t)&TB3IC, (uint16_t)&TBSR,  5) as TimerB3_,
    new HplM16c62pTimerP((uint16_t)&TB4, (uint16_t)&TB4IC, (uint16_t)&TBSR,  6) as TimerB4_,
    new HplM16c62pTimerP((uint16_t)&TB5, (uint16_t)&TB5IC, (uint16_t)&TBSR,  7) as TimerB5_,

    new HplM16c62pTimerBCtrlP((uint16_t)&TB0MR) as TimerB0Ctrl_,
    new HplM16c62pTimerBCtrlP((uint16_t)&TB1MR) as TimerB1Ctrl_,
    new HplM16c62pTimerBCtrlP((uint16_t)&TB2MR) as TimerB2Ctrl_,
    new HplM16c62pTimerBCtrlP((uint16_t)&TB3MR) as TimerB3Ctrl_,
    new HplM16c62pTimerBCtrlP((uint16_t)&TB4MR) as TimerB4Ctrl_,
    new HplM16c62pTimerBCtrlP((uint16_t)&TB5MR) as TimerB5Ctrl_;

  TimerA0 = TimerA0_;
  TimerA1 = TimerA1_;
  TimerA2 = TimerA2_;
  TimerA3 = TimerA3_;
  TimerA4 = TimerA4_;

  TimerB0 = TimerB0_;
  TimerB1 = TimerB1_;
  TimerB2 = TimerB2_;
  TimerB3 = TimerB3_;
  TimerB4 = TimerB4_;
  TimerB5 = TimerB5_;

  TimerA0_.IrqSignal -> IrqVector.TimerA0;
  TimerA1_.IrqSignal -> IrqVector.TimerA1;
  TimerA2_.IrqSignal -> IrqVector.TimerA2;
  TimerA3_.IrqSignal -> IrqVector.TimerA3;
  TimerA4_.IrqSignal -> IrqVector.TimerA4;

  TimerB0_.IrqSignal -> IrqVector.TimerB0;
  TimerB1_.IrqSignal -> IrqVector.TimerB1;
  TimerB2_.IrqSignal -> IrqVector.TimerB2;
  TimerB3_.IrqSignal -> IrqVector.TimerB3;
  TimerB4_.IrqSignal -> IrqVector.TimerB4;
  TimerB5_.IrqSignal -> IrqVector.TimerB5;

  TimerA0Ctrl = TimerA0Ctrl_;
  TimerA1Ctrl = TimerA1Ctrl_;
  TimerA2Ctrl = TimerA2Ctrl_;
  TimerA3Ctrl = TimerA3Ctrl_;
  TimerA4Ctrl = TimerA4Ctrl_;

  TimerB0Ctrl = TimerB0Ctrl_;
  TimerB1Ctrl = TimerB1Ctrl_;
  TimerB2Ctrl = TimerB2Ctrl_;
  TimerB3Ctrl = TimerB3Ctrl_;
  TimerB4Ctrl = TimerB4Ctrl_;
  TimerB5Ctrl = TimerB5Ctrl_;
}
