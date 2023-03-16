#pragma warning disable CS8618
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace MoviesRec.Models;

public class Movies {
    [Key]
    public int MoviesId { get; set; }
    
    [Display(Name = "Movie Title")]
    [Required(ErrorMessage = "Movie Title is required!")]
    public string Title {get; set;}

    [Display(Name = "Movie Review")]
    [Required(ErrorMessage = "Movie Review is required!")]
    public string Review {get; set;}

    [Display(Name = "Movie Image Link")]
    [Required(ErrorMessage = "Image Link Required!")]
    public string? Img {get; set;}

    [Display(Name = "Would you Recommend?")]
    public bool Recommend {get; set;}
    public int UsersId {get; set;}
    
    public DateTime CreatedAt { get; set; } = DateTime.Now;
    public DateTime UpdatedAt { get; set; } = DateTime.Now;

    public Users? Author {get; set;}
    public List<UserLikes> postLikes {get; set;} = new List<UserLikes>();
}