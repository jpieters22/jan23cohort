#pragma warning disable CS8618
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace MoviesRec.Models;

public class Users {
    [Key]
    public int UsersId { get; set; }

    [Required(ErrorMessage = "First name is required!")]
    [Display(Name = "First Name")]
    [MinLength(2)]
    public string FirstName {get; set;}

    [Required(ErrorMessage = "Last name required!")]
    [Display(Name = "Last Name")]
    [MinLength(2)]
    public string LastName {get; set;}

    [Required(ErrorMessage = "Email required!")]
    [EmailAddress]
    [UniqueEmail]
    public string Email {get; set;}

    [Required(ErrorMessage = "Password is required!")]
    [MinLength(8, ErrorMessage = "Must be at least 8 characters long!")]
    [DataType(DataType.Password)]
    public string Password {get; set;}

    [NotMapped]
    [Display(Name = "Password Confirm")]
    [Compare("Password", ErrorMessage = "Doesn't match password!")]
    public string PasswordConfirm {get; set;}
    
    public DateTime CreatedAt { get; set; } = DateTime.Now;
    public DateTime UpdatedAt { get; set; } = DateTime.Now;

    public List<Movies> AuthorReview {get; set;} = new List<Movies>();
    public List<UserLikes> userLikes {get; set;} = new List<UserLikes>();
}


public class UniqueEmailAttribute : ValidationAttribute
{
    protected override ValidationResult? IsValid(object? value, ValidationContext validationContext)
    {
    	// Though we have Required as a validation, sometimes we make it here anyways
    	// In which case we must first verify the value is not null before we proceed
        if(value == null)
        {
    	    // If it was, return the required error
            return new ValidationResult("Email is required!");
        }
    
    	// This will connect us to our database since we are not in our Controller
        MyContext _context = (MyContext)validationContext.GetService(typeof(MyContext));
        // Check to see if there are any records of this email in our database
        if(_context.user.Any(e => e.Email == value.ToString()))
        {
    	    // If yes, throw an error
            return new ValidationResult("Email must be unique!");
        } else {
    	    // If no, proceed
            return ValidationResult.Success;
        }
    }
}