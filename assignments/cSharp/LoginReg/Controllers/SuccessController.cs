using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using LoginReg.Models;
using Microsoft.AspNetCore.Identity;

namespace LoginReg.Controllers;

public class SuccessController : Controller
{
    [HttpGet("Success")]
    public IActionResult Success()
    {
        return View("Success");
    }
}