# C# API NOTES
https://learn.microsoft.com/en-us/aspnet/core/tutorials/first-web-api?view=aspnetcore-7.0&tabs=visual-studio-code

## Creating the API application
dotnet new webapi -o AppName

## Allowing https (unless you added no-https to build command)
dotnet dev-certs https --trust

## Add the following packages
dotnet add package Microsoft.VisualStudio.Web.CodeGeneration.Design -v 6.0.0
dotnet add package Microsoft.EntityFrameworkCore.Design -v 6.0.3
dotnet add package Microsoft.AspNetCore.Cors
dotnet add package Microsoft.EntityFrameworkCore.SqlServer -v 6.0.16
dotnet add package Pomelo.EntityFrameworkCore.MySql -v 6.0.1


## Update tools - as needed should only need to do this once as this is global
dotnet tool uninstall -g dotnet-aspnet-codegenerator
dotnet tool install -g dotnet-aspnet-codegenerator --version 6.0.13

## Auto create controller
dotnet-aspnet-codegenerator controller -name AnimalController -async -api -m Animal -dc AnimalContext -outDir Controllers


## To use mysql add the following to the program.cs
var connectionString = builder.Configuration.GetConnectionString("DefaultConnection");

builder.Services.AddDbContext<MyContext>(options =>
{
    options.UseMySql(connectionString, ServerVersion.AutoDetect(connectionString));
});

## Add to the appsettings file 
,    
  "ConnectionStrings":    
  {        
      "DefaultConnection": "Server=localhost;port=3306;userid=root;password=HoneyBee#4;database=csharp_animal_api;"    
  }
