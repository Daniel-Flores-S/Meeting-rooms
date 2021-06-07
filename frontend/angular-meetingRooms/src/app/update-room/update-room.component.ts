import { Component, OnInit } from '@angular/core';
import { RoomService } from "../room.service";
import { Room } from "../room";
import { Router } from '@angular/router';

@Component({
  selector: 'app-update-room',
  templateUrl: './update-room.component.html',
  styleUrls: ['./update-room.component.css']
})
export class UpdateRoomComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
