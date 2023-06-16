import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Aeroclub } from '../models/aeroclub.model';

const baseUrl = 'http://localhost:8080/api/aeroclub';

@Injectable({
  providedIn: 'root'
})
export class AeroclubService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Aeroclub[]> {
    return this.http.get<Aeroclub[]>(baseUrl);
  }

  get(id: any): Observable<Aeroclub> {
    return this.http.get<Aeroclub>(`${baseUrl}/${id}`);
  }

  create(data: any): Observable<any> {
    return this.http.post(baseUrl, data);
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

  findByOaci(oaci: any): Observable<Aeroclub[]> {
    console.log(`${baseUrl}?oaci=${oaci}`);
    return this.http.get<Aeroclub[]>(`${baseUrl}?oaci=${oaci}`);
}
}