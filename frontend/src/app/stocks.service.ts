import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class StocksService {
  url = "http://localhost:8080/getAll"
  constructor(private http: HttpClient) { }

  list(){
    return this.http.get<any[]>(`${this.url}`);
  }
}
