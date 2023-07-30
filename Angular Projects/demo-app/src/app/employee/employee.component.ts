import { Component } from '@angular/core';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent {

id:number=100;
name:string ="Ravi kumar";
age:number = 21;
result:boolean = true;
msg:string="";
fun() {
  alert("event generated...");

}
changeName(){
  this.name="Raj Kumar";
}
passValue(name:any){
  //alert(name);
  this.msg = name;
}

}
