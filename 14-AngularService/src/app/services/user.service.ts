import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import 'rxjs/add/operator/map';

@Injectable()
export class UserService {

    // private dataUrl: string = "http://localhost:8080/userapp/api/user/all";
    private dataUrl: string = "src/app/userdata.json";

    constructor(private http: Http){};

    fetchData() {
        return this.http.get(this.dataUrl)
            .map(res => res.json());
    }
}