import { Component } from '@angular/core';
import pakageJson from '../../package.json';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  public versions:any=pakageJson.version;
  title = 'Demo Fullstack  & AWS Deployment Docker - '+pakageJson.version;
  
  }
