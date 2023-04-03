import { Injectable } from '@angular/core';
import { HttpClient ,HttpHeaders ,HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';
import { Token } from '@angular/compiler';

@Injectable({
  providedIn: 'root'
})
export class PublicationsService {

  baseUrl : string = 'http://localhost:8080';
  isActive: boolean = false;
  isLogeed: boolean = false;


  readonly httpOptions = {
    headers: new HttpHeaders().set("Authorization", `Bearer ${localStorage.getItem('token')}`)
  };

  readonly headers = new HttpHeaders({
    'Content-Type': 'application/json',
    'Authorization': `Bearer ${localStorage.getItem('token')}`
  });

  readonly requestOptions = { headers: this.headers };


  constructor(private http:HttpClient) {
    // this.isLogeed = localStorage.getItem('token') == null || undefined ? false:true;
    // console.log(localStorage.getItem('token'))
    // console.log("logggg  "+ localStorage.getItem('token') === null ? false:true);
    if(localStorage.getItem('token') == null){
      this.isLogeed = false;
    }else
      this.isLogeed = true;
  }

  getPublications(){
    return this.http.get(`${this.baseUrl}/api/user/publications`)
  }

  logeed(email:String,password:string): Observable<any>{
    return this.http.post(`${this.baseUrl}/api/auth/login`,{
      email:email,
      password:password
    });
  }

  register(fname:string,lname:string,email:string,pass:string,numberPhone:string,adress:string): Observable<any>{
    return this.http.post(`${this.baseUrl}/api/auth/register`,{
      first_name:fname,
      last_name:lname,
      email:email,
      password:pass,
      numberPhone:numberPhone,
      adresse:adress
    });
  }

  createdAnimal(namee:string,birthdayy:string,animalKindd:string,descriptionn:string,picturee:string): Observable<any>{
    return this.http.post(`${this.baseUrl}/api/user/create_animal`,{
      name:namee,
      birthday:birthdayy,
      animalKind:animalKindd,
      description:descriptionn,
      picture:picturee
    },this.requestOptions);
  }

  getMyAnimal(): Observable<any>{
    return this.http.get(`${this.baseUrl}/api/user/animals`,this.requestOptions)
  }

  createPublication(cityy:string,nbJj:string,pricee:string,idAnimall:string): Observable<any>{
    return this.http.post(`${this.baseUrl}/api/user/create_publication`,{
      city:cityy,
      nbJ:nbJj,
      price:pricee,
      idAnimal:idAnimall
    },this.httpOptions);
  }

  createComment(messagee:string,idPubb:number):Observable<any>{
    return this.http.post(`${this.baseUrl}/api/user/create_comment`,{
      message:messagee,
      idPub:idPubb
    },this.httpOptions)
  }

  applyPost(id:string):Observable<any>{
    return this.http.post(`${this.baseUrl}/api/user/apply`,{
      publicationEntity:{
        id:id
      }
    },this.httpOptions)
  }




}
