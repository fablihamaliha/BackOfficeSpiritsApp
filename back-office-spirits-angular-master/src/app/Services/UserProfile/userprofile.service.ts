import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { userProfile } from 'src/app/Model/userProfile';
import { Warehouse } from 'src/app/Model/warehouse';
import { AuthenticationService } from '../Authentication/authentication.service';

@Injectable({
  providedIn: 'root'
})
export class UserprofileService {

  constructor(private userprofileservice : HttpClient, private authservice: AuthenticationService) { }

  getUserProfile(username: string){
    let token = this.authservice.getJWT();
    return this.userprofileservice.get("http://localhost:9010/userProfile/"+ username, 
    {
      headers:new HttpHeaders({
        "Authorization": `Bearer ${token}`
      })
    }
    )
  }


  updateUserProfile(username: string, warehouse: Warehouse){
    let token = this.authservice.getJWT();
    return this.userprofileservice.put("http://localhost:9010/userProfile/"+ username, warehouse,
    {
      headers:new HttpHeaders({
        "Authorization": `Bearer ${token}`
      })
    }
    )
    
  }


  registerUser(loginInfo:any){

    let token = this.authservice.getJWT();
    return this.userprofileservice.post("http://localhost:8000/auth/api/register", loginInfo, 
    {
      headers:new HttpHeaders({
        "Authorization": `Bearer ${token}`
      })
    }
    )
  }



  createUserProfile(userProfile: userProfile){
    let token = this.authservice.getJWT();
    console.log("JWT:" + token);
    return this.userprofileservice.post("http://localhost:9010/userProfile/addUser", userProfile, 
    {
      headers:new HttpHeaders({
        "Authorization": `Bearer ${token}`
      })
    }
    )


  }



}
