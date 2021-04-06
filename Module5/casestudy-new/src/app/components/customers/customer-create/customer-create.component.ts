import {Component, OnInit} from '@angular/core';
import {FormGroup, FormBuilder, Validators, FormControl} from '@angular/forms';
import {CustomerService} from '../../../services/customer.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {
  formCreate = new FormGroup({
    id: new FormControl('', [Validators.required]),
    code: new FormControl('', [Validators.required]),
    customerType: new FormControl('', [Validators.required]),
    name: new FormControl('', [Validators.required]),
    birthday: new FormControl('', [Validators.required]),
    idCard: new FormControl('', [Validators.required]),
    phone: new FormControl('', [Validators.required]),
    email: new FormControl('', [Validators.required]),
    address: new FormControl('', [Validators.required])
  });
  constructor(
    public formBuilder: FormBuilder,
    public customerService: CustomerService,
    public router: Router
  ) {
  }

  ngOnInit(): void {
  }

  createCustomer() {
    this.customerService.createCustomer(this.formCreate.value).subscribe(data => {
      this.router.navigateByUrl('customer-list');
    });
  }
}
