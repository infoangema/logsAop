*** Generar nuevo servicio
- ng g s dashboard-module/dashboard
  constructor(private httpWrapper:HttpWrapperService) {
  }

  getTematica() : void {
  this.httpWrapper.get<any>('http://localhost:8080/api/tematica').subscribe( res => {
  console.log(res);
  });
  }
