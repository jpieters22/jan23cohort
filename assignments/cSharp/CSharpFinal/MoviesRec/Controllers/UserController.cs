using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using MoviesRec.Models;
using Microsoft.AspNetCore.Identity;

namespace MoviesRec.Controllers;

public class UserController : Controller
{
    private MyContext db;
    public UserController(MyContext context)
    {
        db = context;
    }

    [HttpGet("")]
    public IActionResult Index()
    {
        return View("Index");
    }

    [HttpPost("/register")]
    public IActionResult Register(Users newUser)
    {
        if(!ModelState.IsValid)
        {
            return View("Index");
        }

        PasswordHasher<Users> user = new PasswordHasher<Users>();
        newUser.Password = user.HashPassword(newUser, newUser.Password);

        db.user.Add(newUser);
        db.SaveChanges();

        HttpContext.Session.SetInt32("UUID", newUser.UsersId);

        return RedirectToAction("Reviews", "Reviews");
    }

    [HttpPost("/login")]
    public IActionResult Login(LoginUser logUser)
    {
        if(!ModelState.IsValid)
        {
            return View("Index");
        }

        // If initial ModelState is valid, query for a user with the provided email        
        Users? userInDb = db.user.FirstOrDefault(u => u.Email == logUser.LoginEmail);        
        // If no user exists with the provided email        
        if(userInDb == null)        
        {                        
            ModelState.AddModelError("LoginEmail", "Invalid Email/Password");            
            return View("Index");        
        }

        PasswordHasher<LoginUser> user = new PasswordHasher<LoginUser>();                    

        var result = user.VerifyHashedPassword(logUser, userInDb.Password, logUser.LoginPassword);                                         
        if(result == 0)        
        {            
            ModelState.AddModelError("LoginEmail", "Invalid Email/Password");            
            return View("Index");         
        } 

        HttpContext.Session.SetInt32("UUID", userInDb.UsersId);
        Console.WriteLine(userInDb.UsersId);

        return RedirectToAction("Reviews", "Reviews");
    }

    [HttpPost("/logout")]
    public IActionResult Logout()
    {
        HttpContext.Session.Clear();
        return RedirectToAction("Index");
    }
}