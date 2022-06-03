import { Component, OnInit } from '@angular/core';
import { userProfile } from 'src/app/Model/userProfile';
import { Warehouse } from 'src/app/Model/warehouse';
import { AuthenticationService } from 'src/app/Services/Authentication/authentication.service';
import { UserprofileService } from 'src/app/Services/UserProfile/userprofile.service';

@Component({
  selector: 'app-userprofile',
  templateUrl: './userprofile.component.html',
  styleUrls: ['./userprofile.component.css']
})
export class UserprofileComponent implements OnInit {

  userProfile : userProfile = new userProfile();
  warehouseList: Warehouse[] =[];

  warehouseToAdd: Warehouse = new Warehouse();

  constructor(private userservice: UserprofileService, private authservice: AuthenticationService) { }

  ngOnInit(): void {
    let username : string = this.authservice.getUsername();

    this.userservice.getUserProfile(username).subscribe( (res:any)=>{
      console.log(res);
      this.userProfile = res[0];
      this.warehouseList=res[0].warehouses;

    })
  }


  addWarehouseToUser(){
    console.log(this.warehouseToAdd);

    if(!(this.warehouseToAdd.warehouseid == "") && !(this.warehouseToAdd.warehousename == "") && 
    !(this.warehouseToAdd.warehouseid == null) && !(this.warehouseToAdd.warehousename == null)){

      this.userservice.updateUserProfile(this.userProfile.userName,this.warehouseToAdd).subscribe( (res:any)=>{

        this.userProfile = res;
        this.warehouseList=res.warehouses;
        this.warehouseToAdd= new Warehouse();
    })

    }


   
  }




}
