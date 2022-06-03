import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ReactiveFormsModule } from '@angular/forms';
import { AuthenticationService } from 'src/app/Services/Authentication/authentication.service';
import { RouteService } from 'src/app/Services/Routing/route.service';
import { Router } from '@angular/router';

import { LoginComponent } from './login.component';
import { RouterTestingModule } from '@angular/router/testing';
import { DebugElement } from '@angular/core';
import { MatFormFieldControl, MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

fdescribe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;
  let router: Router;
  let authserve: AuthenticationService;
  let rouservice: RouteService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoginComponent ],
      imports : [HttpClientModule,RouterTestingModule,MatFormFieldModule, MatInputModule, BrowserAnimationsModule],
       providers: [ AuthenticationService, RouteService]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  // it('should login', () =>{
  //   let loginInfo ={
  //     username: 'admin',
  //     password: 'admin',
  //   };
  //   authserve.generateJWT(loginInfo).subscribe(
  //     (result: any) =>{
  //       authserve.setJWT(result['token']);
  //       authserve.setUsername(result['userName']);
  //       rouservice.openOrders();
  //     }
  //   )

  // })
  // it('should navigate to register', () =>{
  //   component.goToRegister();
  //   expect(router.navigate).toHaveBeenCalledWith(['register']);
  // })

  // it('should check if the user is logged in', () =>{


  //   sessionStorage.setItem('jwt', 'token');
  //   component.verifylogin();
  //   expect(component.authserve.getJWT).toHaveBeenCalled();
  // })
  // it('should login the user', () =>{
  //   component.verifylogin();
  //   expect(component.authserve.generateJWT).toHaveBeenCalledWith();
  // })

  
});
