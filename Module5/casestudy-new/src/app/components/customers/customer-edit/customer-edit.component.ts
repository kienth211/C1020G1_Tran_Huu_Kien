import {Component, OnInit} from '@angular/core';
import {FormGroup, FormBuilder, Validators, FormControl} from '@angular/forms';
import {CustomerService} from '../../../services/customer.service';
import {Router, ActivatedRoute} from '@angular/router';
import {CustomerType} from '../../../models/CustomerType';
import {CustomerTypeService} from '../../../services/customer-type.service';

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {
  customerTypes: CustomerType[];
  public customerId;

  formEdit = new FormGroup({
    id: new FormControl(''),
    code: new FormControl('', [Validators.required, Validators.pattern('((KH-)([0-9]{4}))')]),
    customerType: new FormControl('', [Validators.required]),
    name: new FormControl('', [Validators.required]),
    birthday: new FormControl('', [Validators.required]),
    idCard: new FormControl('', [Validators.required, Validators.pattern('^([0-9]{9})$')]),
    phone: new FormControl('', [Validators.required,
      Validators.pattern('^(090|091|[\(]84[\+][\)]90|[\(]84[\+][\)]91)\\d{7}$')]),
    email: new FormControl('', [Validators.required, Validators.email]),
    address: new FormControl('', [Validators.required])
  });

  constructor(
    public formBuilder: FormBuilder,
    public customerService: CustomerService,
    public router: Router,
    public customerServiceType: CustomerTypeService,
    public activeRoute: ActivatedRoute
  ) {
  }

  ngOnInit(): void {
    this.customerServiceType.findAll().subscribe(data => {
      this.customerTypes = data;
    });

    this.activeRoute.params.subscribe(data => {
      this.customerId = data.id;
      this.customerService.getCustomer(this.customerId).subscribe(data1 => {
        this.formEdit.patchValue(data1);
        console.log(data1);
      });
    });
  }

  editCustomer() {
    this.customerService.editCustomer(this.formEdit.value, this.customerId).subscribe(data => {
      this.router.navigateByUrl('customer-list');
    });
  }
}
