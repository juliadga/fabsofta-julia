import { Injectable } from '@angular/core';
import { User } from '../model/user';
import { HttpClient } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class UserService {
  apiURL = "http://localhost:8080/api/v1/users";
  constructor(private http:HttpClient) { }
  getUsers(){
    return this.http.get<User[]>(this.apiURL);
  }
}
