import {Component, Input} from "@angular/core";
import {User} from "../../user";

@Component({
    selector: "user-id-info",
    template: require("./user-id.component.html")
})
export class UserIdComponent {

    @Input()
    user: User;
}
