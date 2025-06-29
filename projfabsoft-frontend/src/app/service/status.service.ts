import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Status } from '../model/status';

@Injectable({
  providedIn: 'root'
})
export class StatusService {
  apiURL = "http://localhost:8080/api/v1/status";

  constructor(private http:HttpClient) { }

  getStatus() {
    return this.http.get<Status[]>(this.apiURL);
  }
}
