import {Component, OnInit} from "@angular/core";
import {UserService} from "../user.service";
import {User} from "../user.model";

@Component({
    template: require("./user-summary.component.html")
})
export class UserSummaryComponent implements OnInit{
    constructor(private userService: UserService) {
    };
    users: User[];
    ngOnInit(): void {
        this.userService.fetchData().subscribe(
            data => this.users = data
        );
    }
}