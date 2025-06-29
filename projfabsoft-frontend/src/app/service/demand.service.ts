import { Injectable } from '@angular/core';
import { Demand } from '../model/demand'; 
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DemandService {
  apiURL = "http://localhost:8080/api/v1/demand";

  constructor(private http:HttpClient) { }

  getDemand(){
    return this.http.get<Demand[]>(this.apiURL)
  }

  saveDemand(demand:Demand){
    if(demand.id){
      return this.http.put(this.apiURL + '/' + demand.id, demand);
    }
    return this.http.post(this.apiURL,demand);
  }

  getDemandById(id: any) {
    return this.http.get<Demand>(this.apiURL + '/' + id);
  }

  deleteDemand(id: any){
    return this.http.delete<Demand>(this.apiURL + '/' + id);
  }
  
}