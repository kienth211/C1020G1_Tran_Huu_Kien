import {Component, Inject, OnInit} from '@angular/core';
import {CustomerService} from '../../../services/customer.service';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';

@Component({
  selector: 'app-customer-delete-modal',
  templateUrl: './customer-delete-modal.component.html',
  styleUrls: ['./customer-delete-modal.component.css']
})
export class CustomerDeleteModalComponent implements OnInit {
  public customerId;

  constructor(public dialogRef: MatDialogRef<CustomerDeleteModalComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any,
              public  customerService: CustomerService) {
  }

  ngOnInit(): void {
    this.customerId = this.data.data1.id;
  }

  deleteCustomer() {
    this.customerService.deleteCustomer(this.customerId).subscribe(data => {
      this.dialogRef.close();
    });
  }
}
