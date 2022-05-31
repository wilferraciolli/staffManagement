import { Injectable } from '@angular/core';
import { Adapter } from '../shared/response/adapter';
import { Shift } from './shift';

@Injectable({
  providedIn: 'root'
})
export class ShiftAdapter implements Adapter<Shift> {

  adapt(shift: Shift, meta?: any): Shift {

    console.log('adapting shift ', shift);
    console.log('adapting shift ',  meta);
    return new Shift(shift.id,
       shift.scheduleId,
       shift.title,
       shift.description,
       shift.shiftType,
       shift.supervisorOnly,
       shift.active,
       shift.startTime,
       shift.endTime);
  }

}
