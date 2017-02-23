import {Component, Input} from "@angular/core";
import {User} from "./user";

@Component({
    selector: "user-detail",
    templateUrl: "/src/app/user-detail.component.html"
})
export class UserDetailComponent {

    @Input()
    user: User;
}