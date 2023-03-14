using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using System.Linq;
using System.Globalization;
using System.Collections.Generic;
using CRUDelicious.Models;

namespace CRUDelicious.Controllers;

public class DishController : Controller
{
    private MyContext db;
    public DishController(MyContext context)
    {
        db = context;
    }

    [HttpGet("")]
    public IActionResult Index()
    {
        List<Dish> Dishes = db.Dishes.OrderByDescending(dish => dish.DishId).ToList();
        return View("Index", Dishes);
    }

    [HttpGet("/dishes/new")]
    public IActionResult NewRecipe()
    {
        return View("RecipeNew");
    }

    [HttpPost("Create")]
    public IActionResult Create(Dish dish)
    {
        if(ModelState.IsValid)
        {
            DateTime timeNow = DateTime.Now;
            db.Dishes.Add(dish);
            db.SaveChanges();
            return RedirectToAction("Index");
        }
        else
        {
            return View("RecipeNew");
        }
    }

    [HttpGet("/dishes/{DishId}")]
    public IActionResult ViewRecipe(int DishId)
    {
        Dish? ShowDish = db.Dishes.FirstOrDefault(dish => dish.DishId == DishId);
        if(ShowDish is null)
        {
            return RedirectToAction("Index");
        }
        return View("ViewRecipe", ShowDish);
    }

    [HttpGet("/dishes/{DishId}/edit")]
    public IActionResult EditDish(int DishId)
    {
        Dish? EditDish = db.Dishes.FirstOrDefault(dish => dish.DishId == DishId);
        return View("EditDish", EditDish);
    }

    [HttpPost("/dishes/{DishId}/update")]
    public IActionResult Edit(Dish dish, int DishId)
    {
        Dish? RetrieveDish = db.Dishes.FirstOrDefault(dish => dish.DishId == DishId);
        if(ModelState.IsValid)
        {
            DateTime timeNow = DateTime.Now;
            RetrieveDish.Name = dish.Name;
            RetrieveDish.Chef = dish.Chef;
            RetrieveDish.Calories = dish.Calories;
            RetrieveDish.Tastiness = dish.Tastiness;
            RetrieveDish.Description = dish.Description;
            RetrieveDish.UpdatedAt = timeNow;
            db.SaveChanges();
            return RedirectToAction("ViewRecipe", new{DishId = DishId});
        }
        else
        {
            return View("EditDish", dish);
        }
    }

    [HttpGet("/dishes/{DishId}/Delete")]
    public IActionResult Delete(int DishId)
    {
        Dish? DeleteDish = db.Dishes.FirstOrDefault(dish => dish.DishId == DishId);
        if(DeleteDish is not null)
        {
            db.Dishes.Remove(DeleteDish);
            db.SaveChanges();
        }
        return RedirectToAction("Index");
    }

}
