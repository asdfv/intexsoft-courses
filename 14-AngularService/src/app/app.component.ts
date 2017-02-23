import {Component, OnInit} from '@angular/core';
import { UserService } from "./user.service";
import { User } from "./user";

@Component({
  selector: 'my-app',
  templateUrl: "/src/app/app.component.html",
  providers: [UserService]
})
export class AppComponent implements OnInit {

  constructor(private userService: UserService){};

  users: User[];
  ngOnInit(): void {
    this.userService.fetchData().subscribe(
        data => this.users = data
    );
  }

  selectedUser: User;
  onSelect(user: User) {
    this.selectedUser = user;
  }

}