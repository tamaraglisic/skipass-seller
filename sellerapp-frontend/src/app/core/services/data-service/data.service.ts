import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Policy } from '../../model/Policy';

@Injectable()
export class DataService {

private subject!: Policy[];  

    updateRouteData(data: Policy[]):void {
        this.subject = data;
    }

    routeData(): Policy[] {
        return this.subject;
    }
}