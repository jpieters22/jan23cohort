#pragma warning disable CS8618
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace MoviesRec.Models;

[NotMapped]
public class LoginUser 
{
    
    [Required(ErrorMessage ="This field is required!")]
    [EmailAddress]
    [Display(Name ="Email")]
    public string LoginEmail {get; set;}

    [Required(ErrorMessage ="This field is required!")]
    [DataType(DataType.Password)]
    [Display(Name = "Password")]
    public string LoginPassword {get; set;}
}