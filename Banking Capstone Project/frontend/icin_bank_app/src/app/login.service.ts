import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  // in service we need to do the di for 
  // HttpClient which help to call rest api develop in any 
  // language 
  constructor(public http:HttpClient) { } // DI for HttpClient 

  signIn(login:any){
   // return this.http.post("")
  }
}
