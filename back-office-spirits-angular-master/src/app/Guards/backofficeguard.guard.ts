import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthenticationService } from '../Services/Authentication/authentication.service';
import { RouteService } from '../Services/Routing/route.service';

@Injectable({
  providedIn: 'root'
})
export class BackofficeguardGuard implements CanActivate {
  constructor(private authservice: AuthenticationService,private rouservice:RouteService)
  {
   
  }
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      
      let mytoken=this.authservice. getJWT();
   
      if (mytoken==null)
      {
        this.rouservice.openLogin();
        // this.router.navigate(['/login'])

         return false;

      }
    return true;
    // if(sessionStorage.getItem('username')!=null)
    // return true;
    // this.router.navigate(['/login']);
    // return false;
  }
  
}
