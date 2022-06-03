import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/Services/Authentication/authentication.service';
import { RouteService } from 'src/app/Services/Routing/route.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  errmessage : string="";
  token:string="";

  username : FormControl;
  password: FormControl;
  constructor(private rouservice : RouteService,private authserve : AuthenticationService, private router:Router) {
    
    this.username=new FormControl('',Validators.required);
    this.password=new FormControl('',Validators.required);
    
   }

  ngOnInit(): void {
  }
  verifylogin()
{
//console.log("yes");
let loginInfo = {
        
        "username" : this.username.value,
        "password": this.password.value
        }
  
  this.authserve.generateJWT(loginInfo).subscribe(
    (result:any)=>
    {
      this.token = result['token'];
      this.authserve.setJWT(this.token);

      this.authserve.setUsername(result['userName'])

      this.rouservice.openOrders();
     
    },
    (err:any)=>{
      this.errmessage=err.error;
      console.log(err.error);
      alert(this.errmessage);
    }
  

  );

 }
 goToRegister(){
   this.router.navigate(['register']);
 }
 
// onSubmit(){
//   this.router.navigateByUrl('/register')
// }


}
