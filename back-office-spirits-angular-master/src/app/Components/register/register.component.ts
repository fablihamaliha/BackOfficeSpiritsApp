import { Component, OnInit } from '@angular/core';
import { userProfile } from 'src/app/Model/userProfile';
import { Warehouse } from 'src/app/Model/warehouse';
import { AuthenticationService } from 'src/app/Services/Authentication/authentication.service';
import { RouteService } from 'src/app/Services/Routing/route.service';
import { UserprofileService } from 'src/app/Services/UserProfile/userprofile.service';
import { UserprofileComponent } from '../userprofile/userprofile.component';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user?: any = new userProfile();
  warehouse?: Warehouse = new Warehouse();;
  password?: string;
  errmessage="";

  constructor(private authservice : AuthenticationService, private userservice: UserprofileService, private routeservice: RouteService) { }

  ngOnInit(): void {
  }




  registerUser(){

    //set user profile warehouse list
    this.user.warehouses= [this.warehouse];
    console.log(this.user);

    let loginInfo = {
      "username": this.user.userName,
      "password": this.password
    }

    //create user
    this.userservice.registerUser(loginInfo).subscribe( (res:any)=>{

        //generate and set jwt
       this.authservice.generateJWT(loginInfo).subscribe( (res:any)=>{
        let token = res['token'];
        this.authservice.setJWT(token);
  
        this.authservice.setUsername(res['userName'])
  
        this.userservice.createUserProfile(this.user).subscribe ( (res:any)=>{
          console.log(res);
          this.routeservice.openOrders();
        },
        (err:any)=>{
          alert(err.error);
        });


        // this.rouservice.openDashboard();
       },
       (err:any)=>{
        alert(err.error);
      });

        //create user profile

    },   
    (err:any)=>{

      alert(err.error);
    });




  }

}
