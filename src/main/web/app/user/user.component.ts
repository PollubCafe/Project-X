/**
 * New typescript file
 */
import { Component, OnInit, OnDestroy } from '@angular/core';
import { UserService } from './user.service';

interface MessageJson {
    title: string;
    message: string;
}

@Component({
    selector: 'user',
    templateUrl: 'app/user/user.component.html',
    styleUrls: ['css/hello.css'],
    providers: [UserService]
})
export class UserComponent implements OnInit, OnDestroy {

    // vars
    private jsonResponse: string;
    private messages: Array<MessageJson>;
    private _subscription;

    // constructor
    constructor(private _userService: UserService) {}

    // on-init
    ngOnInit() {
        // save _subscription
        this._subscription = this._userService.getTest()
            .subscribe(
                (data) => {
                    this.jsonResponse = JSON.stringify(data);
                    this.messages = data;
                },
                (err) => console.log(err),
                () => console.log('hello service test complete')
        );
    }

    // on-destroy
    ngOnDestroy() {
        // unsubscribe
        this._subscription.unsubscribe();
    }
}