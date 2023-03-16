#pragma warning disable CS8618

using Microsoft.EntityFrameworkCore;
namespace MoviesRec.Models;

public class MyContext : DbContext 
{    
    public MyContext(DbContextOptions options) : base(options) { }    

    public DbSet<Movies> movie { get; set; }
    public DbSet<Users> user { get; set; }
    public DbSet<UserLikes> userLikes {get; set;}
}