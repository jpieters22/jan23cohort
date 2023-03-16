#pragma warning disable CS8618

using System.ComponentModel.DataAnnotations;
namespace MoviesRec.Models;

public class UserLikes
{
    [Key]
    public int UserLikesId {get; set;}
    public DateTime CreatedAt {get; set;} = DateTime.Now;
    public DateTime UpdatedAt {get; set;} = DateTime.Now;

    public int UsersId {get; set;}
    public Users? User {get; set;}
    public int MoviesId {get; set;}
    public Movies? Movies {get; set;}
}