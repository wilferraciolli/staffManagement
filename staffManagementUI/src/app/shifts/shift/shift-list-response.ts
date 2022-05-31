import { MetaDataRules, MetaDataWithValues } from '../../shared/response/meta-data';
import { Shift } from '../shift';

export interface ShiftsResponse {
  _data: {
    shift: Array<Shift>
  };
  _metadata: {
    id: MetaDataRules
  };
  _metaLinks: {
    self: {
      href: string
    }
  };
}
