/**
 * New typescript file
 */
import { Injectable, Inject } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class UserService {

    constructor(private _http: Http) {}

    getTest() {
        return this._http.get('http://localhost:8080/api/user/all')
            .map((res:Response) => res.json());
    }
}
 