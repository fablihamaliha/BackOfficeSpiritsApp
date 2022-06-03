import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MaterialModule } from './Materials/materials.module';
import { DashboardComponent } from './Components/dashboard/dashboard.component';
import { HeaderComponent } from './Components/header/header.component';
import { InventoryItemComponent } from './Components/inventory-item/inventory-item.component';
import { InventoryListComponent } from './Components/inventory-list/inventory-list.component';
import { ProductPipe } from './Pipes/product.pipe';
import { RouterModule, Routes } from '@angular/router';
import { RouteService } from './Services/Routing/route.service';
import { InventoryService } from './Services/Inventory/inventory.service';
import { LoginComponent } from './Components/login/login.component';
import { OrderListComponent } from './Components/order-list/order-list.component';
import { OrderDetailComponent } from './Components/order-detail/order-detail.component';
import { BackofficeguardGuard } from './Guards/backofficeguard.guard';
import { FlexLayoutModule } from '@angular/flex-layout';
import {MatFormFieldModule} from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatSidenavModule} from '@angular/material/sidenav';
import { FooterComponent } from './Components/footer/footer.component';
import { HomeComponent } from './Components/home/home.component';
import { OrderPipe } from './Pipes/order.pipe';
import { MatSelectModule } from '@angular/material/select';
import { OrderFormComponent } from './Components/order-form/order-form.component';
import { UserprofileComponent } from './Components/userprofile/userprofile.component';

import { RegisterComponent } from './Components/register/register.component';
import { MdbCarouselModule } from 'mdb-angular-ui-kit/carousel';
import { MdbAccordionModule } from 'mdb-angular-ui-kit/accordion';
import { MdbCheckboxModule } from 'mdb-angular-ui-kit/checkbox';
import { MdbCollapseModule } from 'mdb-angular-ui-kit/collapse';
import { MdbDropdownModule } from 'mdb-angular-ui-kit/dropdown';
import { MdbFormsModule } from 'mdb-angular-ui-kit/forms';
import { MdbModalModule } from 'mdb-angular-ui-kit/modal';
import { MdbPopoverModule } from 'mdb-angular-ui-kit/popover';
import { MdbRadioModule } from 'mdb-angular-ui-kit/radio';
import { MdbRangeModule } from 'mdb-angular-ui-kit/range';
import { MdbRippleModule } from 'mdb-angular-ui-kit/ripple';
import { MdbScrollspyModule } from 'mdb-angular-ui-kit/scrollspy';
import { MdbTabsModule } from 'mdb-angular-ui-kit/tabs';
import { MdbTooltipModule } from 'mdb-angular-ui-kit/tooltip';
import { MdbValidationModule } from 'mdb-angular-ui-kit/validation';










const routes: Routes = [

  {
    path:"login",
    component:LoginComponent,
  },
  {
    path:"home",
    component:HomeComponent,
  },
  {
    path:"register",
    component:RegisterComponent,
  },
  {
    path:"dashboard",
    component:DashboardComponent,
    canActivate: [BackofficeguardGuard],
    children: [
      
      {
        path: "inventory",
        component:InventoryListComponent,
        pathMatch:"full"
      },

      {
        path: "orders",
        component:OrderListComponent,
        pathMatch:"full",
        
      },
      {
        path:"orders/OrderForm",
        component:OrderFormComponent,
        pathMatch:"full"
      },

      {
        path:"orders/order-details/:id",
        component:OrderDetailComponent,
        pathMatch:"full"
      },
       //Route for development purpose only

      {
        path:"profile",
        component:UserprofileComponent,
        pathMatch:"full"
      }



    ]
  },  
  {
    path:"",
    redirectTo:"home",
    pathMatch:"full"
  }
]

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    HeaderComponent,
    InventoryItemComponent,
    InventoryListComponent,
    ProductPipe,
    LoginComponent,
    OrderListComponent,
    OrderDetailComponent,
    FooterComponent,
    HomeComponent,
    OrderPipe,
    OrderFormComponent,
    UserprofileComponent,
    RegisterComponent
   
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatButtonModule,
    FormsModule,
    ReactiveFormsModule,
    MatToolbarModule,
    MaterialModule,
    HttpClientModule,
    FlexLayoutModule,
    MatFormFieldModule,
    MatSidenavModule,
    MatInputModule,
    MatCardModule,
    MatSelectModule,
    MdbCarouselModule,
    RouterModule.forRoot(routes),
    MdbAccordionModule,
    MdbCheckboxModule,
    MdbCollapseModule,
    MdbDropdownModule,
    MdbFormsModule,
    MdbModalModule,
    MdbPopoverModule,
    MdbRadioModule,
    MdbRangeModule,
    MdbRippleModule,
    MdbScrollspyModule,
    MdbTabsModule,
    MdbTooltipModule,
  
   MdbValidationModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
