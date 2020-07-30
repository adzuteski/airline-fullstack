import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MyFlightsComponent } from './my-flights/my-flights.component';
import { CreateFlightComponent } from './create-flight/create-flight.component';
import { UpdateFlightComponent } from './update-flight/update-flight.component';


const routes: Routes = [
  { path: '', redirectTo: 'flights', pathMatch: 'full' },
  { path: 'flights', component: MyFlightsComponent },
  { path: 'add', component: CreateFlightComponent },
  { path: 'update/:id', component: UpdateFlightComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
