import { Component } from '@angular/core';
import { User } from '../model/user';
import { UserService } from '../service/user.service'

@Component({
  selector: 'app-user',
  imports: [],
  templateUrl: './user.component.html',
  styleUrl: './user.component.css'
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
