import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import "../../../node_modules/rxjs/add/operator/map";
import {User} from "./user.model";

@Injectable()
export class UserService {

    private dataUrl: string = "/api/user/all";

    constructor(private http: Http){};

    fetchData() {
        return this.http.get(this.dataUrl)
            .map(res => res.json());
    };
}