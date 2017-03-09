import {Component, Input} from "@angular/core";
import User from "../user.model";

@Component({
    selector: "user-id-info",
    templateUrl: "./user-id.component.html"
})
export class UserIdComponent {

    @Input()
    user: User;
}
