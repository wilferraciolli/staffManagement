import { PersonLinks } from './person-links';
import { PersonMeta } from './person-meta';

export class Person {

  id: string;
  userId: string;
  firstName: string;
  lastName: string;
  email: string;
  dateOfBirth?: string;
  genderId?: string;
  maritalStatusId?: string;
  numberOfDependants?: number;
  phoneNumber?: string;
  allowedSpecialShift?: boolean;
  allowedOnCall?: boolean;
  fullyTrained?: boolean;
  links: PersonLinks;
  constructor(id: string,
              userId: string,
              firstName: string,
              lastName: string,
              email: string,
              dateOfBirth: string,
              genderId: string,
              maritalStatusId: string,
              numberOfDependants: number,
              phoneNumber: string,
              allowedSpecialShift: boolean,
              allowedOnCall: boolean,
              fullyTrained: boolean,
              links: PersonLinks,
              meta: PersonMeta) {

    this.id = id;
    this.userId = userId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.dateOfBirth = dateOfBirth;
    this.genderId = genderId;
    this.maritalStatusId = maritalStatusId;
    this.numberOfDependants = numberOfDependants;
    this.phoneNumber = phoneNumber;
    this.allowedSpecialShift = allowedSpecialShift;
    this.allowedOnCall = allowedOnCall;
    this.fullyTrained = fullyTrained;
    this.links = links;
    this.meta = meta;
  }

  meta: PersonMeta;
}
