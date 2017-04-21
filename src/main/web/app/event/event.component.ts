/**
 * Created by jrwoj on 21.04.2017.
 */
import { Component, OnInit, OnDestroy } from '@angular/core';
import { EventService } from './event.service';

interface MessageJson {
    title: string;
    message: string;
}

@Component({
    selector: 'event',
    templateUrl: 'app/event/event.component.html',
    styleUrls: ['css/hello.css'],
    providers: [EventService]
})
export class EventComponent implements OnInit, OnDestroy {

    // vars
    private jsonResponse: string;
    private messages: Array<MessageJson>;
    private _subscription;

    // constructor
    constructor(private _eventService: EventService) {}

    // on-init
    ngOnInit() {
        // save _subscription
        this._subscription = this._eventService.getTest()
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