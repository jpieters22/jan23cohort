using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using System.ComponentModel.DataAnnotations;

namespace DojoSurvey.Models
{

    public class SurveyModel
    {
        [Required]
        [MinLength(2)]
        public string Name{get; set;}

        [Required]
        public string Location{get; set;}

        [Required]
        public string Language{get; set;}

        [MaxLength(20)]
        public string Comments{get; set;}
    }
}