import { Component, OnInit, OnDestroy } from '@angular/core';
import { HelloService } from './hello.service';
import { Model} from 'model/model';

interface MessageJson {
    title: string;
    message: string;
}

@Component({
    selector: 'test',
    templateUrl: 'app/hello/hello.component.html',
    styleUrls: ['css/hello.css'],
    providers: [HelloService]
})
export class HelloComponent implements OnInit, OnDestroy {

    // vars
    private jsonResponse: string;
    private messages: Array<MessageJson>;
    private _subscription;

    // constructor
    constructor(private _helloService: HelloService) {}

    // on-init
    ngOnInit() {
        // save _subscription

    }

    // on-destroy
    ngOnDestroy() {
        // unsubscri
    }
}
