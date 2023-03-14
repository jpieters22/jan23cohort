using Microsoft.AspNetCore.Mvc;
namespace Portfolio2.Controllers;
    public class HomeController : Controller
    {
        [HttpGet]
        [Route("")]
        public ViewResult Index()
        {
            return View("Index");
        }

        [HttpGet("/projects")]
        public ViewResult Projects()
        {
            return View("Projects");
        }

        [HttpGet("/contact")]
        public ViewResult Contact()
        {
            return View("Contact");
        }
    }