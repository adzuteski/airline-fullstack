import { Component, OnInit } from '@angular/core';
import { Flight } from '../flight';
import {FlightService} from '../flight.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-my-flights',
  templateUrl: './my-flights.component.html',
  styleUrls: ['./my-flights.component.css']
})
export class MyFlightsComponent implements OnInit {

   flights : any;

  constructor(private flightService: FlightService, private router: Router ){}

  ngOnInit() {
   // this.flights = this.flightService.getFlightsData();
   this.getFlightsData();
  }

 /// get the data from backend service api
 private getFlightsData() {
  this.flightService.getFlightsData().subscribe(data => {
    this.flights = data;
  });
}

reloadData() {
  this.flights = this.flightService.getFlightsData();
}
deleteFlight(id: number) {
  this.flightService.deleteFlight(id)
    .subscribe(
      data => {
        console.log(data);
        this.reloadData();
      },
      error => console.log(error));
      console.log('nasocuvanje do update');
}

updateFlight(id: number) {
  this.router.navigate(['update', id]);
  console.log('nasocuvanje do update')
}
  
   
  

}
