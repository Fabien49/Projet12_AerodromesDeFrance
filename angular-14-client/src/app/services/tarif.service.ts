import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Aeroclub } from '../models/aeroclub.model';
import { Tarif } from '../models/tarif.model';

const baseUrl = 'http://localhost:8080/api/tarif';


@Injectable({
  providedIn: 'root'
})

export class TarifService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Tarif[]> {
    return this.http.get<Tarif[]>(baseUrl);
  }

  get(id: any): Observable<Tarif> {
    return this.http.get<Tarif>(`${baseUrl}/${id}`);
  }

  create(id: any, data: any): Observable<any> {    
    return this.http.post(`${baseUrl}/${id}`, data);
  } 

  update(id: any, data: any): Observable<any> {
    return this.http.put(`${baseUrl}/${id}`, data);
  }

  delete(id: any): Observable<any> {
    return this.http.delete(`${baseUrl}/${id}`);
  }

  deleteAll(): Observable<any> {
    return this.http.delete(baseUrl);
  }

  // findByTitle(oaci: any): Observable<Aeroclub[]> {
  //   return this.http.get<Aeroclub[]>(`${baseUrl}?title=${oaci}`);
  // }

  findById(id: any): Observable<Tarif[]> {
    console.log(`${baseUrl}?id=${id}`);
    return this.http.get<Tarif[]>(`${baseUrl}?id=${id}`);



}
}