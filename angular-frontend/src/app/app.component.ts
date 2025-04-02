import { Component } from '@angular/core';
import pakageJson from '../../package.json';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Thiru fullstack development and AWS deployment Learning';
  public versions:any=pakageJson.version;

  }
