using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace MoviesRec.Migrations
{
    public partial class ThirdMigration : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_userLikes_movie_MoviesMovieId",
                table: "userLikes");

            migrationBuilder.DropIndex(
                name: "IX_userLikes_MoviesMovieId",
                table: "userLikes");

            migrationBuilder.DropColumn(
                name: "MoviesMovieId",
                table: "userLikes");

            migrationBuilder.RenameColumn(
                name: "MovieId",
                table: "userLikes",
                newName: "MoviesId");

            migrationBuilder.RenameColumn(
                name: "MovieId",
                table: "movie",
                newName: "MoviesId");

            migrationBuilder.CreateIndex(
                name: "IX_userLikes_MoviesId",
                table: "userLikes",
                column: "MoviesId");

            migrationBuilder.AddForeignKey(
                name: "FK_userLikes_movie_MoviesId",
                table: "userLikes",
                column: "MoviesId",
                principalTable: "movie",
                principalColumn: "MoviesId",
                onDelete: ReferentialAction.Cascade);
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_userLikes_movie_MoviesId",
                table: "userLikes");

            migrationBuilder.DropIndex(
                name: "IX_userLikes_MoviesId",
                table: "userLikes");

            migrationBuilder.RenameColumn(
                name: "MoviesId",
                table: "userLikes",
                newName: "MovieId");

            migrationBuilder.RenameColumn(
                name: "MoviesId",
                table: "movie",
                newName: "MovieId");

            migrationBuilder.AddColumn<int>(
                name: "MoviesMovieId",
                table: "userLikes",
                type: "int",
                nullable: true);

            migrationBuilder.CreateIndex(
                name: "IX_userLikes_MoviesMovieId",
                table: "userLikes",
                column: "MoviesMovieId");

            migrationBuilder.AddForeignKey(
                name: "FK_userLikes_movie_MoviesMovieId",
                table: "userLikes",
                column: "MoviesMovieId",
                principalTable: "movie",
                principalColumn: "MovieId");
        }
    }
}
