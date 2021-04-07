import {Component, OnInit} from '@angular/core';
import {CustomerService} from '../../../services/customer.service';
import { MatDialog } from '@angular/material/dialog';
import { CustomerDeleteModalComponent } from '../customer-delete-modal/customer-delete-modal.component';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  public customers;
  name: string;
  p = 1;
  constructor(
    public customerService: CustomerService,
    public dialog: MatDialog,
  ) {
  }

  openDialog(customerId) {
    this.customerService.getCustomer(customerId).subscribe(customerInfo => {
      const dialogRef = this.dialog.open(CustomerDeleteModalComponent, {
        width: '500px',
        disableClose: true,
        data: {data1: customerInfo}
      });

      dialogRef.afterClosed().subscribe(result => {
        this.ngOnInit();
      });
    });
  }

  ngOnInit(): void {
    this.customerService.getAllCustomers().subscribe(data => {
      this.customers = data;
    });
  }
}
