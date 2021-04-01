import {Component, Input, OnInit} from '@angular/core';
import {IStudent} from './model/IStundent';

@Component({
  selector: 'app-student-info',
  templateUrl: './student-info.component.html',
  styleUrls: ['./student-info.component.css']
})
export class StudentInfoComponent implements OnInit {
  @Input() student: IStudent;
  constructor() { }

  ngOnInit(): void {
  }

}
