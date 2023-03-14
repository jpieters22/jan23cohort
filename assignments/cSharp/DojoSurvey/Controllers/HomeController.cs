using Microsoft.AspNetCore.Mvc;
using DojoSurvey.Models;
namespace DojoSurvey.Controllers;

public class HomeController : Controller
{
    [HttpGet]
    [Route("")]
    public ViewResult Index()
    {
        return View();
    }

    [HttpPost("/process")]
    public IActionResult Process(SurveyModel survey)
    {
        if(!ModelState.IsValid)
        {
            return View("Index");
        }
        return View("Submission", survey);
    }

    [HttpPost]
    [Route("/result")]
    public ViewResult Results(SurveyModel survey)
    {
        return View("Submission", survey);
    }
}