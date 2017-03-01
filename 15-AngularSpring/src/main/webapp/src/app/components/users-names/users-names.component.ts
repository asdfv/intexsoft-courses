import {Component, OnInit} from "@angular/core";
import {UserService} from "../../services/user.service";
import {User} from "../../user";

@Component({
    selector: 'users-names',
    templateUrl: "src/app/components/users-names/users-names.component.html",
    styleUrls: ["src/app/components/users-names/users-names.component.css"]
})
export class UsersNamesComponent implements OnInit {

    constructor(private userService: UserService) {
    };

    users: User[];

    ngOnInit(): void {
        this.userService.fetchData().subscribe(
            data => this.users = data
        );
    };

    selectedUser: User;

    onSelect(user: User) {
        this.selectedUser = user;
    };
}