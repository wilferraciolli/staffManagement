import { UserProfileLinks } from './user.profile-links';
import {UserProfileResponse} from './user.profile.response';

export class UserProfile {

  id: string;
  personId: string;
  firstName: string;
  lastName: string;
  links: UserProfileLinks;

  constructor(data: UserProfileResponse) {
    this.id = data._data.userProfile.id;
    this.personId = data._data.userProfile.personId;
    this.firstName = data._data.userProfile.firstName;
    this.lastName = data._data.userProfile.lastName;
    this.links = data._data.userProfile.links;
  }
}
