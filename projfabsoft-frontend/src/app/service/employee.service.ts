import { Injectable } from '@angular/core';
import { Employee } from '../model/employee'; 
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  apiURL = "http://localhost:8080/api/1/employee";

  constructor(private http:HttpClient) { }

  getEmployee(){
    return this.http.get<Employee[]>(this.apiURL)
  }
}