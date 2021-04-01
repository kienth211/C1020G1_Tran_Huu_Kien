import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-pet',
  templateUrl: './pet.component.html',
  styleUrls: ['./pet.component.css']
})
export class PetComponent implements OnInit {
  petName = 'puppie';
  petImage = 'http://yourdost-blog-images.s3-ap-southeast-1.amazonaws.com/wp-content/uploads/2016/01/03165939/Dogs.jpg';

  updateName(name) {
    this.petName = name;
    if (name === 'cat') {
      this.petImage = 'https://timesofindia.indiatimes.com/photo/67586673.cms';
    } else {
      this.petImage = 'http://yourdost-blog-images.s3-ap-southeast-1.amazonaws.com/wp-content/uploads/2016/01/03165939/Dogs.jpg';
    }
  }

  // updateImage(image) {
  // }

  constructor() {
  }

  ngOnInit(): void {
  }

}
