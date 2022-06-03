import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  constructor(private rouservice : Router) { }
  ngOnInit(): void {
  
    
  }
  
  loggedin(){
    return sessionStorage.getItem('token');
  }
  Logout(){
    sessionStorage.removeItem("username");
    sessionStorage.removeItem("token");
    this.rouservice.navigate(['/login'])
    


  }
  
 
}
