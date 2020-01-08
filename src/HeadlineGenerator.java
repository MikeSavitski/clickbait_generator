import java.util.Random;

public class HeadlineGenerator {

    private String inspiration;

    public HeadlineGenerator( String inspiration ) {

        this.inspiration = inspiration;

    }

    public String getHeadline() {

        String headline = "";

        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        int random_int = random.nextInt(10);
        int rnd = random.nextInt(21);

        switch (random_int) {
            case 0:
                headline = "Problems with " + inspiration + "? Click here!";
                break;
            case 1:
                headline = (rnd - 1) + "/" + rnd + " doctors reccomend this " + inspiration + "!";
                break;
            case 2:
                headline = inspiration + "? See what experts think!";
                break;
            case 3:
                headline = "Celebrities' top " + rnd + " tips for great " + inspiration + "!";
                break;
            case 4:
                headline = rnd + " things about " + inspiration + " the government doesn't want you to know!";
                break;
            case 5:
                headline = "Got " + inspiration + "? Find out why you might be in trouble!";
                break;
            case 6:
                headline = "Missing " + inspiration + " found after " + rnd + " years!";
                break;
            case 7:
                headline = "Ever wonder about " + inspiration + "? Click for answers!";
                break;
            case 8:
                headline = "Don't ever leave home without this " + inspiration + " again!";
                break;
            case 9:
                headline = "The President doesn't want you to know about their " + inspiration + " problem!";
                break;
            case 10:
                headline = "Change your life with these " + rnd + " " + inspiration + " hacks!";
                break;


        }

        return headline;

    }

}
