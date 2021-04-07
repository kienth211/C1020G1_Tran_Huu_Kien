import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HomeComponent} from './components/home/home.component';
import {PageNotFoundComponent} from './components/page-not-found/page-not-found.component';
import {CustomerListComponent} from './components/customers/customer-list/customer-list.component';
import {CommonModule} from '@angular/common';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { FormsModule} from '@angular/forms';
import {NgxPaginationModule} from 'ngx-pagination';
import { CustomerCreateComponent } from './components/customers/customer-create/customer-create.component';
import { ReactiveFormsModule} from '@angular/forms';
import { CustomerDeleteModalComponent } from './components/customers/customer-delete-modal/customer-delete-modal.component';
import {MatDialogModule, MatDialogRef} from '@angular/material/dialog';
import { CustomerEditComponent } from './components/customers/customer-edit/customer-edit.component';


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'customer-list', component: CustomerListComponent},
  {path: 'customer-create', component: CustomerCreateComponent},
  {path: 'customer-edit/:id', component: CustomerEditComponent},
  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes),
    CommonModule,
    Ng2SearchPipeModule,
    FormsModule,
    NgxPaginationModule,
    ReactiveFormsModule,
    MatDialogModule
  ],
  exports: [RouterModule],
  declarations: [HomeComponent,
    PageNotFoundComponent,
    CustomerListComponent,
    CustomerCreateComponent,
    CustomerDeleteModalComponent,
    CustomerEditComponent],
  providers: [{
    provide: MatDialogRef,
    useValue: {}
  }]
})
export class AppRoutingModule {
}
