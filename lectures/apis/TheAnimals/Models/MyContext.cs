#pragma warning disable CS8618
using Microsoft.EntityFrameworkCore;

namespace TheAnimals.Models;

public class MyContext : DbContext
{
    public MyContext(DbContextOptions<MyContext> options)
        : base(options)
    {
    }

    public DbSet<Animal> Animals { get; set; } = null!;
}