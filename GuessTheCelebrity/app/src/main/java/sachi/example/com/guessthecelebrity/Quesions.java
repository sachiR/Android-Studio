package sachi.example.com.guessthecelebrity;

public class Quesions {
    public int[] images_list = {
            R.drawable.bi,
            R.drawable.chanyeol,
            R.drawable.gd,
            R.drawable.jackson,
            R.drawable.jennie,
            R.drawable.jimin,
            R.drawable.jisoo,
            R.drawable.rose,
            R.drawable.siwon,
            R.drawable.taeyeon,
            R.drawable.tiffany,
            R.drawable.v,
            R.drawable.victoria,
    };

    private String mChoices[][] = {
            {"IKON - BI","BTS - TAEHYUNG","BIG BANG - GD","GOT7 - JACKSON"},
            { "SUPER JUNIOR - SIWON","BTS - JIMIN","EXO - CHANYEOL","BIG BANG - GD"},
            { "IKON - BI","EXO - CHANYEOL","BIG BANG - GD","GOT7 - JACKSON"},
            {"GOT7 - JACKSON", "BLACKPINK - JENNIE","BTS - JIMIN", "BLACKPINK - JISOO"},
            {"BLACKPINK - JISOO","BLACKPINK - ROSE","SNSD - TAEYEON","BLACKPINK - JENNIE"},
            {"EXO - CHANYEOL","BTS - TAEHYUNG","BTS - JIMIN","BIG BANG - GD"},
            { "BLACKPINK - JENNIE", "IKON - BI", "BLACKPINK - JISOO","BLACKPINK - ROSE"},
            {"BLACKPINK - JISOO","BLACKPINK - ROSE","SNSD - TAEYEON", "SNSD - TIFFANY"},
            {"IKON - BI","EXO - CHANYEOL","BIG BANG - GD","SUPER JUNIOR - SIWON"},
            {"SNSD - TAEYEON", "SNSD - TIFFANY", "BLACKPINK - JENNIE", "F(X) - VICTORIA"},
            {"F(X) - VICTORIA", "SNSD - TAEYEON", "SNSD - TIFFANY", "BLACKPINK - JISOO"},
            { "BTS - TAEHYUNG","BTS - JIMIN","IKON - BI","EXO - CHANYEOL"},
            { "BLACKPINK - JISOO","BLACKPINK - ROSE","F(X) - VICTORIA", "SNSD - TAEYEON"},
    };

    public String correctAnswer[] = {
            "IKON - BI","EXO - CHANYEOL","BIG BANG - GD","GOT7 - JACKSON", "BLACKPINK - JENNIE",
            "BTS - JIMIN", "BLACKPINK - JISOO","BLACKPINK - ROSE", "SUPER JUNIOR - SIWON", "SNSD - TAEYEON",
            "SNSD - TIFFANY", "BTS - TAEHYUNG", "F(X) - VICTORIA"
    };

    public int getQuestion(int a){
        int question = images_list[a];
        return question;
    }

    public String getChoice1(int a){
        String choice = mChoices[a][0];
        return choice;
    }

    public String getChoice2(int a){
        String choice = mChoices[a][1];
        return choice;
    }

    public String getChoice3(int a){
        String choice = mChoices[a][2];
        return choice;
    }

    public String getChoice4(int a){
        String choice = mChoices[a][3];
        return choice;
    }

    public String getCorrectAnswer(int a){
        String answer = correctAnswer[a];
        return answer;
    }

}
