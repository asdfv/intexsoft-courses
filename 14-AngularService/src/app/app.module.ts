import {NgModule} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";
import {HttpModule} from "@angular/http";
import {AppComponent} from "./app.component";
import {UserDetailComponent} from "./user-detail.component";

@NgModule({
    imports: [BrowserModule, HttpModule],
    declarations: [AppComponent, UserDetailComponent],
    bootstrap: [AppComponent]
})
export class AppModule {

}