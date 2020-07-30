import { Injectable } from '@angular/core';
import { Flight } from './flight';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FlightService {

  private MYFLIGHTS: Flight[];
  private baseUrl: string = "http://localhost:8080/api/flights";
  constructor(private http: HttpClient) { }


//test with local data
/*
public getFlightsMockData() : Flight[]{
  return this.MYFLIGHTS;
} */
public getFlightsData() : Observable<Flight[]>{
    // baseUrl = "http://localhost:8080/api/flights";
    return this.http.get<Flight[]>(this.baseUrl);
}
getFlight(id: number): Observable<any> {
  return this.http.get(`${this.baseUrl}/${id}`);
}

createFlight(employee: Object): Observable<Object> {
  return this.http.post(`${this.baseUrl}`, employee);
}

updateFlight(id: number, value: any): Observable<Object> {
  return this.http.put(`${this.baseUrl}/${id}`, value);
}

deleteFlight(id: number): Observable<any> {
  return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
}


}