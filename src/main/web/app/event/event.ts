import * as moment from "moment";
import {UserAccount} from "../user/user-account";
/**
 * Created by jrwoj on 21.04.2017.
 */
export interface Event{
    id: number;
    name: string;
    description: string;
    date: Date;
    place: string,
    createAt: Date,
    author: UserAccount;
}