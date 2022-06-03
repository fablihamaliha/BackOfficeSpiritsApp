import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private httpClient: HttpClient) { }

    /**
   * Posts to the auth database to get JWT
   * @param loginInfo the username and password in json format
   * @returns jwt
   */
  generateJWT(loginInfo: any){


    /**
     * login Info example
     * loginInfo =  {
     *    username: "paul.p"
     *    password: "password"
     * }
     */

    
     
    return this.httpClient.post("http://localhost:8000/auth/api/login", loginInfo);
  }

  /**
   * sets the jwt token
   * @param token the jwt
   */
   setJWT(token:any){
    sessionStorage.setItem('token',token);
  }


  /**
   * 
   * @returns the jwt in the session storage
   */
   getJWT(){
    return sessionStorage.getItem('token');

  }
// getUsername(){
//   let user = sessionStorage.getItem('username')
//   console.log(!(user == null))
//   return !(user==null)
// }

  setUsername(username:string){
    sessionStorage.setItem('username',username);
  }


  getUsername(){
    return sessionStorage.getItem('username');
  }
  


}
