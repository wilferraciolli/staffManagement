export class Shift {

  id: string;
  scheduleId: string;
  title: string;
  description: string;
  shiftType: string;
  supervisorOnly: boolean;
  active: string;
  startTime: string;
  endTime: string;

  constructor(id: string, scheduleId: string, title: string, description: string, shiftType: string, supervisorOnly: boolean,
              active: string, startTime: string, endTime: string) {
    this.id = id;
    this.scheduleId = scheduleId;
    this.title = title;
    this.description = description;
    this.shiftType = shiftType;
    this.supervisorOnly = supervisorOnly;
    this.active = active;
    this.startTime = startTime;
    this.endTime = endTime;
  }
}
