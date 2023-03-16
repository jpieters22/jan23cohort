﻿// <auto-generated />
using System;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Infrastructure;
using Microsoft.EntityFrameworkCore.Migrations;
using Microsoft.EntityFrameworkCore.Storage.ValueConversion;
using MoviesRec.Models;

#nullable disable

namespace MoviesRec.Migrations
{
    [DbContext(typeof(MyContext))]
    [Migration("20230316191933_ThirdMigration")]
    partial class ThirdMigration
    {
        protected override void BuildTargetModel(ModelBuilder modelBuilder)
        {
#pragma warning disable 612, 618
            modelBuilder
                .HasAnnotation("ProductVersion", "6.0.3")
                .HasAnnotation("Relational:MaxIdentifierLength", 64);

            modelBuilder.Entity("MoviesRec.Models.Movies", b =>
                {
                    b.Property<int>("MoviesId")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("int");

                    b.Property<DateTime>("CreatedAt")
                        .HasColumnType("datetime(6)");

                    b.Property<string>("Img")
                        .IsRequired()
                        .HasColumnType("longtext");

                    b.Property<bool>("Recommend")
                        .HasColumnType("tinyint(1)");

                    b.Property<string>("Review")
                        .IsRequired()
                        .HasColumnType("longtext");

                    b.Property<string>("Title")
                        .IsRequired()
                        .HasColumnType("longtext");

                    b.Property<DateTime>("UpdatedAt")
                        .HasColumnType("datetime(6)");

                    b.Property<int>("UsersId")
                        .HasColumnType("int");

                    b.HasKey("MoviesId");

                    b.HasIndex("UsersId");

                    b.ToTable("movie");
                });

            modelBuilder.Entity("MoviesRec.Models.UserLikes", b =>
                {
                    b.Property<int>("UserLikesId")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("int");

                    b.Property<DateTime>("CreatedAt")
                        .HasColumnType("datetime(6)");

                    b.Property<int>("MoviesId")
                        .HasColumnType("int");

                    b.Property<DateTime>("UpdatedAt")
                        .HasColumnType("datetime(6)");

                    b.Property<int>("UsersId")
                        .HasColumnType("int");

                    b.HasKey("UserLikesId");

                    b.HasIndex("MoviesId");

                    b.HasIndex("UsersId");

                    b.ToTable("userLikes");
                });

            modelBuilder.Entity("MoviesRec.Models.Users", b =>
                {
                    b.Property<int>("UsersId")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("int");

                    b.Property<DateTime>("CreatedAt")
                        .HasColumnType("datetime(6)");

                    b.Property<string>("Email")
                        .IsRequired()
                        .HasColumnType("longtext");

                    b.Property<string>("FirstName")
                        .IsRequired()
                        .HasColumnType("longtext");

                    b.Property<string>("LastName")
                        .IsRequired()
                        .HasColumnType("longtext");

                    b.Property<string>("Password")
                        .IsRequired()
                        .HasColumnType("longtext");

                    b.Property<DateTime>("UpdatedAt")
                        .HasColumnType("datetime(6)");

                    b.HasKey("UsersId");

                    b.ToTable("user");
                });

            modelBuilder.Entity("MoviesRec.Models.Movies", b =>
                {
                    b.HasOne("MoviesRec.Models.Users", "Author")
                        .WithMany("AuthorReview")
                        .HasForeignKey("UsersId")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();

                    b.Navigation("Author");
                });

            modelBuilder.Entity("MoviesRec.Models.UserLikes", b =>
                {
                    b.HasOne("MoviesRec.Models.Movies", "Movies")
                        .WithMany("postLikes")
                        .HasForeignKey("MoviesId")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();

                    b.HasOne("MoviesRec.Models.Users", "User")
                        .WithMany("userLikes")
                        .HasForeignKey("UsersId")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();

                    b.Navigation("Movies");

                    b.Navigation("User");
                });

            modelBuilder.Entity("MoviesRec.Models.Movies", b =>
                {
                    b.Navigation("postLikes");
                });

            modelBuilder.Entity("MoviesRec.Models.Users", b =>
                {
                    b.Navigation("AuthorReview");

                    b.Navigation("userLikes");
                });
#pragma warning restore 612, 618
        }
    }
}
