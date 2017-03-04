import {UsersNamesComponent} from "./users/users-names/users-names.component";
import {UserSummaryComponent} from "./users/user-summary/user-summary.component";

export const APP_ROUTS = [
    {path: 'users', component: UsersNamesComponent},
    {path: 'summary', component: UserSummaryComponent}
];
