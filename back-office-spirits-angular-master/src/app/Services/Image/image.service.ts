import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ImageService {
    baseUrlAPI = "https://file.io";

  constructor(private httpClient: HttpClient ) { }


  public uploadImage(file:any): any {

    const formData = new FormData(); 
        
    // Store form name as "file" with file data
    formData.append("file", file, file.name);

    return this.httpClient.post(this.baseUrlAPI, formData);
  }


}
