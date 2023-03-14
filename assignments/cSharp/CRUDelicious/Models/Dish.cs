#pragma warning disable CS8618
using System.ComponentModel.DataAnnotations;
namespace CRUDelicious.Models;

public class Dish {
    [Key]
    public int DishId { get; set; }

    [Display(Name="Name of Dish")]
    [Required(ErrorMessage = "Dish name is required!")]
    public string Name {get; set;}

    [Display(Name="Chef's Name")]
    [Required(ErrorMessage="A chef's name is required!")]
    public string Chef {get; set;}

    [Display(Name="Tastiness")]
    [Required(ErrorMessage="Tastiness level required!")]
    public int Tastiness {get; set;}

    [Display(Name="# of Calories")]
    [Required(ErrorMessage="Must input calorie amount!")]
    [Range(1,5000, ErrorMessage="Calories must be between 1-5000 calories!")]
    public int Calories {get; set;}

    [Display(Name ="Description")]
    [Required(ErrorMessage="Description is required!")]
    public string Description {get; set;}
    public DateTime CreatedAt { get; set; } = DateTime.Now;
    public DateTime UpdatedAt { get; set; } = DateTime.Now;
}
