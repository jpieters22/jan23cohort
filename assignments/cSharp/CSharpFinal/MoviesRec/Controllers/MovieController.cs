using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using System.Linq;
using System.Globalization;
using System.Collections.Generic;
using Microsoft.AspNetCore.Identity;
using MoviesRec.Models;
using Microsoft.AspNetCore.Mvc.Filters;

namespace MoviesRec.Controllers;

public class MovieController : Controller
{
    private MyContext db;
    public MovieController(MyContext context)
    {
        db = context;
    }

    [SessionCheck]
    [HttpGet("/reviews")]
    public IActionResult Reviews()
    {
        List<Movies> movie = db.movie.Include(Movies => Movies.Author).Include(Movies => Movies.postLikes).ToList();
        return View("Reviews", movie);
    }

    [SessionCheck]
    [HttpGet("/reviews/new")]
    public IActionResult NewReview()
    {
        return View("NewMovies");
    }

    [SessionCheck]
    [HttpPost("Create")]
    public IActionResult Create(Movies movies)
    {
        if(ModelState.IsValid)
        {
            DateTime timeNow = DateTime.Now;
            movies.UsersId = (int)HttpContext.Session.GetInt32("UUID");
            db.movie.Add(movies);
            db.SaveChanges();
            return RedirectToAction("ViewMovie", new {MoviesId = movies.MoviesId});
        }
        else
        {
            return View("NewMovies");
        }
    }

    [SessionCheck]
    [HttpGet("/reviews/{MoviesId}")]
    public IActionResult ViewMovie(int MoviesId)
    {
        Movies? ShowMovie = db.movie.Include(Movies => Movies.postLikes).FirstOrDefault(Movies => Movies.MoviesId == MoviesId);
        if(ShowMovie == null)
        {
            return RedirectToAction("Reviews"); //posts is viewing all posts 
        }
        return View("ViewMovie", ShowMovie); //viewart is viewing individual art posts
    }

    [SessionCheck]
    [HttpGet("/reviews/{MoviesId}/edit")]
    public IActionResult EditMovie(int MoviesId)
    {
        Movies? EditMovie = db.movie.FirstOrDefault(Movies => Movies.MoviesId == MoviesId);
        if (EditMovie == null || EditMovie.UsersId != HttpContext.Session.GetInt32("UUID"))
        {
            return RedirectToAction("Reviews");
        }
        return View("EditMovie", EditMovie);
    }

    [SessionCheck]
    [HttpPost("/reviews/{MoviesId}/update")]
    public IActionResult Edit(Movies movies, int MoviesId)
    {
        Movies? RetrieveMovie = db.movie.FirstOrDefault(Movies => movies.MoviesId == MoviesId);
        if(ModelState.IsValid)
        {
            DateTime timeNow = DateTime.Now;
            RetrieveMovie.Img = movies.Img;
            RetrieveMovie.Title = movies.Title;
            RetrieveMovie.Review = movies.Review;
            RetrieveMovie.UpdatedAt = timeNow;
            db.movie.Update(RetrieveMovie);
            db.SaveChanges();
            return RedirectToAction("ViewMovie", new{MoviesId = MoviesId});
        }
        else
        {
            return View("EditMovie", movies);
        }
    }

    [SessionCheck]
    [HttpGet("/reviews/{MoviesId}/Delete")]
    public IActionResult Delete(int MoviesId)
    {
        Movies? DeleteMovie = db.movie.FirstOrDefault(Movies => Movies.MoviesId == MoviesId);
        if(DeleteMovie is not null)
        {
            db.movie.Remove(DeleteMovie);
            db.SaveChanges();
        }
        return RedirectToAction("Reviews");
    }

    [SessionCheck]
    [HttpPost("/reviews/{MoviesId}/like")]
    public IActionResult Like(int MoviesId)
    {
        UserLikes? existingLike = db.userLikes.FirstOrDefault(like => like.UsersId == (int)HttpContext.Session.GetInt32("UUID") && like.MoviesId == MoviesId);
        if(existingLike != null)
        {
            db.userLikes.Remove(existingLike);
        }
        else
        {
            UserLikes newLike = new UserLikes()
            {
                MoviesId = MoviesId,
                UsersId = (int)HttpContext.Session.GetInt32("UUID")
            };
            db.userLikes.Add(newLike);
        }
        db.SaveChanges();
        return RedirectToAction ("Reviews");
    }

    public class SessionCheckAttribute : ActionFilterAttribute
{
    public override void OnActionExecuting(ActionExecutingContext context)
    {
        // Find the session, but remember it may be null so we need int?
        int? UsersId = context.HttpContext.Session.GetInt32("UUID");
        // Check to see if we got back null
        if(UsersId == null)
        {
            // Redirect to the Index page if there was nothing in session
            // "Home" here is referring to "HomeController", you can use any controller that is appropriate here
            context.Result = new RedirectToActionResult("Index", "Home", null);
        }
    }
}
}