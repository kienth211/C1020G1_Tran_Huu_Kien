import {Component, OnInit} from '@angular/core';
import {studentRepository} from '../student-info/model/StudentRepository';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {IStudent} from '../student-info/model/IStundent';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-list-student',
  templateUrl: './list-student.component.html',
  styleUrls: ['./list-student.component.css']
})

export class ListStudentComponent implements OnInit {
  students = studentRepository;
  student: IStudent;
  studentForm = new FormGroup({
    id: new FormControl('', [Validators.required]),
    name: new FormControl('', [Validators.required, Validators.minLength(10)]),
    age: new FormControl('', [Validators.required]),
    mark: new FormControl('', [Validators.required]),
    avatarImg: new FormControl('', [Validators.required])
  });

  // get name() {
  //   return this.studentForm.get('name');
  // }

  constructor(private modalService: NgbModal) {
  }

  openWindowCustomClass(content) {
    this.modalService.open(content, {windowClass: 'dark-modal'});
  }

  openWindowCustomClass1(content) {
    this.modalService.open(content, {windowClass: 'dark-modal'});
  }

  ngOnInit(): void {
  }

  detail(student: IStudent) {
    this.student = student;
  }

  delete(student: IStudent) {
    const index = studentRepository.indexOf(student);
    studentRepository.splice(index, 1);
  }

  onSubmit() {
    studentRepository.push(this.studentForm.value);
    this.studentForm.reset();
  }
}
