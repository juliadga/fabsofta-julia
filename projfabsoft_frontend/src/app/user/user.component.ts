import { Component } from '@angular/core';
import { User } from '../model/user';
import { UserService } from '../service/user.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-user',
  imports: [HttpClientModule, CommonModule],
  templateUrl: './user.component.html',
  styleUrl: './user.component.css',
  providers: [UserService]
})
export class UserComponent {
  public listaUsers: User[] = [];
  constructor(private userService:UserService){}

  ngOnInit(): void {
    this.userService.getUsers().subscribe(resposta => {
      this.listaUsers = resposta;
    })
  }
}
