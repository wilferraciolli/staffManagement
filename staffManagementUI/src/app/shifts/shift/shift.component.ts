import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { BreakpointObserver, Breakpoints, BreakpointState } from '@angular/cdk/layout';
import { ActivatedRoute, Router } from '@angular/router';
import { LinksService } from '../../_services/links-service';
import { NotificationService } from '../../shared/notification.service';
import { MatDialog } from '@angular/material/dialog';
import { DialogService } from '../../shared/dialog.service';
import { LoadingService } from '../../shared/components/loading/loading.service';
import { MetadataService } from '../../_services/metadata.service';
import { Shift } from '../shift';
import { Link } from '../../shared/response/link';
import { UsersResponse } from '../../users/user-list/users-response';
import { finalize } from 'rxjs/operators';
import { ShiftServiceService } from '../user-service';
import { ShiftsResponse } from './shift-list-response';
import { User } from '../../users/user';
import { UserAdapter } from '../../users/user-adapter';
import { ShiftAdapter } from '../shift-adapter';
import { environment } from '../../../environments/environment';

@Component({
  selector: 'app-shift',
  templateUrl: './shift.component.html',
  styleUrls: ['./shift.component.scss']
})
export class ShiftComponent implements OnInit {

  shifts: Array<Shift>;

  isExtraSmall: Observable<BreakpointState> = this.breakpointObserver.observe(Breakpoints.XSmall);

  constructor(private breakpointObserver: BreakpointObserver,
              private activatedRoute: ActivatedRoute,
              private linksService: LinksService,
              private shiftService: ShiftServiceService,
              private adapter: ShiftAdapter,
              private notificationService: NotificationService,
              private dialog: MatDialog,
              private dialogService: DialogService,
              private router: Router,
              private activateRoute: ActivatedRoute,
              public loadingService: LoadingService,
              private metadataService: MetadataService) {
  }

  ngOnInit(): void {
    // console.log(this.activateRoute.snapshot.paramMap);
    //
    // this.activatedRoute.data.subscribe((data: { shiftsLink: Link }) =>
    // this.loadAll(data.shiftsLink));
    const url = environment.baseUrl + '/api/admin/shifts';
    this.loadAll(new Link(url));
  }

  private loadAll(url: Link): void {
    console.log('$', url);
    this.loadingService.loadingOn();

    this.shiftService.getAll<ShiftsResponse>(url.href)
      .pipe(finalize(() => this.loadingService.loadingOff()))
      .subscribe((response: ShiftsResponse) => {
        const collectionData = response._data;
        const collectionMeta: any = response._metadata;
        const metaLinks: any = response._metaLinks;

        // this.userTemplateLink = metaLinks.createUser;
        //
        // this.userCollectionMeta = this.resolveCollectionMeta(collectionMeta);
        // this.userCollectionLinks = this.resolveCollectionLinks(metaLinks);
        // this.userCreateAccess = this.linksService.hasLink(this.userCollectionLinks.createUser);
        // this.userCollectionRoleIds = this.metadataService.resolveMetadataIdValues(this.userCollectionMeta.roleIds.values);
        //
        this.assignShifts(collectionData.shift);
      });
  }

  private assignShifts(collectionBody: any[]): void {
    this.shifts = this.convertResponse(collectionBody);
  }

  private convertResponse(collectionBody: any[]): Array<Shift> {
    return collectionBody.map(item =>
      this.adapter.adapt(item, null));
  }
}
