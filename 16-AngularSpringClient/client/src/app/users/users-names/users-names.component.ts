import {Component, OnInit} from "@angular/core";
import {UserService} from "../user.service";
import {User} from "../user.model";

@Component({
    selector: "users-names",
    template: require("./users-names.component.html"),
    styles: [require("./users-names.component.css")]
})
export class UsersNamesComponent implements OnInit {

    constructor(private userService:UserService) {
    };

    users: User[];

    ngOnInit():void {
        this.userService.fetchData().subscribe(
            data => this.users = data
        );
    };

    selectedUser:User;

    onSelect(user:User) {
        this.selectedUser = user;
    };
}