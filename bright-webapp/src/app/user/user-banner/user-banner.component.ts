import { Component, OnInit, Output, Input } from '@angular/core';
import { User } from 'src/app/core/model/user';

@Component({
  selector: 'app-user-banner',
  templateUrl: './user-banner.component.html',
  styleUrls: ['./user-banner.component.scss']
})
export class UserBannerComponent implements OnInit {

  headerImgSrc: string;
  profileImgSrc: string;

  @Input() user: User;

  constructor( ) {
  }

  ngOnInit(): void {
    if (this.user.avatarUrl === null) {
      this.profileImgSrc = 'assets/user/ph_profile_img.webp';
    }
    this.headerImgSrc = 'assets/user/ph_profile_header.webp';
  }

}
