package co.dev.rsp.astronut;

// This file contains questions from Question
public class Questions {

    // array of images of questions
    public int[] question_images_list = {
            R.drawable.andromeda,
            R.drawable.asteroids,
            R.drawable.astronut,
            R.drawable.aurora,
            R.drawable.blackhole,
            R.drawable.earth,
            R.drawable.jupitar,
            R.drawable.mars,
            R.drawable.mercury,
            R.drawable.milkyway,
            R.drawable.moon,
            R.drawable.mooneclipse,
            R.drawable.nebula,
            R.drawable.neilarmstrong,
            R.drawable.neptune,
            R.drawable.observatory,
            R.drawable.planets,
            R.drawable.pluto,
            R.drawable.saturn,
            R.drawable.shootingstar,
            R.drawable.solareclipse,
            R.drawable.solarflare,
            R.drawable.solarsystem,
            R.drawable.spaceshuttle,
            R.drawable.starcluster,
            R.drawable.stars,
            R.drawable.sun,
            R.drawable.supernova,
            R.drawable.telescope,
            R.drawable.ufo,
            R.drawable.universe,
            R.drawable.uranus,
            R.drawable.venus,
            R.drawable.world
    };

    // array of multiple choices for each question
    private String multipleChoice [][] = {
            {"Andromeda","Milky-way","Planets","Aurora"},
            {"Universe","Black-hole","Asteroid","Moon"},
            {"Stars","Observatory","Astronaut","Neil Armstrong"},
            {"Pluto","Universe","Milky-way","Aurora"},
            {"World","Star","Black-hole","Solar Flare"},
            {"Earth","Pluto","UFO","Neptune"},
            {"Moon","Jupiter","Supernova","Space Shuttle"},
            {"Venus","Mars","Sun","Star"},
            {"Moon Eclipse","Pluto","Solar System","Mercury"},
            {"Milky-way","World","Star Cluster","Andromeda","Pluto"},
            {"Black-hole","Pluto","Asteroid","Moon"},
            {"Astronaut","Star","Moon Eclipse","Solar Flare"},
            {"Black-hole","Nebula","Venus","Telescope"},
            {"Neil Armstrong","Astronaut","Star","Moon"},
            {"Astronaut","Neptune","Aurora","Saturn"},
            {"Observatory","Supernova","Venus","World"},
            {"Universe","Planets","Space Shuttle","UFO"},
            {"Moon","Solar Flare","Pluto","Black-hole"},
            {"Moon Eclipse","Saturn","Asteroid","Telescope"},
            {"Shooting Star", "Pluto","Black-hole","UFO"},
            {"Supernova","World","Solar Flare","Solar Eclipse"},
            {"Moon Eclipse","Andromeda","Solar Flare","Mars"},
            {"Solar System", "Earth","Black-hole","Stars"},
            {"Sun","Star","World","Space Shuttle"},
            {"Moon","Earth","Star","Star Cluster"},
            {"Black-hole","Star","Nebula","Andromeda"},
            {"Solar System","Mercury","Sun","Aurora",},
            {"Aurora","Supernova","Andromeda","Asteroid"},
            {"Star","Moon","Telescope","Astronaut"},
            {"UFO","Star","Astronaut","Moon Eclipse","World"},
            {"Andromeda","Universe","Aurora", "Black-hole"},
            {"Planets","Saturn","Uranus", "Solar System"},
            {"Venus","Mars","Jupiter", "Pluto"},
            {"Nebula","Black-hole","World","Supernova"}
    };

    // array of correct answers - in the same order as array of questions
    private String correct_answer[] = {
            "Andromeda",
            "Asteroid",
            "Astronaut",
            "Aurora",
            "Black-hole",
            "Earth",
            "Jupiter",
            "Mars",
            "Mercury",
            "Milky-way",
            "Moon",
            "Moon Eclipse",
            "Nebula",
            "Neil Armstrong",
            "Neptune",
            "Observatory",
            "Planets",
            "Pluto",
            "Saturn",
            "Shooting Star",
            "Solar Eclipse",
            "Solar Flare",
            "Solar System",
            "Space Shuttle",
            "Star Cluster",
            "Star",
            "Sun",
            "Supernova",
            "Telescope",
            "UFO",
            "Universe",
            "Uranus",
            "Venus",
            "World"
    };

    // method returns number of questions
    public int getLength(){
        return question_images_list.length;
    }

    // method returns question from array question_images_list based on array index
    public int get_question(int a){
        return question_images_list[a];
    }

    // method return a single multiple choice item for question based on array index,
    // based on number of multiple choice item in the list - 1, 2, 3 or 4 as an argument
    public String get_choice(int index, int num) {
        return multipleChoice[index][num-1];
    }

    //  method returns correct answer for the question based on array index
    public String get_correct_answer(int a){
        return correct_answer[a];
    }

}
