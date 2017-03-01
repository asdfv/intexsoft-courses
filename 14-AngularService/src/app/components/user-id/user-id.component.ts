import {Component, Input} from "@angular/core";
import {User} from "../../user";

@Component({
    selector: "user-id-info",
    templateUrl: "/src/app/components/user-id/user-id.component.html"
})
export class UserIdComponent {

    @Input()
    user: User;
}
