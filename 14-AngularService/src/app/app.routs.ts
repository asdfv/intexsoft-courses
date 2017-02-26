import {UsersNamesComponent} from "./components/users-names/users-names.component";
import {UserSummaryComponent} from "./components/user-summary/user-summary.component";

export const APP_ROUTS = [
    {path: 'users', component: UsersNamesComponent},
    {path: 'summary', component: UserSummaryComponent}
];
