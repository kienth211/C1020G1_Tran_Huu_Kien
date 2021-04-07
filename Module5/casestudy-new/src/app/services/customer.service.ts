import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  public API = 'http://localhost:3000/customers';

  constructor(
    public http: HttpClient
  ) {
  }
  getAllCustomers(): Observable<any> {
    return this.http.get(this.API);
  }

  createCustomer(customer): Observable<any> {
    return this.http.post(this.API, customer);
  }

  getCustomer(customerId): Observable<any> {
    return this.http.get(this.API + '/' + customerId);
  }

  deleteCustomer(customerId): Observable<any> {
    return this.http.delete(this.API + '/' + customerId);
  }

  editCustomer(customer, customerId): Observable<any> {
    return this.http.put(this.API + '/' + customerId, customer);
  }
}
