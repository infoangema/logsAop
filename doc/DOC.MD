*** Generar nuevo servicio
- ng g s dashboard-module/dashboard
  constructor(private httpWrapper:HttpWrapperService) {
  }

  getTematica() : void {
  this.httpWrapper.get<any>('http://localhost:8080/api/tematica').subscribe( res => {
  console.log(res);
  });
  }

Comando Heroku
1. heroku apps
2heroku pg:killall --app java-dinamic-landing-page
1. heroku logs --tail --app java-dinamic-landing-page
2. 
