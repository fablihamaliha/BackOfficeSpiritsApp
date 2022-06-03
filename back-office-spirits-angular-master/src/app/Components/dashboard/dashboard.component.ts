import { Component, OnInit } from '@angular/core';
import { RouteService } from 'src/app/Services/Routing/route.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
username: any;
  constructor(private rouservice : RouteService)
  {
     this.username = sessionStorage.getItem("user")
  
   }

  ngOnInit(): void {
  }

}
