import {NgModule} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";
import {HttpModule} from "@angular/http";
import {AppComponent} from "./app.component";
import {UserIdComponent} from "./components/user-id/user-id.component";
import {UsersNamesComponent} from "./components/users-names/users-names.component";
import {APP_ROUTS} from "./app.routs";
import {UserSummaryComponent} from "./components/user-summary/user-summary.component";
import {RouterModule} from "@angular/router";
import {UserService} from "./services/user.service";

@NgModule({
    imports: [
        BrowserModule,
        HttpModule,
        RouterModule.forRoot(APP_ROUTS)
    ],
    declarations: [
        AppComponent,
        UsersNamesComponent,
        UserIdComponent,
        UserSummaryComponent
    ],
    bootstrap: [AppComponent],
    providers: [UserService]
})
export class AppModule {

}
